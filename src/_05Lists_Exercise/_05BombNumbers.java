package _05Lists_Exercise;

import java.util.*;
import java.util.stream.*;

public class _05BombNumbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

		String command = scanner.nextLine();
		int bombNumber = Integer.parseInt(command.split(" ")[0]);
		int power = Integer.parseInt(command.split(" ")[1]);

		while(numbers.contains(bombNumber)) {
			int indexBomb = numbers.indexOf(bombNumber);

//			int leftRange = power;
//			int rightRange = power;
//
//			if(indexBomb - leftRange < 0) {
//				leftRange = indexBomb;
//			}
//			if(indexBomb + rightRange > numbers.size() - 1) {
//				rightRange = numbers.size() - 1 - indexBomb;
//			}

//			numbers.subList(indexBomb - leftRange, indexBomb + rightRange + 1).clear();

			//Get leftRange start index
			int left = Math.max(0, indexBomb - power);

			//Get rightRange end index
			int right = Math.min(numbers.size() - 1, indexBomb + power);

			if (right >= left) {
				//Clear a sublist from start to end index of bombRange
				numbers.subList(left, right + 1).clear();
			}

//			for (int i = right; i >= left; i--) {
//				numbers.remove(i);
//			}
		}

		sumNumbers(numbers);
	}

	private static void sumNumbers(List<Integer> numbers) {
		int sum = 0;
		for (Integer number : numbers) {
			sum += number;
		}
		System.out.println(sum);
	}
}
