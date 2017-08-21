package lesson5.homework5.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class FuncTest3 {

	Employee Employee = new Employee();

	@BeforeClass
	public static void StartMessage() {
		System.out.println("FuncTest3 testing started . . .");
		}

	@AfterClass
	public static void FinishMessage() {
		System.out.println("FuncTest3 testing completed.");
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
	public void testOther () { 
	}
	 
		@Test
		public void testFactSalary () { //��������
			double expected = 36557.2;
			double actual = Employee.factSalary(11353.7, 14689.7, 8356.5, 2157.3);
			assertEquals("Test FactSalary - failure", expected, actual, 0.001); 
		}

		@Test
		public void testGrade () { //����� ����������
	 		double expected = 4.3;
			double actual = Employee.grade(4.0, 6.4, 2.5);
			assertEquals("Test Grade - failure", expected, actual, 0.001); 
		}

		@Test
		public void testFactCompensationAuto () { //����������� ������������� ���������� � ������� �����
			double expected = 7924.5;
			double actual = Employee.factCompensationAuto(2357.3, 5567.2);
			assertEquals("Test FactCompensationAuto - failure", expected, actual, 0.001); 
		}

		@Test
		public void testFactCompensationAmmortizationAuto () { //����������� ������������ ����������
			double expected = 6425.25;
			double actual = Employee.factCompensationAmmortizationAuto(8567, 0.75);
			assertEquals("Test FactCompensationAmmortizationAuto - failure", expected, actual, 0.001); 
		}
	
}
