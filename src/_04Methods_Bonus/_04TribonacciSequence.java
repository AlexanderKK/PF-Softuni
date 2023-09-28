package _04Methods_Bonus;

import java.util.Scanner;

public class _04TribonacciSequence {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());
		printTribonacciSequence(calcTribonacci(n));
	}

	public static int[] calcTribonacci(int limit) {
		int[] tribonacciArr = new int[limit];

		int first = 0, second = 0, third = 0;
		for (int i = 0; i < limit; i++) {
			if(i == 0) {
				first = 1;
				tribonacciArr[i] = first;
			} else if(i == 1) {
				second = 1;
				tribonacciArr[i] = second;
			} else if(i == 2) {
				third = 2;
				tribonacciArr[i] = third;
			} else {
				int next = first + second + third;
				tribonacciArr[i] = next;

				first = second;
				second = third;
				third = next;
			}
		}

		return tribonacciArr;
	}

	public static void printTribonacciSequence(int[] arr) {
		for (int number : arr) {
			System.out.print(number + " ");
		}
	}
}
