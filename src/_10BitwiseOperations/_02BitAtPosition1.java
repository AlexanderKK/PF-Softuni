package _10BitwiseOperations;

import java.util.Scanner;

public class _02BitAtPosition1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//Bitwise Operation
		int n = Integer.parseInt(scanner.nextLine());

		//Shift all bits to the right and return bit at position 0 (last one)
		int bitAtPosition1 = n >> 1;

		//Bitwise AND (0 & 1 = 0 | 1 & 1 = 1) -> if bit is 1 - return 1, if bit is 0 - return 0
		int bitResult = bitAtPosition1 & 1;

		//Print bit at position 0
		System.out.println(bitResult);

//		int number = Integer.parseInt(scanner.nextLine());
//		int counter = 0;
//		for (int i = number; i > 0; i /= 2) {
//			if(counter == 1) {
//				System.out.println(i % 2);
//				break;
//			}
//			counter++;
//		}
	}
}
