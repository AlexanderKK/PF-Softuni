package _04Methods_Exercise;

import java.util.Scanner;

public class _05AddAndSubtract {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int first = Integer.parseInt(scanner.nextLine());
		int second = Integer.parseInt(scanner.nextLine());
		int third = Integer.parseInt(scanner.nextLine());

		System.out.println(subtract(sum(first, second), third));
	}

	public static int sum(int first, int second) {
		return first + second;
	}

	public static int subtract(int first, int second) {
		return first - second;
	}
}
