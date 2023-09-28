package _06ExamPreparation5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03Inventory {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<String> items = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

		String command;
		while(!"Craft!".equals(command = scanner.nextLine())) {
			String cmd = command.split(" - ")[0];
			String item = command.split(" - ")[1];

			if(cmd.equals("Collect")) {
				if(!items.contains(item)) {
					items.add(item);
				}
			} else if(cmd.equals("Drop")) {
				items.remove(item);
			} else if(cmd.equals("Combine Items")) {
				String oldItem = item.split(":")[0];
				String newItem = item.split(":")[1];

				if(items.contains(oldItem)) {
					int indexOfOldItem = items.indexOf(oldItem);
					items.add(indexOfOldItem + 1, newItem);
				}
			} else if(cmd.equals("Renew")) {
				if(items.contains(item)) {
					items.remove(item);
					items.add(item);
				}
			}
		}

		System.out.println(String.join(", ", items));
	}
}
