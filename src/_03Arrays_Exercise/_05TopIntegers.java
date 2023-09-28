package _03Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _05TopIntegers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		String result = "";

		for (int i = 0; i < numbers.length; i++) {
			if(i == numbers.length - 1) {
				result += numbers[i] + " ";
			} else if(numbers[i] > numbers[i + 1]) {
				result += numbers[i] + " ";
			}
		}

		System.out.println(result.trim());
	}
}
