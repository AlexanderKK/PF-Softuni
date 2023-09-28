package _06ExamPreparation2;

import java.util.*;
import java.util.stream.Collectors;

public class _02TheLift {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int people = Integer.parseInt(scanner.nextLine());
		List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
		boolean isFull = false;
		boolean hasEmptySpots = false;
		boolean noMoreSpace;

		for (int i = 0; i <= wagons.size() - 1; i++) {
			//Get taken spots
			int wagonTakenSpots = wagons.get(i);

			//Get free spots
			int wagonFreeSpots = 4 - wagonTakenSpots;

			if(people <= wagonFreeSpots) {
				//If there are fewer people than free spots -> wagon fills with people + taken spots
				wagons.set(i, people + wagonTakenSpots);
			} else {
				//If people are more than free spots fill with max capacity
				wagons.set(i, 4);
			}

			//People who went on a wagon
			people -= wagonFreeSpots;

			//Check if there is no more space (every wagon should have 4 passengers)
			noMoreSpace = isNoMoreSpace(wagons);

			//If there are no more people in the queue and there are no free spots -> print the current state of the lift
			if(noMoreSpace && people <= 0) {
				isFull = true;
				break;
			} else if(people <= 0) {   //If there are free spots but no no more people -> print The lift has empty spots and lift elements
				hasEmptySpots = true;
				break;
			}
			//Otherwise - if there are is no more space and there are people in the queue -> print people waiting in the queue
		}

		//Print contents of the collection wagons (the lift)
		printLift(people, wagons, isFull, hasEmptySpots);
	}

	private static void printLift(int people, List<Integer> wagons, boolean isFull, boolean hasEmptySpots) {
		//Lift elements joined by space
		String lift = wagons.toString().replace("[", "").replace("]", "").replaceAll(", ", " ");
		if(isFull) {
			System.out.println(lift);
		} else if(hasEmptySpots) {
			System.out.println("The lift has empty spots!");
			System.out.println(lift);
		} else {
			System.out.printf("There isn't enough space! %d people in a queue!%n", people);
			System.out.println(lift);
		}
	}

	private static boolean isNoMoreSpace(List<Integer> wagons) {
		boolean noMoreSpace = true;
		for (int passengers : wagons) {
			if (passengers < 4) {
				noMoreSpace = false;
				break;
			}
		}
		return noMoreSpace;
	}
}
