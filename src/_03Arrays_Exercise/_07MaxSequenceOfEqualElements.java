package _03Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _07MaxSequenceOfEqualElements {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int maxLength = 0;
		int seqLength = 1;
		String sequence = "";
		String longestSeq = "";

		for (int i = 0; i < numbers.length; i++) {
			if(numbers.length == 1) {
				longestSeq += numbers[i];
				break;
			}

			if(i != numbers.length - 1 && numbers[i] == numbers[i + 1]) {
				if(seqLength == 1) {
					sequence += numbers[i] + " ";
				}

				seqLength++;
				sequence += numbers[i] + " ";
			} else {
				seqLength = 1;
				sequence = "";
			}

			if(seqLength > maxLength) {
				maxLength = seqLength;
				longestSeq = sequence;
			}
		}
		System.out.println(longestSeq.trim());
	}
}
