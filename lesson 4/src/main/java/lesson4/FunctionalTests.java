package lesson4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FunctionalTests implements TestRunner{
	
	public String selectSqlQuery(String myQuery) throws SQLException {         //Connection to database;
		String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	    String DATABASE_URL = "jdbc:mysql://localhost:3306/test";
	    String USERNAME = "root";
	    String PASSWORD = "12345";
	    
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        String resultString = "";
        try {
            Class.forName(DATABASE_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            result = statement.executeQuery(myQuery);
            while (result.next()) {
            	resultString = result.getString(1);
            }
            
        } catch (ClassNotFoundException e) {
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
        return resultString;
    }

	public void runTest(int testNumber) {
		System.out.println("Test case ¹ " + testNumber + "is started");

	}		
	

	public boolean checkTestStatus(int testNumber, boolean status) {
		System.out.println("Test case ¹ " + testNumber + "ispassed: " + status);
		return false;
	}

	public void restartTest(int testNumber) {
		System.out.println("Test case ¹ " + testNumber + "is restarted!");
		
	}

	public String printEnvironmentDecription() {
		System.getProperties().list(System.out);
		return null;
	}
	

	}

