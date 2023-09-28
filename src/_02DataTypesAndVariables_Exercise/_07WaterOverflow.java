package _02DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class _07WaterOverflow {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		byte timesPoured = Byte.parseByte(scanner.nextLine());
		int sum = 0;
		for (int i = 1; i <= timesPoured; i++) {
			short litersPoured = Short.parseShort(scanner.nextLine());
			if(255 - sum >= litersPoured) {
				sum += litersPoured;
			} else {
				System.out.println("Insufficient capacity!");
			}
		}
		System.out.println(sum);
	}
}