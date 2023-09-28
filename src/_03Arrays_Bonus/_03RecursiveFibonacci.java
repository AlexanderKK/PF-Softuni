package _03Arrays_Bonus;

import java.util.Scanner;

public class _03RecursiveFibonacci {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());
		System.out.println(GetFibonacci(n));
	}

	public static int GetFibonacci(int n) {
		if(n >= 1 && n <= 50) {
			int[] sequence = new int[n + 1];

			int first = 0, second = 1;
			for (int i = 0; i <= n; i++) {
				if (i == 0) {
					sequence[i] = first;
				} else if (i == 1) {
					sequence[i] = second;
				} else {
					int next = first + second;
					sequence[i] = next;

					first = second;
					second = next;
				}
			}
			return sequence[n];
		} else {
			return 0;
		}
	}
}
