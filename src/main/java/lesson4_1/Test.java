package lesson4_1;

import java.util.Locale;
import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import jxl.Cell;
import jxl.Sheet;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.read.biff.BiffException;

public class Test {
	
	private String DATABASE_DRIVER;
	private String databaseURL;
	private String username;
	private String password;
	private String pathToSQLScriptsCreateAndFill;
	String passed = "PASSED";

		public Test(String DATABASE_DRIVER, String databaseURL, String username, String password, String pathToSQLScriptsCreateAndFill) {
			this.DATABASE_DRIVER = DATABASE_DRIVER;
			this.databaseURL = databaseURL;
			this.username = username;
			this.password = password;
			}
	
	Map<Integer, String> testCaseNumberMap = new HashMap<Integer, String>();
	Map<Integer, String> testCaseNameMap = new HashMap<Integer, String>();
	Map<Integer, String> actionToDoMap = new HashMap<Integer, String>();
	Map<Integer, String> expectedResultMap = new HashMap<Integer, String>();
	Map<Integer, String> actualResultMap = new HashMap<Integer, String>();
	Map<Integer, String> testResultMap = new HashMap<Integer, String>();
	
	public void readDataFromExcelAndCreateCollections(String pathToExcelFileComplexchecklist){
		System.out.println("Reading the data of complex test cases from Excel file" + pathToExcelFileComplexchecklist + "...");
		Workbook workbook;
				try {
					workbook = Workbook.getWorkbook(new File(pathToExcelFileComplexchecklist));
				int i = 1;
				while (true){
					testCaseNumberMap.put(i, (workbook.getSheet(0).getCell(0, i).getContents())); 
					testCaseNameMap.put(i, (workbook.getSheet(0).getCell(1, i).getContents())); 
					actionToDoMap.put(i, (workbook.getSheet(0).getCell(2, i).getContents())); 
					expectedResultMap.put(i, (workbook.getSheet(0).getCell(3, i).getContents())); 
					actualResultMap.put(i, (workbook.getSheet(0).getCell(4, i).getContents())); 
					testResultMap.put(i, (workbook.getSheet(0).getCell(5, i).getContents())); 
					i++;
				}
				} catch (BiffException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				catch (ArrayIndexOutOfBoundsException exception) {
					System.out.println("The data from file " + pathToExcelFileComplexchecklist + " is loaded.");
				}
			}		

	public void executeTestCases() throws SQLException {
		System.out.println("Executing Test Cases...");
	    for (int i=1; i <= testCaseNumberMap.size(); i++) {
	    	String actionToDo = actionToDoMap.get(i);
	    	String expectedResult = expectedResultMap.get(i);
	
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        String resultString = "";
        try {
            Class.forName(DATABASE_DRIVER);
            connection = DriverManager.getConnection(databaseURL, username, password);
            statement = connection.createStatement();
            result = statement.executeQuery(actionToDo);
            while (result.next()) {
            	resultString = result.getString(1);
            }
			actualResultMap.put(i, resultString); 
//          if (resultString.equals(expectedResult)) {
            if (resultString.hashCode() == expectedResult.hashCode()) {
            	testResultMap.put(i, "PASSED");
        	} else
        	testResultMap.put(i, "FAILED");
        	}
            
        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
	    }
	}
	    

	public void generateReports(String pathToExcelFileComplexchecklist, String pathToExcelFileTestReport) throws IOException, WriteException, RowsExceededException {
		System.out.println("Generating a test report...");
		
		// create file report and sheet
		WritableWorkbook myWorkbook;
		myWorkbook= Workbook.createWorkbook(new File(pathToExcelFileTestReport));
	    WritableSheet mySheet = myWorkbook.createSheet("Report", 0);
	    WritableFont cellFormat1 = new WritableFont(WritableFont.TIMES, 10);
	    WritableCellFormat cellFormat = new WritableCellFormat(cellFormat1);
	    cellFormat.setBorder(Border.ALL, BorderLineStyle.MEDIUM);
	    cellFormat.setLocked(false);
	    cellFormat.setAlignment(Alignment.CENTRE);
	    WritableCellFormat cellFormatPassed = new WritableCellFormat(cellFormat);
	    cellFormatPassed.setBackground(Colour.LIGHT_GREEN);
	    WritableCellFormat cellFormatFailed = new WritableCellFormat(cellFormat);
	    cellFormatFailed.setBackground(Colour.RED);
		// create headers
	    mySheet.setColumnView(0, 15);
	    mySheet.setColumnView(1, 65);
	    mySheet.setColumnView(2, 14);

	    Label label = new Label(0, 0, "Test case number", cellFormat);
	    mySheet.addCell(label);
	    Label label1 = new Label(1, 0, "Test case name", cellFormat);
	    mySheet.addCell(label1);
	    Label label2 = new Label(2, 0, "Expected result", cellFormat);
	    mySheet.addCell(label2);
	    Label label3 = new Label(3, 0, "Actual result", cellFormat);
	    mySheet.addCell(label3);	  
	    Label label4 = new Label(4, 0, "Result", cellFormat);
	    mySheet.addCell(label4);
	    
		Label[] labels_testCaseNumberMap = new Label[testCaseNumberMap.size()+5];
	    for (int i=1; i<=testCaseNumberMap.size(); i++) {
//	    	System.out.println("i= " + i);
			labels_testCaseNumberMap[i] = new Label(0, i, testCaseNumberMap.get(i), cellFormat);
//	    	System.out.println("labels_testCaseNumberMap[i] = " + toString());
//	    	System.out.println("testCaseNumberMap.get(i) = " + testCaseNumberMap.get(i));
			mySheet.addCell(labels_testCaseNumberMap[i]);
		}
	    
		Label[] labels_testCaseNameMap = new Label[testCaseNumberMap.size()+5];
	    for (int i=1; i<=testCaseNumberMap.size(); i++) {
			labels_testCaseNameMap[i] = new Label(1, i, testCaseNameMap.get(i), cellFormat);
			mySheet.addCell(labels_testCaseNameMap[i]);
	    }
	    
		Label[] labels_expectedResultMap = new Label[testCaseNumberMap.size()+5];
	    for (int i=1; i<=testCaseNumberMap.size(); i++) {
			labels_expectedResultMap[i] = new Label(2, i, expectedResultMap.get(i), cellFormat);
			mySheet.addCell(labels_expectedResultMap[i]);
	    }
	    
		Label[] labels_actualResultMap = new Label[testCaseNumberMap.size()+5];
	    for (int i=1; i<=testCaseNumberMap.size(); i++) {
			labels_actualResultMap[i] = new Label(3, i, actualResultMap.get(i), cellFormat);
			mySheet.addCell(labels_actualResultMap[i]);
	    }
	    
		Label[] labels_testResultMap = new Label[testCaseNumberMap.size()+5];
	    for (int i=1; i<=testCaseNumberMap.size(); i++) {
            if (testResultMap.get(i).hashCode() == passed.hashCode()) {
    			labels_testResultMap[i] = new Label(4, i, testResultMap.get(i), cellFormatPassed);
        	} else
    			labels_testResultMap[i] = new Label(4, i, testResultMap.get(i), cellFormatFailed);
			mySheet.addCell(labels_testResultMap[i]);
        	}
	    
/*	    
		    Label label+i = new Label(0, 0, "Test case number", cellFormat);
		    mySheet.addCell(label);
		    Label label1 = new Label(1, 0, "Test case name", cellFormat);
		    mySheet.addCell(label1);
		    Label label2 = new Label(2, 0, "Result", cellFormat);
		    mySheet.addCell(label2);
	    	Map<Integer, String> testCaseNumberMap = new HashMap<Integer, String>();
	    	Map<Integer, String> testCaseNameMap = new HashMap<Integer, String>();
	    	Map<Integer, String> actionToDoMap = new HashMap<Integer, String>();
	    	Map<Integer, String> expectedResultMap = new HashMap<Integer, String>();
	    	Map<Integer, String> actualResultMap = new HashMap<Integer, String>();
	    	Map<Integer, String> testResultMap = new HashMap<Integer, String>();
	    }
*/	    
		myWorkbook.write();
		myWorkbook.close();
		
		System.out.println("The test report is generated in a file = " + pathToExcelFileTestReport);
		
	}
}

