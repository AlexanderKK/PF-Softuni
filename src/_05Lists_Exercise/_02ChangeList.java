package _05Lists_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02ChangeList {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

		String command;
		while(!"end".equals(command = scanner.nextLine())) {
			int element = Integer.parseInt(command.split(" ")[1]);

			if(command.startsWith("Delete")) {
				numbers.removeAll(List.of(element));
			} else if(command.startsWith("Insert")) {
				int position = Integer.parseInt(command.split(" ")[2]);

				numbers.add(position, element);
			}
		}

		for (Integer number : numbers) {
			System.out.print(number + " ");
		}
	}
}
