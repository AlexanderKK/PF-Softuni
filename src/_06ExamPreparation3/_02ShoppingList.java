package _06ExamPreparation3;

import java.util.*;
import java.util.stream.Collectors;

public class _02ShoppingList {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<String> shoppingList = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());

		//Check if list has duplicated items
		if(isValidList(shoppingList)) {
			String command = scanner.nextLine();
			while (!command.equals("Go Shopping!")) {
				String item = command.split(" ")[1];
				manipulateList(shoppingList, command, item);

				command = scanner.nextLine();
			}

//			shoppingList = shoppingList.stream().distinct().toList();
			System.out.println(String.join(", ", shoppingList));
		}
	}

	private static boolean isValidList(List<String> shoppingList) {
		for (int i = 0; i < shoppingList.size(); i++) {
			for (int j = i + 1; j < shoppingList.size(); j++) {
				if(shoppingList.get(i).equals(shoppingList.get(j))) {
					return false;
				}
			}
		}
		return true;
	}

	private static void manipulateList(List<String> shoppingList, String command, String item) {
		if(command.startsWith("Urgent")) {
			prependItem(shoppingList, item);
		} else if(command.startsWith("Unnecessary")) {
			removeItem(shoppingList, item);
		} else if(command.startsWith("Correct")) {
			updateItem(shoppingList, command, item);
		} else if(command.startsWith("Rearrange")) {
			appendItemToEnd(shoppingList, item);
		}
	}

	private static void appendItemToEnd(List<String> shoppingList, String item) {
		if(shoppingList.contains(item)) {
			shoppingList.remove(item);
			shoppingList.add(item);
		}
	}

	private static void updateItem(List<String> shoppingList, String command, String item) {
		if(shoppingList.contains(item)) {
			String newItem = command.split(" ")[2];

			int indexOldItem = shoppingList.indexOf(item);
			shoppingList.set(indexOldItem, newItem);
		}
	}

	private static void removeItem(List<String> shoppingList, String item) {
		shoppingList.remove(item);
	}

	private static void prependItem(List<String> shoppingList, String item) {
		if(!shoppingList.contains(item)) {
			shoppingList.add(0, item);
		}
	}
}
