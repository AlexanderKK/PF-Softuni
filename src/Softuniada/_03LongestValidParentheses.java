package Softuniada;

import java.util.*;

public class _03LongestValidParentheses {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();

		int counter = 2;
		String curr;
		String temp = " ";
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < input.length() - 1; i+=2) {
			if(input.charAt(i) == '(' && input.charAt(i + 1) == ')') {
				curr = input.charAt(i) + "" + input.charAt(i + 1);
			} else {
				curr = "";
				i--;
			}

			if(temp.equals(curr) && !temp.equals("")) {
				counter += 2;
			} else {
				counter = 2;
			}
			numbers.add(counter);
			temp = curr;
		}

		if(counter >= 2 && numbers.size() > 0) {
			System.out.println(Collections.max(numbers));
		}
	}
}
