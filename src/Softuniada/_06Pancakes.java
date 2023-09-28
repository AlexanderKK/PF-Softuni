package Softuniada;

import java.util.Arrays;
import java.util.Scanner;

public class _06Pancakes {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int currentSum = numbers[0];
		int currentStartIndex = 0;
		int maxSum = numbers[0];
		int maxStartIndex = 0;
		int maxEndIndex = 0;

		for (int i = 1; i < numbers.length; i++) {
			if (currentSum < 0) {
				currentSum = numbers[i];
				currentStartIndex = i;
			} else {
				currentSum += numbers[i];
			}

			if (currentSum > maxSum || (currentSum == maxSum && (i - currentStartIndex > maxEndIndex - maxStartIndex))) {
				maxSum = currentSum;
				maxStartIndex = currentStartIndex;
				maxEndIndex = i;
			}
		}

		System.out.printf("%d %d %d%n", maxSum, maxStartIndex, maxEndIndex);
	}
}
