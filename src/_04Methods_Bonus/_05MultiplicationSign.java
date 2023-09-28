package _04Methods_Bonus;

import java.util.Scanner;

public class _05MultiplicationSign {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double num1 = Double.parseDouble(scanner.nextLine());
		double num2 = Double.parseDouble(scanner.nextLine());
		double num3 = Double.parseDouble(scanner.nextLine());

		checkSign(num1, num2, num3);
	}

	public static void checkSign(double number1, double number2, double number3) {
		boolean isZero = number1 == 0 || number2 == 0 || number3 == 0;
		boolean isNegative = number1 < 0 && number2 > 0 && number3 > 0 ||
				number1 > 0 && number2 < 0 && number3 > 0 ||
				number1 > 0 && number2 > 0 && number3 < 0 ||
				number1 < 0 && number2 < 0 && number3 < 0;
		if(isZero) {
			System.out.println("zero");
		} else if(isNegative) {
			System.out.println("negative");
		} else {
			System.out.println("positive");
		}
	}
}
