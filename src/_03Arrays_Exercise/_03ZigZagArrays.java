package _03Arrays_Exercise;

import java.util.Scanner;

public class _03ZigZagArrays {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());

		int[] redNumbers = new int[n];
		int[] blackNumbers = new int[n];

		for (int i = 1; i <= n; i++) {
			String input = scanner.nextLine();
			int first = Integer.parseInt(input.split(" ")[0]);
			int second = Integer.parseInt(input.split(" ")[1]);

			if(i % 2 != 0) {
				redNumbers[i - 1] = first;
				blackNumbers[i - 1] = second;
			} else {
				redNumbers[i - 1] = second;
				blackNumbers[i - 1] = first;
			}
		}

		for (int redNumber: redNumbers) {
			System.out.print(redNumber + " ");
		}
		System.out.println();
		for (int blackNumber : blackNumbers) {
			System.out.print(blackNumber + " ");
		}
	}
}
