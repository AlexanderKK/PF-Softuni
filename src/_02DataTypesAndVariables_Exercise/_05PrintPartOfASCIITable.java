package _02DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class _05PrintPartOfASCIITable {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		byte startIndex = Byte.parseByte(scanner.nextLine());
		byte endIndex = Byte.parseByte(scanner.nextLine());

		String result = "";
		for (int i = startIndex; i <= endIndex; i++) {

			result += (char)i + " ";
		}
		System.out.println(result.trim());
	}
}