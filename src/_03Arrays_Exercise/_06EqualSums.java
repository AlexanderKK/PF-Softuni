package _03Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _06EqualSums {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int index = 0;
		boolean isEqual = false;

		for (int i = 0; i < arr.length; i++) {
			int sumLeft = 0;
			int sumRight = 0;

			for (int j = 0; j < i; j++) {
				sumLeft += arr[j];
			}

			for (int j = i + 1; j < arr.length; j++) {
				sumRight += arr[j];
			}

			if(arr.length == 1 || sumLeft == sumRight) {
				isEqual = true;
				index = i;
				break;
			}
		}

		if(isEqual) {
			System.out.println(index);
		} else {
			System.out.println("no");
		}
	}
}
