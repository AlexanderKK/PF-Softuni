package _03Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _06EqualArrays2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] numbers1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
		int[] numbers2 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

		int sum = 0;
		boolean isDifferent = false;
		for (int i = 0; i < numbers1.length; i++) {
			if(numbers1[i] != numbers2[i]) {
				isDifferent = true;
				System.out.printf("Arrays are not identical. Found difference at %d index.", i);
				break;
			}
			sum += numbers2[i];
		}

		if(!isDifferent) {
			System.out.printf("Arrays are identical. Sum: %d", sum);
		}
	}
}
