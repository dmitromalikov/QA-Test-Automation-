package lesson4_1;

import java.io.IOException;
import java.sql.SQLException;

import jxl.JXLException;

public class Runner {

	public static void main(String[] args) throws SQLException, IOException, JXLException {
		System.out.println("Launching the Database Testing Framework...");
		TestEnvironment myInstance = new TestEnvironment();
		myInstance.initialiseEnvironmentVariables();
		myInstance.createEnvironment();
		myInstance.runTests();
		System.out.println("Work completed successfully ! ! !");
	}
}
