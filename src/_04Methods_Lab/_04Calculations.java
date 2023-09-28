package _04Methods_Lab;

import java.util.Scanner;

public class _04Calculations {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String operation = scanner.nextLine();
		int firstNum = Integer.parseInt(scanner.nextLine());
		int secondNum = Integer.parseInt(scanner.nextLine());

		switch (operation) {
			case "add" -> add(firstNum, secondNum);
			case "subtract" -> subtract(firstNum, secondNum);
			case "multiply" -> multiply(firstNum, secondNum);
			case "divide" -> divide(firstNum, secondNum);
		}
	}

	public static void add(int first, int second) {
		System.out.println(first + second);
	}

	public static void subtract(int first, int second) {
		System.out.println(first - second);
	}

	public static void multiply(int first, int second) {
		System.out.println(first * second);
	}

	public static void divide(int first, int second) {
		System.out.println(first / second);
	}
}
