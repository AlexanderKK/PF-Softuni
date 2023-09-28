package _03Arrays_Exercise;

import java.util.Scanner;
import java.util.Arrays;

public class _10TreasureHunt {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();
		String[] treasures = input.split("\\|");

		String command;
		while (!(command = scanner.nextLine()).equals("Yohoho!")) {
			String[] treasureInput = command.split("\\s");
			String treasureCmd = treasureInput[0];

			if (treasureCmd.equals("Loot")) {
				for (int i = 1; i < treasureInput.length; i++) {
					boolean isItemExisting = false;

					for (String treasure : treasures) {
						if (treasureInput[i].equals(treasure)) {
							isItemExisting = true;
							break;
						}
					}

					if (!isItemExisting) {
						String[] treasuresNew = new String[treasures.length + 1];

						treasuresNew[0] = treasureInput[i];
						System.arraycopy(treasures, 0, treasuresNew, 1, treasures.length);
						treasures = treasuresNew;
//						System.arraycopy(treasures, 0, treasuresNew, 0, treasures.length);

//						for (int j = 0; j < treasures.length; j++) {
//							if (j != treasures.length - 1) {
//								treasures[treasures.length - 1 - j] = treasures[treasures.length - 2 - j];
//							}
//						}
//						treasures[0] = treasureInput[i];
					}
				}
			} else if (treasureCmd.equals("Drop")) {
				int index = Integer.parseInt(treasureInput[1]);

				if (index >= 0 && index <= treasures.length - 1) {
					String droppedLoot = treasures[index];

					for (int i = index; i < treasures.length - 1; i++) {
						treasures[i] = treasures[i + 1];
					}

					treasures[treasures.length - 1] = droppedLoot;
				}
			} else if (treasureCmd.equals("Steal")) {
				int items = Integer.parseInt(treasureInput[1]);
				int itemsToDrop = Math.min(items, treasures.length);

				if (itemsToDrop > 0) {
					String[] stolenTreasures = Arrays.copyOfRange(treasures, treasures.length - itemsToDrop, treasures.length);
					treasures = Arrays.copyOf(treasures, treasures.length - itemsToDrop);
					System.out.println(String.join(", ", stolenTreasures));
				}

//				String[] treasuresNew = new String[treasures.length - items];
//				System.arraycopy(treasures, 0, treasuresNew, 0, treasuresNew.length);
//				treasures = treasuresNew;
			}
		}

		if (treasures.length > 0) {
			int sumItems = 0;
			for (String treasure : treasures) {
				sumItems += treasure.length();
			}
			double avgTreasureGain = sumItems * 1.0 / treasures.length;

			System.out.printf("Average treasure gain: %.2f pirate credits.", avgTreasureGain);
		} else {
			System.out.println("Failed treasure hunt.");
		}
	}
}
