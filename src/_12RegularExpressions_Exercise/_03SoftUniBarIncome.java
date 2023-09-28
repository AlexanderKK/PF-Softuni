package _12RegularExpressions_Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03SoftUniBarIncome {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String regex = "%(?<customer>[A-Z][a-z]*)%[^$|.%]*<(?<product>\\w+)>[^$|.%]*\\|(?<quantity>[0-9]+)\\|[^$|.%]*?(?<price>[0-9]+\\.?[0-9]*)\\$";
		Pattern pattern = Pattern.compile(regex);

		String line;

		double sumTotal = 0;
		while(!"end of shift".equals(line = scanner.nextLine())) {
			Matcher matcher = pattern.matcher(line);

			while(matcher.find()) {
				double price = Double.parseDouble(matcher.group("price"));
				int quantity = Integer.parseInt(matcher.group("quantity"));

				double total = price * quantity;
				sumTotal += total;

				System.out.printf("%s: %s - %.2f%n", matcher.group("customer"), matcher.group("product"), total);
			}
		}
		System.out.printf("Total income: %.2f%n", sumTotal);
	}
}
