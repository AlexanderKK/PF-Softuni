package _04Methods_Bonus;

import java.util.Scanner;

public class _01DataTypes {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		solveByDataType(scanner.nextLine(), scanner.nextLine());
	}

	public static void solveByDataType(String datatype, String input) {
		if(datatype.equals("int")) {
			System.out.println(solve(Integer.parseInt(input)));
		} else if(datatype.equals("real")) {
			System.out.printf("%.2f%n", solve(Double.parseDouble(input)));
		} else if(datatype.equals("string")) {
			System.out.printf("%s%n", solve(input));
		}
	}

	public static int solve(int number) {
		return number * 2;
	}

	public static double solve(double number) {
		return number * 1.5;
	}

	public static String solve(String text) {
		return String.format("$%s$", text);
	}
}
