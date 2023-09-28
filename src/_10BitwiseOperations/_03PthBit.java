package _10BitwiseOperations;

import java.util.Scanner;

public class _03PthBit {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int number = Integer.parseInt(scanner.nextLine());

		//Number of shifts
		int shifts = Integer.parseInt(scanner.nextLine());

		int bitAtPositionP = number >> shifts;
		System.out.println(bitAtPositionP & 1);
	}
}
