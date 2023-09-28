package _13ExamPreparation2;

import java.util.Scanner;

public class _01WorldTour2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();
		String command = scanner.nextLine();
		StringBuilder sb = new StringBuilder(input);

		while (!command.equals("Travel")) {
			String[] commandArr = command.split(":");

			if (command.contains("Add Stop")) {
				int index = Integer.parseInt(commandArr[1]);
				String destination = commandArr[2];

				if (index >= 0 && index <= sb.length() - 1) {
					sb.insert(index, destination);
				}

				System.out.println(sb);
			} else if (command.contains("Remove")) {
				int indexOne = Integer.parseInt(commandArr[1]);
				int indexTwo = Integer.parseInt(commandArr[2]);

				if (indexOne >= 0 && indexTwo >= 0 && indexOne <= sb.length()-1 && indexTwo <= sb.length()-1) {
					sb.replace(indexOne, indexTwo + 1, "");
				}

				System.out.println(sb);
			} else if (command.contains("Switch")) {
				String oldWord = commandArr[1];
				String newWord = commandArr[2];

				if (sb.indexOf(oldWord) != - 1) {
					String newStr = sb.toString().replace(oldWord, newWord);
					sb = new StringBuilder(newStr);
				}

				System.out.println(sb);
			}

			command = scanner.nextLine();
		}

		System.out.printf("Ready for world tour! Planned stops: %s", sb);
	}
}
