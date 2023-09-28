package _10BitwiseOperations;

import java.util.Scanner;

public class _06TriBitSwitch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int number = Integer.parseInt(scanner.nextLine());
		int pos = Integer.parseInt(scanner.nextLine());

		int mask = 7 << pos; // create a mask with 3 bits starting from position p
		int invertedMask = ~mask; // invert the bits in the mask
		int result = number ^ mask; // XOR the bits in the input number with the bits in the mask
		result = result ^ invertedMask; // XOR the bits in the input number with the inverted bits in the mask

		System.out.println(result);
	}
}
