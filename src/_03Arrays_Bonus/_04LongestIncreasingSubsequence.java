package _03Arrays_Bonus;

import java.util.*;

public class _04LongestIncreasingSubsequence {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[] lengths = new int[numbers.length];
		int[] previous = new int[numbers.length];

		int maxLength = 0;
		int lastIndex = -1;

		for (int i = 0; i < numbers.length; i++) {
			lengths[i] = 1;

			for (int j = 0; j < i; j++) {
				if(numbers[j] < numbers[i] && lengths[j] + 1 > lengths[i]) {
					lengths[i] = lengths[j] + 1;
					previous[i] = j;
				}
			}

			if(maxLength < lengths[i]) {
				maxLength = lengths[i];
				lastIndex = i;
			}
		}

		int[] LIS = new int[maxLength];

		for (int ind = maxLength - 1; ind >= 0 ; ind--) {
			LIS[ind] = numbers[lastIndex];
			lastIndex = previous[lastIndex];
		}

		String result = "";
		for (int i = 0; i < LIS.length; i++) {
			result += LIS[i] + " ";
		}
		System.out.println(result.trim());
	}
}
