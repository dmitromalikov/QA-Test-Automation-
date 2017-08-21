package lesson5.homework5.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses(
		{
FuncTest1.class,
FuncTest2.class,
FuncTest3.class
	}
		)
	public class FuncSuite {
	
}
	
