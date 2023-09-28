package _02DataTypesAndVariables_Lab;

import java.util.Scanner;

public class _10SpecialNumbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());

		for (int i = 1; i <= n; i++) {

			int currentNum = i;
//			String currentNum = i + "";
			int sum = 0;
//			for (int j = 0; j < currentNum.length(); j++) {
//				sum += Integer.parseInt(String.valueOf(currentNum.charAt(j)));
//			}

			while(currentNum > 0) {
				sum += (currentNum % 10);
				currentNum /= 10;
			}

			if(sum == 5 || sum == 7 || sum == 11) {
				System.out.printf("%d -> True%n", i);
			} else {
				System.out.printf("%d -> False%n", i);
			}
		}
	}
}