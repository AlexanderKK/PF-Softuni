package _07MidExam;

import java.util.Arrays;
import java.util.Scanner;

public class _03TheAngryCat {
	private static int sumLeft = 0;
	private static int sumRight = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] priceRatings = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
		int entryPointIndex = Integer.parseInt(scanner.nextLine());
		String typeOfItems = scanner.nextLine();

		if(entryPointIndex >= 1 && entryPointIndex <= priceRatings.length - 2) {
			int entryPoint = priceRatings[entryPointIndex];

			sumLeft = getSumLeft(priceRatings, entryPointIndex, typeOfItems, entryPoint);
			sumRight = getSumRight(priceRatings, entryPointIndex, typeOfItems, entryPoint);
		}

		if(sumRight > sumLeft) {
			System.out.printf("Right - %d%n", sumRight);
		} else {
			System.out.printf("Left - %d%n", sumLeft);
		}
	}

	private static int getSumRight(int[] priceRatings, int entryPointIndex, String typeOfItems, int entryPoint) {
		for (int i = entryPointIndex + 1; i < priceRatings.length; i++) {
			if(isCheap(typeOfItems, entryPoint, priceRatings[i])) {
				sumRight += priceRatings[i];
			} else if(isExpensive(typeOfItems, entryPoint, priceRatings[i])) {
				sumRight += priceRatings[i];
			}
		}
		return sumRight;
	}

	private static int getSumLeft(int[] priceRatings, int entryPointIndex, String typeOfItems, int entryPoint) {
		for (int i = 0; i < entryPointIndex; i++) {
			if(isCheap(typeOfItems, entryPoint, priceRatings[i])) {
				sumLeft += priceRatings[i];
			} else if(isExpensive(typeOfItems, entryPoint, priceRatings[i])) {
				sumLeft += priceRatings[i];
			}
		}
		return sumLeft;
	}

	private static boolean isExpensive(String typeOfItems, int entryPoint, int priceRatings) {
		return typeOfItems.equals("expensive") && priceRatings >= entryPoint;
	}

	private static boolean isCheap(String typeOfItems, int entryPoint, int priceRating) {
		return typeOfItems.equals("cheap") && priceRating < entryPoint;
	}
}
