package _06ExamPreparation4;

import java.util.Scanner;

public class _01ActivationKeys {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String key = scanner.nextLine();
		String command;
		while(!(command = scanner.nextLine()).equals("Generate")) {
			if(command.startsWith("Contains")) {
				String substring = command.split(">>>")[1];

				if(key.contains(substring)) {
					System.out.printf("%s contains %s", key, substring);
				} else {
					System.out.println("Substring not found!");
				}
			} else if(command.startsWith("Flip")) {
				String upperOrLower = command.split(">>>")[1];
				int startIndex = Integer.parseInt(command.split(">>>")[2]);
				int endIndex = Integer.parseInt(command.split(">>>")[3]);

				if(isValidIndex(key, startIndex, endIndex)) {
					String substringBefore = key.substring(0, startIndex);
					String substring = "";
					String substringAfter = key.substring(endIndex);

					if(upperOrLower.equals("Upper")) {
						substring = key.substring(startIndex, endIndex).toUpperCase();
					} else if(upperOrLower.equals("Lower")) {
						substring = key.substring(startIndex, endIndex).toLowerCase();
					}
					key = substringBefore.concat(substring).concat(substringAfter);
					System.out.println(key);
				}
			} else if(command.startsWith("Slice")) {
				int startIndex = Integer.parseInt(command.split(">>>")[1]);
				int endIndex = Integer.parseInt(command.split(">>>")[2]);

				if(isValidIndex(key, startIndex, endIndex)) {
					String subStrToDelete = key.substring(startIndex, endIndex);
					key = key.replace(subStrToDelete, "");
					System.out.println(key);
				}
			}
		}
		System.out.printf("Your activation key is: %s%n", key);
	}

	private static boolean isValidIndex(String key, int startIndex, int endIndex) {
		return startIndex >= 0 && startIndex <= key.length() && endIndex >= 0 && endIndex <= key.length();
	}
}
