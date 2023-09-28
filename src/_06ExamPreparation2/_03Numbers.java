package _06ExamPreparation2;

import java.util.*;
import java.util.stream.Collectors;

public class _03Numbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

		int sum = 0;
		for (Integer number : numbers) {
			sum += number;
		}
		double average = 1.0 * sum / numbers.size();

		List<Integer> topNumbers = new ArrayList<>();

		for (Integer number : numbers) {
			if (number > average) {
				topNumbers.add(number);
			}
		}

		if(topNumbers.size() == 0) {
			System.out.println("No");
		} else {
//			1.
//			topNumbers.sort(Comparator.reverseOrder());

//			2.
//			Collections.sort(topNumbers, Collections.reverseOrder());

//			3.
//			Collections.sort(topNumbers);
//			Collections.reverse(topNumbers);

//			4.
			for (int i = 0; i < topNumbers.size(); i++) {
				for (int j = i + 1; j < topNumbers.size(); j++) {
					int first = topNumbers.get(i);
					int second = topNumbers.get(j);

					if(first < second) {
						topNumbers.set(i, second);
						topNumbers.set(j, first);
					}
				}
			}

			for (int i = 0; i < topNumbers.size(); i++) {
				if(i < 5) {
					System.out.print(topNumbers.get(i) + " ");
				}
			}
		}
	}
}
