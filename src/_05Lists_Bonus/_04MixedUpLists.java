package _05Lists_Bonus;

import java.util.*;
import java.util.stream.Collectors;

public class _04MixedUpLists {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Integer> numbers1 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
		List<Integer> numbers2 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

		List<Integer> numbersToCheck = new ArrayList<>();

		int diff = Math.abs(numbers1.size() - numbers2.size());
		if(diff == 2) {
			//check which list has smaller size
			int size;
			boolean isFirstListSmaller = false;
			if(numbers1.size() < numbers2.size()) {
				size = numbers1.size();
				isFirstListSmaller = true;
			} else {
				size = numbers2.size();
			}

			//append elements to third list
			for (int i = 0; i < size; i++) {
				numbersToCheck.add(numbers1.get(i));
				numbersToCheck.add(numbers2.get(numbers2.size() - 1 - i));
			}

			//get firstConstraint and secondConstraint
			int firstConstraint;
			int secondConstraint;

			if(isFirstListSmaller) {
				//if first list is smaller get the rest of its elements -> FIRST TWO, because we add from LAST TO FIRST
				firstConstraint = numbers2.get(0);
				secondConstraint = numbers2.get(1);
			} else {
				//if second list is smaller get the rest of its elements -> LAST TWO, because we add from FIRST TO LAST
				firstConstraint = numbers1.get(numbers1.size() - 2);
				secondConstraint = numbers1.get(numbers1.size() - 1);
			}

			if(firstConstraint > secondConstraint) {
				int first = firstConstraint;
				firstConstraint = secondConstraint;
				secondConstraint = first;
			}

			//leave elements fulfilling the condition otherwise remove them
			for (int i = 0; i < numbersToCheck.size(); i++) {
				if(numbersToCheck.get(i) <= firstConstraint || numbersToCheck.get(i) >= secondConstraint) {
					numbersToCheck.remove(i);
					i--;
				}
			}

			//sort the list containing special numbers
			Collections.sort(numbersToCheck);

			//print numbers
			for (int number : numbersToCheck) {
				System.out.print(number + " ");
			}
		}
	}
}
