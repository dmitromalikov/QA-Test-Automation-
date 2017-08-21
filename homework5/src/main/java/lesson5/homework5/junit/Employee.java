package lesson5.homework5.junit;


public class Employee {

		public double grade (double evaluationForCertification, double evaluationForTests, double averagePerformanceOfPlansForLast3Years) { //����� ����������
			double result = (evaluationForCertification + evaluationForTests + averagePerformanceOfPlansForLast3Years) / 3;
		return result;
		}
		
		public double factSalary (double factRate, double factBonus, double factCompensationAuto, double compensationOfTaxes) { //��������
			double result = (factRate + factBonus + factCompensationAuto + compensationOfTaxes);
		return result;
		}
		
		public int daysWorkedInMonth (int workingDaysInTheMonth, int numberOfDaysOff) { //���������� ������������ ���� � ������
		int result = (workingDaysInTheMonth - numberOfDaysOff);
		return result;
		}
		
		public double factCompensationAuto (double factCompensationAmmortizationAuto, double factCompensationFuelAuto) { //����������� ������������� ���������� � ������� �����
			double result = (factCompensationAmmortizationAuto + factCompensationFuelAuto);
		return result;
		}
		
		public double factCompensationAmmortizationAuto (int factCarMileagePerMonth, double compensationOfUahPer1Km) { //����������� ������������ ����������
			double result = (factCarMileagePerMonth * compensationOfUahPer1Km);
		return result;
		}
		
		public double factCompensationFuelAuto (int factCarMileagePerMonth, double priceOfGasolinePerLiter, double fuelConsumptionLitersPer100Kilometers) { //����������� ������� ����
			double result = (priceOfGasolinePerLiter * factCarMileagePerMonth / 100 * fuelConsumptionLitersPer100Kilometers);
		return result;
		}
		
		public int factCarMileagePerMonth (int carMileagePerDay, int daysWorkedInMonth) { //����������� ������ ���� �� �����
		int result = (carMileagePerDay * daysWorkedInMonth);
		return result;
		}
		
		public double factBonus (double baseRate, double factKpi1, double factKpi2, double factKpi3) { //����� �� ���������� ������
			double result = (baseRate / 100 * 2 * (factKpi1 * factKpi2 * factKpi3));
		return result;
		}
		
		public double factRate (double baseRate, int daysWorkedInMonth, int workingDaysInTheMonth) { //���� ������
			double result = (baseRate / workingDaysInTheMonth * daysWorkedInMonth);
		return result;
		}
		
		public double singleTax (double amountOfIncome, int percentOfSingleTax) { //������ ����� �������� ���������������
			double result = (amountOfIncome/100 * percentOfSingleTax);
		return result;
		}
		
		public double socialContribution (double minimalSalary, double percentOfSocContr) { //���������� ����� �������� ����������������
			double result = (minimalSalary * (percentOfSocContr / 100));
		return result;
		}
		
		public double compensationOfTaxes (double socialContribution, double singleTax) { //����������� �������
			double result = (socialContribution + singleTax);
		return result;
		}
		
	
		// TODO Auto-generated method stub

	}

