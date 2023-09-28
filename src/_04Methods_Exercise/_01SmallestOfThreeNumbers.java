package _04Methods_Exercise;

import java.util.Scanner;

public class _01SmallestOfThreeNumbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int first = Integer.parseInt(scanner.nextLine());
		int second = Integer.parseInt(scanner.nextLine());
		int third = Integer.parseInt(scanner.nextLine());

		getSmallestOfThreeNumbers(first, second, third);
	}

	public static void getSmallestOfThreeNumbers(int first, int second, int third) {
		if(first < second && first < third) {
			System.out.println(first);
		} else if(second < first && second < third) {
			System.out.println(second);
		} else {
			System.out.println(third);
		}
	}
}
