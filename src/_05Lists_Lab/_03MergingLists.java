package _05Lists_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _03MergingLists {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Integer> numbers1 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
		List<Integer> numbers2 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
		List<Integer> numbers = new ArrayList<>();

		boolean isSmallestFirst = false;
		int smallestSize;

		if(numbers1.size() <= numbers2.size()) {
			smallestSize = numbers1.size();
			isSmallestFirst = true;
		} else {
			smallestSize = numbers2.size();
		}

		for (int i = 0; i < smallestSize; i++) {
			numbers.add(numbers1.get(i));
			numbers.add(numbers2.get(i));
		}

		if(isSmallestFirst) {
			for (int i = smallestSize; i < numbers2.size(); i++) {
				numbers.add(numbers2.get(i));
			}
		} else {
			for (int i = smallestSize; i < numbers1.size(); i++) {
				numbers.add(numbers1.get(i));
			}
		}

		for (Integer number : numbers) {
			System.out.print(number + " ");
		}
	}
}
