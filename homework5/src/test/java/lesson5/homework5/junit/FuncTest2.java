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

public class FuncTest2 {
	
	Employee Employee = new Employee();

	@BeforeClass
	public static void StartMessage() {
		System.out.println("FuncTest2 testing started . . .");
		}

	@AfterClass
	public static void FinishMessage() {
		System.out.println("FuncTest2 testing completed.");
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
	
	@Test
	public void testFactCompensationFuelAuto () { //����������� ������� ����
		double expected = 18496.153;
		double actual = Employee.factCompensationFuelAuto(8567, 25.40, 8.5);
		assertEquals("Test FactCompensationFuelAuto - failure", expected, actual, 0.001);
	}

	@Test
	public void testFactCarMileagePerMonth () { //����������� ������ ���� �� �����
		int expected = 8547;
		int actual = Employee.factCarMileagePerMonth(407, 21);
		assertEquals("Test FactCarMileagePerMonth - failure", expected, actual); 
	}

	@Test
	public void testFactBonus () { //����� �� ���������� ������
		double expected = 372.9009228;
		double actual = Employee.factBonus(11353.7, 1.15, 1.19, 1.2);
		assertEquals("Test FactCompensationFuelAuto - failure", expected, actual, 0.001);
	}

	@Test
	public void testFactRate () { //���� ������
		double expected = 10837.62272727273;
		double actual = Employee.factRate(11353.7, 21, 22);
		assertEquals("Test FactRate - failure", expected, actual, 0.001);
	}

	@Test
	public void testSingleTax () { //������ ����� �������� ���������������
		double expected = 1639.4875;
		double actual = Employee.singleTax(32789.75, 5);
		assertEquals("Test SingleTax - failure", expected, actual, 0.001);
	}

	@Test
	public void testSocialContribution () { //���������� ����� �������� ����������������

		double expected = 721.435;
		double actual = Employee.socialContribution(3279.25, 22);
		assertEquals("Test SocialContribution - failure", expected, actual, 0.001);
	}

	@Test
	public void testCompensationOfTaxes () { //����������� �������

		double expected = 2360.9225;
		double actual = Employee.compensationOfTaxes(721.435, 1639.4875);
		assertEquals("Test CompensationOfTaxes - failure", expected, actual, 0.001);
	}

	@Ignore
	public void testOther () { 
	}
	
}
