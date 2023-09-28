package _13ExamPreparation2;

import java.util.Scanner;

public class _01WorldTour {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		StringBuilder stops = new StringBuilder(scanner.nextLine());

		String command;
		while(!"Travel".equals(command = scanner.nextLine())) {
			String[] cmdArr = command.split(":");
			if(command.startsWith("Add Stop")) {
				int index = Integer.parseInt(cmdArr[1]);
				String stop = cmdArr[2];

				if(isValidIndex(stops, index)) {
					stops.insert(index, stop);
				}
				System.out.println(stops);
			} else if(command.startsWith("Remove Stop")) {
				int startIndex = Integer.parseInt(cmdArr[1]);
				int endIndex = Integer.parseInt(cmdArr[2]);

				if(startIndex <= endIndex && isValidIndex(stops, startIndex) && endIndex < stops.length()) {
					stops.replace(startIndex, endIndex + 1, "");
				}
				System.out.println(stops);
			} else if(command.startsWith("Switch")) {
				String oldStop = cmdArr[1];
				String newStop = cmdArr[2];

				if(stops.indexOf(oldStop) != -1) {
					String newStr = stops.toString().replace(oldStop, newStop);
					stops.delete(0, stops.length());
					stops.append(newStr);
				}
				System.out.println(stops);
			}
		}
		System.out.printf("Ready for world tour! Planned stops: %s%n", stops);
	}

	private static boolean isValidIndex(StringBuilder stops, int index) {
		return index >= 0 && index <= stops.length();
	}
}
