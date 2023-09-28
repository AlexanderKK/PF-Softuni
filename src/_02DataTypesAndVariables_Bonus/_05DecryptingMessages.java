package _02DataTypesAndVariables_Bonus;

import java.util.Scanner;

public class _05DecryptingMessages {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		byte key = Byte.parseByte(scanner.nextLine());
		byte lines = Byte.parseByte(scanner.nextLine());

		String msg = "";
		for (int i = 1; i <= lines; i++) {
			char letter = scanner.nextLine().charAt(0);
			msg += (char)(letter + key);
		}
		System.out.println(msg);
	}
}