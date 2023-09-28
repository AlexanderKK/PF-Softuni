package _04Methods_Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class _11MathOperations {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int firstNumber = Integer.parseInt(scanner.nextLine());
		String operator = scanner.nextLine();
		int secondNumber = Integer.parseInt(scanner.nextLine());

		double result = calcExpression(firstNumber, secondNumber, operator);
		DecimalFormat df = new DecimalFormat("0.##");
		System.out.println(df.format(result));
	}

	public static double calcExpression(int first, int second, String operator) {
		double result = 0;
		switch (operator) {
			case "+":
				result = first + second;
				break;
			case "-":
				result = first - second;
				break;
			case "*":
				result = first * second;
				break;
			case "/":
				result = 1.0 * first / second;
				break;
		}
		return result;
	}
}
