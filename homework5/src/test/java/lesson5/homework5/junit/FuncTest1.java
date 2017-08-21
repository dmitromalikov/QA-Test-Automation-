package lesson5.homework5.junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)

public class FuncTest1 {

	@BeforeClass
	public static void StartMessage() {
		System.out.println("FuncTest1 testing started . . .");
		}

	@AfterClass
	public static void FinishMessage() {
		System.out.println("FuncTest1 testing completed.");
		}

	@Before
	public void StartTestMessage() {
		System.out.println("The next test is started . . .");
		}

	@After
	public void FinishTestMessage() {
		System.out.println("The test is completed.");
		}

	 @Rule
	 public Timeout timeout = Timeout.seconds(10);
	 
	@Ignore
	public void testOther () {}
	 
	   public int firstParameter;
	   public int secondParameter;
	   public int expectedResult;
	
	public FuncTest1(int firstParameter, int secondParameter, int expectedResult){
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
        this.expectedResult = expectedResult;
	}
	
	 	@Test
	 	
		public void testDaysWorkedInMonth () { //���������� ������������ ���� � ������
	 		Employee Employee = new Employee();
			int actualResult = Employee.daysWorkedInMonth(firstParameter, secondParameter);
			assertEquals("Test DaysWorkedInMonth - failure", expectedResult, actualResult); 
		}
	 		 	
		  @Parameterized.Parameters
		     public static Collection<Object[]> getTestData() {
		           return Arrays.asList(new Object[][]{
		         {22, 2, 20},
		         {23, 1, 22},
		         {20, 5, 15},
		         {90, 21, 69},
		         {56, 11, 45},
		         {256, 134, 122},
		         {351, 63, 288},
		         {121, 21, 100},
		     });
		  }
}