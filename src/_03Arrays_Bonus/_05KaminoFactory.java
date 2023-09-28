package _03Arrays_Bonus;

import java.util.Arrays;
import java.util.Scanner;

public class _05KaminoFactory {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int seqLength = Integer.parseInt(scanner.nextLine());

		int maxSum = 0;
		int minIndex = seqLength - 1;
		int bestSeqIndex = -1;

		int[] subsequence = new int[seqLength];
		int[] startInx = new int[seqLength];

		String command;
		int index = -1;
		while(!(command = scanner.nextLine()).equals("Clone them!")) {
			int[] numbers = Arrays.stream(command.split("!")).mapToInt(Integer::parseInt).toArray();
			int sum = 1;
			index++;
			int occurrence = 1;

			for (int i = 0; i < numbers.length; i++) {
				if(i == numbers.length - 1 && numbers[i] == 1) {
					sum += numbers[i];
				} else if(numbers[i] == 1 && numbers[i + 1] == 1) {
					sum += numbers[i];
				}

				if(numbers[i] == 1 && occurrence == 1) {
					startInx[index] = i;
					occurrence++;
				}
			}

			if(sum > maxSum) {
				maxSum = sum;
				bestSeqIndex = index + 1;
				subsequence = Arrays.copyOf(numbers, numbers.length);
			} else if(sum == maxSum) {
				if(startInx[index] < minIndex) {
					minIndex = startInx[index];
					bestSeqIndex = index + 1;
					subsequence = Arrays.copyOf(numbers, numbers.length);
				}
			}
		}

		System.out.printf("Best DNA sample %d with sum: %d.%n", bestSeqIndex, maxSum);
		String res = "";
		for (int s : subsequence) {
			res += s + " ";
		}
		System.out.println(res.trim());
	}
}
