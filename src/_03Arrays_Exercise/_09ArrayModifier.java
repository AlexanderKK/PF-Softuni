package _03Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _09ArrayModifier {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		if(numbers.length >= 2 && numbers.length <= 100) {
			String command = scanner.nextLine();
			while(!command.equals("end")) {
				String[] inputArr = command.split(" ");
				String input = inputArr[0];

				if(input.equals("decrease")) {
					for (int i = 0; i < numbers.length; i++) {
						numbers[i]--;
					}
				} else {
					int index1 = 0;
					int index2 = 0;

					if(inputArr.length > 1) {
						index1 = Integer.parseInt(inputArr[1]);
						index2 = Integer.parseInt(inputArr[2]);
					}

					if(input.equals("swap")) {
						int firstNumber = numbers[index1];
						numbers[index1] = numbers[index2];
						numbers[index2] = firstNumber;
					} else if(input.equals("multiply")) {
						numbers[index1] = numbers[index1] * numbers[index2];
					}
				}

				command = scanner.nextLine();
			}

			String numberStr = "";
			for (int number : numbers) {
				numberStr += (number + ", ");
			}
			numberStr = numberStr.substring(0, numberStr.length() - 2);
			System.out.println(numberStr);
		}
	}
}
