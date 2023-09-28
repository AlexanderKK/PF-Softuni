package _12RegularExpressions_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01Furniture {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String regex = ">>(?<name>[A-Za-z]+)<<(?<price>[0-9]+\\.?[0-9]*)!(?<quantity>[0-9]+)";
		Pattern pattern = Pattern.compile(regex);

		double totalSum = 0.0;
		List<String> furnitureList = new ArrayList<>();

		String input;
		while(!"Purchase".equals(input = scanner.nextLine())) {
			Matcher matcher = pattern.matcher(input);

			while(matcher.find()) {
				String furniture = matcher.group("name");
				furnitureList.add(furniture);

				double price = Double.parseDouble(matcher.group("price")) * Integer.parseInt(matcher.group("quantity"));
				totalSum += price;
			}
		}

		System.out.println("Bought furniture:");
//		System.out.println(String.join(System.lineSeparator(), furnitureList));
		furnitureList.forEach(System.out::println);
		System.out.printf("Total money spend: %.2f%n", totalSum);
	}
}
