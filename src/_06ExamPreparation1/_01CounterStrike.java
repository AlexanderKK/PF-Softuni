package _06ExamPreparation1;

import java.util.Scanner;

public class _01CounterStrike {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int energy = Integer.parseInt(scanner.nextLine());
		if(energy >= 1 && energy <= 10000) {
			String command;

			int count = 0;
			boolean noEnergy = false;
			while(!(command = scanner.nextLine()).equals("End of battle")) {
				int distance = Integer.parseInt(command);

				if(distance >= 1 && distance <= 10000) {
					if (energy < distance) {
						noEnergy = true;
						break;
					}
					energy -= distance;

					count++;
					if (count % 3 == 0) {
						energy += count;
					}
				}
			}

			if(noEnergy) {
				System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", count, energy);
			} else {
				System.out.printf("Won battles: %d. Energy left: %d", count, energy);
			}
		}
	}
}
