package _05Lists_Bonus;

import java.util.*;
import java.util.stream.Collectors;

public class _02CarRace {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
		if(numbers.size() % 2 != 0) {
			double sumTimeLeft = 0;
			double sumTimeRight = 0;

			//Calc time of left racer
			for (int i = 0; i < numbers.size() / 2; i++) {
				//If 0 is reached reduce time by 20% else sum left
				if(numbers.get(i) == 0) {
					sumTimeLeft *= .8;
				} else {
					sumTimeLeft += numbers.get(i);
				}
			}

			//Calc time of right racer
			for (int i = numbers.size() / 2 + 1; i < numbers.size(); i++) {
				//If 0 is reached reduce time by 20% else sum right
				if(numbers.get(i) == 0) {
					sumTimeRight *= .8;
				} else {
					sumTimeRight += numbers.get(i);
				}
			}

			//Print winner
			if(sumTimeLeft < sumTimeRight) {
				System.out.printf("The winner is left with total time: %.1f%n", sumTimeLeft);
			} else if(sumTimeRight < sumTimeLeft) {
				System.out.printf("The winner is right with total time: %.1f%n", sumTimeRight);
			}
		}
	}
}
