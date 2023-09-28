package _06ExamPreparation1;

import java.util.*;
import java.util.stream.Collectors;

public class _03MemoryGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<String> sequence = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

		//Check if the list has matching elements consisted of pairs throughout the sequence
		if(isValidList(sequence)) {
			String command;
			int moves = 0;
			boolean hasWon = false;

			while(!"end".equals(command = scanner.nextLine())) {
				int index1 = Integer.parseInt(command.split(" ")[0]);
				int index2 = Integer.parseInt(command.split(" ")[1]);
				moves++;

				if(index1 >= 0 && index1 <= sequence.size() - 1 && index2 >= 0 && index2 <= sequence.size() - 1 && index1 != index2) {
					if(sequence.get(index1).equals(sequence.get(index2))) {
						System.out.printf("Congrats! You have found matching elements - %s!%n", sequence.get(index1));
						sequence.remove(index1);
						if(index2 > 0) {
							sequence.remove(--index2);
						} else {
							sequence.remove(index2);
						}

						if(sequence.size() == 0) {
							System.out.printf("You have won in %d turns!%n", moves);
							hasWon = true;
							break;
						}
					} else {
						System.out.println("Try again!");
					}
				} else {
					System.out.println("Invalid input! Adding additional elements to the board");

					int middleIndex = sequence.size() / 2;
					String newElement = String.format("-%da", moves);

					sequence.add(middleIndex, newElement);
					sequence.add(middleIndex + 1, newElement);
				}
			}

			if(!hasWon) {
				System.out.printf("Sorry you lose :(\n%s\n", String.join(" ", sequence));
			}
		}
	}

	private static boolean isValidList(List<String> sequence) {
		boolean isValidList = true;
		for (int i = 0; i < sequence.size(); i++) {
			int encountersBefore = 0;
			int encountersAfter = 0;

			//Check for equal elements after present one
			for (int j = i + 1; j < sequence.size(); j++) {
				if (sequence.get(i).equals(sequence.get(j))) {
					//Number of encounters after present element
					encountersAfter++;
				}
			}

			for (int j = i - 1; j >= 0; j--) {
				if (sequence.get(i).equals(sequence.get(j))) {
					//Number of encounters before present element
					encountersBefore++;
				}
			}

			//Check if encounters are none or more than one
			//If the condition is true => the list is not valid (none or more than one encounters of equals elements)
			if ((encountersAfter + encountersBefore) != 1) {
				isValidList = false;
				break;
			}
		}
		return isValidList;
	}
}
