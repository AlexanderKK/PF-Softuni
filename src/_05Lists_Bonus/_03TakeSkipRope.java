package _05Lists_Bonus;

import java.util.*;
import java.util.stream.Collectors;

public class _03TakeSkipRope {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();
		List<Integer> numbers = new ArrayList<>();
		List<String> nonNumbers = new ArrayList<>();

		for (char c : input.toCharArray()) {
			if(Character.isDigit(c)) {
				numbers.add(Integer.parseInt(String.valueOf(c)));
			} else {
				nonNumbers.add(String.valueOf(c));
			}
		}

		if(numbers.size() % 2 == 0) {
			List<Integer> takeList = new ArrayList<>();
			List<Integer> skipList = new ArrayList<>();

			for (int i = 0; i < numbers.size(); i++) {
				int number = numbers.get(i);
				if (i % 2 == 0) {
					takeList.add(number);
				} else {
					skipList.add(number);
				}
			}

			String nonNumbersStr = nonNumbers.toString().replace("[","").replace("]","").replaceAll(", ","");
			String msg = "";
			int currentIndex = 0;
			int nextIndex;
			for (int i = 0; i <= takeList.size() - 1; i++) {
				if(i == 0) {
					msg += nonNumbersStr.substring(0, takeList.get(i));
					nextIndex = takeList.get(i);
				} else {
					if(i == takeList.size() - 1 && (currentIndex + takeList.get(i)) > nonNumbersStr.length()) {
						nextIndex = currentIndex + (nonNumbersStr.length() - currentIndex);
					} else {
						nextIndex = currentIndex + takeList.get(i);
					}
					msg += nonNumbersStr.substring(currentIndex, nextIndex);
				}
				currentIndex = skipList.get(i) + nextIndex;
			}

			System.out.println(msg.trim());
		}
	}
}
