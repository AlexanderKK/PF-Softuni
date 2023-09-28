package _08ObjectsAndClasses_Lab;

import java.util.Random;
import java.util.Scanner;

public class _01RandomizeWords {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();
		String[] wordsArr = input.split("\\s+");

		Random rndGenerator = new Random();
		for (int i = 0; i < wordsArr.length; i++) {
			int rndIndexX = rndGenerator.nextInt(wordsArr.length);
			int rndIndexY = rndGenerator.nextInt(wordsArr.length);

			String oldWordX = wordsArr[rndIndexX];
			wordsArr[rndIndexX] = wordsArr[rndIndexY];
			wordsArr[rndIndexY] = oldWordX;
		}

		System.out.println(String.join(System.lineSeparator(), wordsArr));
	}
}