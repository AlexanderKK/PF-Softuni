package _03Arrays_Bonus;

import java.util.Arrays;
import java.util.Scanner;

public class _01EncryptSortPrintArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());

		String[] vowels = {"a", "o", "e", "i", "u"};
		int[] numbers = new int[n];

		for (int i = 0; i < n; i++) {
			String name = scanner.nextLine();
			int sumVowels = 0;
			int sumConsonants = 0;

			for (int j = 0; j < name.length(); j++) {
				boolean isVowel = false;
				for (String vowel : vowels) {
					if(vowel.equalsIgnoreCase(String.valueOf(name.charAt(j)))) {
						sumVowels += (name.charAt(j) * name.length());
						isVowel = true;
						break;
					}
				}

				if(!isVowel) {
					sumConsonants += (name.charAt(j) / name.length());
				}
			}

			int sum = sumVowels + sumConsonants;
			numbers[i] = sum;
		}

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				int first = numbers[i];
				int second = numbers[j];

				if(numbers[i] > numbers[j]) {
					numbers[i] = second;
					numbers[j] = first;
				}
			}
			System.out.println(numbers[i]);
		}
	}
}
