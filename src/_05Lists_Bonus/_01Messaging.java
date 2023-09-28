package _05Lists_Bonus;

import java.util.*;
import java.util.stream.Collectors;

public class _01Messaging {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		encodeMsg();

		List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
		String textDecode = scanner.nextLine();

		decodeMsg(numbers, textDecode);
	}

	private static void encodeMsg() {

	}

	private static void decodeMsg(List<Integer> numbers, String text) {
		String result = "";
		for (Integer number : numbers) {
			int sum = 0;
			String numberStr = number + "";
			for (int i = 0; i < numberStr.length(); i++) {
				sum += Integer.parseInt(String.valueOf(numberStr.charAt(i)));
			}

			while(sum > text.length() - 1) {
				sum -= text.length();
			}
			int index = sum;
			result += text.charAt(index);
			text = text.replaceFirst(String.valueOf(text.charAt(index)), "");
		}

		System.out.println(result);
	}
}
