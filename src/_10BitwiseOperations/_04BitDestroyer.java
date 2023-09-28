package _10BitwiseOperations;

import java.util.Scanner;

public class _04BitDestroyer {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());
		int p = Integer.parseInt(scanner.nextLine());

		// create a mask with a 0 at the p-th position
		int mask = ~(1 << p);

		// clear the bit at the p-th position
		int newNumber = n & mask;

		//Print New number
		System.out.println(newNumber);
	}
}
