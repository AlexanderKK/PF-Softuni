package _06ExamPreparation1;

import java.util.*;
import java.util.stream.Collectors;

public class _02TreasureHunt {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<String> treasures = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

		String command;
		while(!"Yohoho!".equals(command = scanner.nextLine())) {
			if(command.startsWith("Loot")) {
				String[] loots = command.split("\\s");

				for (int i = 1; i < loots.length; i++) {
					if(!treasures.contains(loots[i])) {
						treasures.add(0, loots[i]);
					}
				}
			} else if(command.startsWith("Drop")) {
				int index = Integer.parseInt(command.split("\\s")[1]);

				if(index >= 0 && index <= treasures.size() - 1) {
					String removedElement = treasures.get(index);
					treasures.remove(index);
					treasures.add(removedElement);
				}
			} else if(command.startsWith("Steal")) {
				int count = Integer.parseInt(command.split("\\s")[1]);
				int treasuresToSteal = Math.min(count, treasures.size());

				if(treasuresToSteal > 0) {
					int startPos = treasures.size() - treasuresToSteal;

					//Print Stolen Treasures
					String stolenTreasures = String.join(", ", treasures.subList(startPos, treasures.size()));
					System.out.println(stolenTreasures);

//					Remove Stolen Treasures
					treasures.subList(startPos, treasures.size()).clear();


//					for (int i = treasures.size() - 1; i >= startPos; i--) {
//						treasures.remove(i);
//					}
				}
			}
		}

		if(treasures.size() > 0) {
			int sumItems = 0;
			for (String treasure : treasures) {
				sumItems += treasure.length();
			}
			double averageTreasureGain = sumItems * 1.0 / treasures.size();
			System.out.printf("Average treasure gain: %.2f pirate credits.", averageTreasureGain);
		} else {
			System.out.println("Failed treasure hunt.");
		}
	}
}
