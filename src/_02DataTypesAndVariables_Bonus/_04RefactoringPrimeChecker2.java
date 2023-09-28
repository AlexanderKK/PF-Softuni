package _02DataTypesAndVariables_Bonus;

import java.util.Scanner;

public class _04RefactoringPrimeChecker2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());

		if(n > 0) {
			for (int i = 2; i <= n; i++) {
				boolean isPrime = true;

				for (int j = 2; j < i; j++) {
					if(i % j == 0) {
						isPrime = false;
						break;
					}
				}
				System.out.printf("%d -> %b%n", i, isPrime);
			}
		}
	}
}
