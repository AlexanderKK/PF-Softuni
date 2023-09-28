package _13ExamPreparation1;

import java.util.Scanner;

public class _01TheImitationGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		StringBuilder msg = new StringBuilder(scanner.nextLine());
		String input;
		while(!"Decode".equals(input = scanner.nextLine())) {
			String[] strArr = input.split("\\|");

			String cmd = strArr[0];
			if(cmd.equals("Move")) {
				int lettersToMove = Integer.parseInt(strArr[1]);

				if(lettersToMove > 0 && lettersToMove <= msg.length()) {
					String letters = msg.substring(0, lettersToMove);
					msg.replace(0, lettersToMove, "");
					msg.append(letters);
				}
			} else if(cmd.equals("Insert")) {
				int index = Integer.parseInt(strArr[1]);
				String value = strArr[2];

				if(index >= 0 && index <= msg.length()) {
					msg.insert(index, value);
				}
			} else if(cmd.equals("ChangeAll")) {
				String substring = strArr[1];
				String replacement = strArr[2];

				String message = msg.toString();
				msg.delete(0, msg.length());
				msg.append(message.replace(substring, replacement));
			}
		}

		System.out.printf("The decrypted message is: %s%n", msg);
	}
}
