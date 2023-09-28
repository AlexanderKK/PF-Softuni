package _03Arrays_Exercise;

import java.util.Scanner;

public class _02CommonElements {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] arr1 = scanner.nextLine().split(" ");
		String[] arr2 = scanner.nextLine().split(" ");

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr1.length; j++) {
				if(arr1[j].equals(arr2[i])) {
					result.append(arr1[j]).append(" ");
				}
			}
		}
		System.out.println(result.toString().trim());
	}
}
