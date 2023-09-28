package _05Lists_Bonus;

import java.util.*;
import java.util.stream.Collectors;

public class _05DrumSet {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double budget = Double.parseDouble(scanner.nextLine());
		List<Integer> drums = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

		String command;

		List<Integer> drumsInitialQuality = new ArrayList<>(drums);

		while(!Objects.equals(command = scanner.nextLine(), "Hit it again, Gabsy!")) {
			int hitPower = Integer.parseInt(command);

			for (int i = 0; i < drums.size(); i++) {
				drums.set(i, drums.get(i) - hitPower);

				if(drums.get(i) <= 0) {
					if(budget >= drumsInitialQuality.get(i) * 3) {
						drums.set(i, drumsInitialQuality.get(i));

						budget -= drumsInitialQuality.get(i) * 3;
					} else {
						drums.remove(i);
						drumsInitialQuality.remove(i);
						i--;
					}
				}
			}
		}

		for (Integer drum : drums) {
			System.out.print(drum + " ");
		}
		System.out.println();
		System.out.printf("Gabsy has %.2flv.%n", budget);
	}
}
