package _03Arrays_Lab;

import java.util.Scanner;

public class _04ReverseArrayOfStrings {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] array = scanner.nextLine().split(" ");

		for (int i = 0; i < array.length / 2; i++) {
			String oldElement = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = oldElement;
		}
		System.out.println(String.join(" ", array));
	}
}