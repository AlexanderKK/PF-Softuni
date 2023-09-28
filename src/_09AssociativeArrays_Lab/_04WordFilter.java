package _09AssociativeArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _04WordFilter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] wordsArr = Arrays.stream(scanner.nextLine().split(" "))
				.filter(e -> e.length() % 2 != 1)
				.toArray(String[]::new);

		System.out.println(String.join(System.lineSeparator(), wordsArr));
	}
}
