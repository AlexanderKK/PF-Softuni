package _05Lists_Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04ListManipulations {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//1. Прочитаме списък от цели числа
		List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

		//2 Въвеждаме команди докато не получим end
		String command;
		while(!(command = scanner.nextLine()).equals("end")) {
			//command = Add {number}
			//command = Remove {number}
			//command = RemoveAt {index}
			//command = Insert {number} {index}

			if(command.contains("Add")) {
				int numberToAdd = Integer.parseInt(command.split(" ")[1]);

				numbers.add(numberToAdd);
			} else if(command.contains("RemoveAt")) {
				int indexToRemove = Integer.parseInt(command.split(" ")[1]);

				numbers.remove(indexToRemove);    //искам да премахна по индекс
			} else if(command.contains("Remove")) {
				int numberToRemove = Integer.parseInt(command.split(" ")[1]);

				numbers.remove(Integer.valueOf(numberToRemove));   //искам да премахна елемента
			} else if(command.contains("Insert")) {
				int numberToAdd = Integer.parseInt(command.split(" ")[1]);
				int index = Integer.parseInt(command.split(" ")[2]);

				numbers.add(index, numberToAdd);
			}
		}

		for (Integer number : numbers) {
			System.out.print(number + " ");
		}
	}
}
