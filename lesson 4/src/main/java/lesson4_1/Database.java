package lesson4_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

private String DATABASE_DRIVER;
private String databaseURL;
private String username;
private String password;
private String pathToSQLScriptsCreateAndFill;


	public Database(String DATABASE_DRIVER, String databaseURL, String username, String password, String pathToSQLScriptsCreateAndFill) {
		this.DATABASE_DRIVER = DATABASE_DRIVER;
		this.databaseURL = databaseURL;
		this.username = username;
		this.password = password;
		this.pathToSQLScriptsCreateAndFill = pathToSQLScriptsCreateAndFill;
		}

	public void createStructureSQLAndFillData() throws SQLException, IOException {         //Connection to database;
		Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(DATABASE_DRIVER);
            connection = DriverManager.getConnection(databaseURL, username, password);
            File fileSQLScriptToCreateTables = new File(pathToSQLScriptsCreateAndFill);
			BufferedReader buffer = new BufferedReader(new FileReader(fileSQLScriptToCreateTables));
            String sqlStatement = "";
			System.out.println("Database creation " + databaseURL + "...");
			System.out.println("Filling the database with test data...");
			while ((sqlStatement = buffer.readLine()) != null) {
//				System.out.println(sqlStatement);
				statement = connection.createStatement();
				statement.executeUpdate(sqlStatement);
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
    }
}