package _06ExamPreparation3;

import java.util.*;
import java.util.stream.Collectors;

public class _03HeartDelivery {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Integer> houses = Arrays.stream(scanner.nextLine().split("@")).map(Integer::parseInt).collect(Collectors.toList());

		if(houses.size() >= 1 && houses.size() <= 20 && isValidList(houses)) {
			String command;
			int index = 0;

			while(!(command = scanner.nextLine()).equals("Love!")) {
				if(command.startsWith("Jump")) {
					int length = Integer.parseInt(command.split(" ")[1]);

					index = getIndexAndDecreaseHearts(houses, index, length);
				}
			}

			printLastPositionAndMission(houses, index);
		}
	}

	private static boolean isValidList(List<Integer> numbers) {
		for (int number : numbers) {
			if(number < 2 || number > 10) {
				return false;
			} else if(number % 2 != 0) {
				return false;
			}
		}
		return true;
	}

	private static void printLastPositionAndMission(List<Integer> houses, int index) {
		System.out.printf("Cupid's last position was %d.%n", index);

		int failedPlaces = 0;
		for (int hearts : houses) {
			if(hearts > 0) {
				failedPlaces++;
			}
		}

		if(failedPlaces > 0) {
			System.out.printf("Cupid has failed %d places.%n", failedPlaces);
		} else {
			System.out.println("Mission was successful.");
		}
	}

	private static int getIndexAndDecreaseHearts(List<Integer> houses, int index, int length) {
		if(length >= 1 && length <= 20) {
			index += length;
			if(index > houses.size() - 1) {
				index = 0;
			}

			if(houses.get(index) >= 2) {
				houses.set(index, houses.get(index) - 2);

				if(houses.get(index) == 0) {
					System.out.printf("Place %d has Valentine's day.%n", index);
				}
			} else {
				System.out.printf("Place %d already had Valentine's day.%n", index);
			}
		}
		return index;
	}
}
