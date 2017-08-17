package lesson4_1;

import java.io.*;
import java.sql.SQLException;
import java.util.Properties;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class TestEnvironment {
	public static final String DATA_FILE = "src\\main\\java\\lesson4_1\\libs\\Framework.ini";
	private String pathToExcelFileComplexchecklist = "";
	private String pathToExcelFileTestReport = "";
	static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private String databaseURL = "";
	private String username = "";
	private String password = "";
	private String pathToSQLScriptsCreateAndFill = "";
	private String pathToSQLScriptsTestCaseQueries = "";
	
	public String getValueFromFile (String filename, String variableName) throws IOException {
		System.out.println("Reading the source data from the file " + DATA_FILE);
		String value = "";
	        FileInputStream fis;
	        Properties property = new Properties();
	 
	        try {
	            fis = new FileInputStream(filename);
	            property.load(fis);
	            value = property.getProperty(variableName);
//	            System.out.println(variableName + " = " + value);
	 
	        } catch (IOException e) {
	            System.err.println("ERROR: File " + filename + " not found!");
	        }
			return value;
	}
	
	public void initialiseEnvironmentVariables() throws IOException {
		this.pathToExcelFileComplexchecklist = getValueFromFile(DATA_FILE, "pathToExcelFileComplexchecklist");
		this.pathToExcelFileTestReport = getValueFromFile(DATA_FILE, "pathToExcelFileTestReport");
		this.databaseURL = getValueFromFile(DATA_FILE, "databaseURL");
		this.username = getValueFromFile(DATA_FILE, "username");
		this.password = getValueFromFile(DATA_FILE, "password");
		this.pathToSQLScriptsCreateAndFill = getValueFromFile(DATA_FILE, "pathToSQLScriptsCreateAndFill");		
		this.pathToSQLScriptsTestCaseQueries = getValueFromFile(DATA_FILE, "pathToSQLScriptsTestCaseQueries");
		System.out.println("Initializing data ...");
	
	}
	
	void createEnvironment() throws SQLException, IOException {
		Database myDatabase = new Database(DATABASE_DRIVER, databaseURL, username, password, pathToSQLScriptsCreateAndFill);
		myDatabase.createStructureSQLAndFillData();
		}
	
	void runTests() throws WriteException, IOException, SQLException {
		Test myTest = new Test(DATABASE_DRIVER, databaseURL, username, password, pathToSQLScriptsCreateAndFill);
		myTest.readDataFromExcelAndCreateCollections(pathToExcelFileComplexchecklist);
//		myTest.readDataAndCreateCollections(DATABASE_DRIVER, databaseURL, username, password, pathToSQLScriptsTestCaseQueries);
		myTest.executeTestCases();
		myTest.generateReports(pathToExcelFileComplexchecklist,pathToExcelFileTestReport);
	}

}