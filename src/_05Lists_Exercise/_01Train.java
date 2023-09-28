package _05Lists_Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class _01Train {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//получаваме във списък вагони с брой хора в тях
		List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

		//получаваме максимален капацитет на вагон
		int maxCapacity = Integer.parseInt(scanner.nextLine());

		//Докато не получим end
		String command;
		while(!"end".equals(command = scanner.nextLine())) {
			//Add {брой пътници} - добавяме с команда Add броя пътници във вагон накрая
			if(command.startsWith("Add")) {
				int passengers = Integer.parseInt(command.split(" ")[1]);

				if(passengers <= maxCapacity) {
					wagons.add(passengers);
				}
			} else if(isInteger(command)) {
				//{брой пътници} - добавяме пътници във вагон, в който има място
				int passengers = Integer.parseInt(command);

				//преминавам през вагоните
				for (int i = 0; i < wagons.size(); i++) {
					int newCount = wagons.get(i) + passengers;

					//проверявам дали сумата от пътниците на вагона със новодошлите е повече от капацитета
					if(newCount <= maxCapacity) {
						wagons.set(i, newCount);

						//при успешно добавяне приключване изпълнението на цикъла (вече сме добавили пътниците към вагон {i + 1})
						break;
					}
				}
			}
		}

		printWagons(wagons);
	}

	private static void printWagons(List<Integer> wagons) {
		String result = "";
		for (Integer wagon : wagons) {
			result += wagon + " ";
		}
		System.out.println(result.trim());
	}

	public static boolean isInteger(String str) {
		for (char ch : str.toCharArray()) {
			if(!Character.isDigit(ch)) {
				return false;
			}
		}
		return true;
	}
}
