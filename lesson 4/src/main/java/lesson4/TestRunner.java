package lesson4;

import java.sql.SQLException;

public interface TestRunner {
	public String selectSqlQuery (String myQuery) throws SQLException;
	public void runTest(int testNumber);
	public boolean checkTestStatus(int testNumber, boolean status);
	public void restartTest(int testNumber);
	public String printEnvironmentDecription();
}
