package _04Methods_Bonus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _06ArrayManipulator {
	public static int[] numbers;
	public static int max = 0;
	public static int min = 1000;
	public static int index = -1;
	public static boolean isFound = false;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		numbers  = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		String command;
		int inputs = 1;

		if(numbers.length >= 1 && numbers.length <= 50) {
			while(!"end".equals(command = scanner.nextLine())) {
				inputs++;
				if(inputs > 50) {
					break;
				}

				String cmd = command.split(" ")[0];

				if(cmd.equals("exchange")) {
					int index = Integer.parseInt(command.split(" ")[1]);
					if(index >= 0 && index <= numbers.length - 1) {
						exchange(index);
					} else {
						System.out.println("Invalid index");
					}
				} else if(cmd.equals("max") || cmd.equals("min")) {
					String numberType = command.split(" ")[1];

					maxOrMin(cmd, numberType);
				} else if(cmd.equals("first") || cmd.equals("last")) {
					int count = Integer.parseInt(command.split(" ")[1]);
					String numberType = command.split(" ")[2];

					firstOrLastCount(cmd, count, numberType);
				}
			}
		}
		System.out.println(String.join(", ", Arrays.toString(numbers)));
	}

	public static void firstOrLastCount(String firstOfLast, int count, String type) {
		if(type.equals("even") || type.equals("odd")) {
			int evenNumbers = 0;
			int oddNumbers = 0;
			boolean isLast = false;
			ArrayList<Integer> resultArr = new ArrayList<>();

			if(count > numbers.length) {
				System.out.println("Invalid count");
			} else if(count > 0) {
				for (int i = 0; i < numbers.length; i++) {
					if(firstOfLast.equals("first")) {
						if (type.equals("even") && numbers[i] % 2 == 0) {
							resultArr.add(numbers[i]);
							evenNumbers++;
						} else if(type.equals("odd") && numbers[i] % 2 != 0) {
							resultArr.add(numbers[i]);
							oddNumbers++;
						}
					} else if(firstOfLast.equals("last")) {
						if (type.equals("even") && numbers[numbers.length - 1 - i] % 2 == 0) {
							resultArr.add(numbers[numbers.length - 1 - i]);
							evenNumbers++;
						} else if(type.equals("odd") && numbers[numbers.length - 1 - i] % 2 != 0) {
							resultArr.add(numbers[numbers.length - 1 - i]);
							oddNumbers++;
						}

						isLast = true;
					}

					if(evenNumbers == count || oddNumbers == count) {
						break;
					}
				}

				if(isLast) {
					Collections.reverse(resultArr);
				}

				String arrToStr = Arrays.toString(new ArrayList[]{resultArr});
				System.out.println(String.join(", ", arrToStr.substring(1, arrToStr.length() - 1)));
			}
		}
	}

	public static void maxOrMin(String minOrMax, String type) {
		if(type.equals("even") || type.equals("odd")) {
			max = 0;
			min = 1000;
			index = -1;
			isFound = false;

			for (int i = 0; i < numbers.length; i++) {
				if(minOrMax.equals("max") && type.equals("even")) {
					if(numbers[i] % 2 == 0 && numbers[i] >= max) {
						repeatMinMax(numbers[i], i, "max");
					}
				} else if(minOrMax.equals("max")) {
					if (numbers[i] % 2 != 0 && numbers[i] >= max) {
						repeatMinMax(numbers[i], i, "max");
					}
				}

				if(minOrMax.equals("min") && type.equals("even")) {
					if(numbers[i] % 2 == 0 && numbers[i] <= min) {
						repeatMinMax(numbers[i], i, "min");
					}
				} else if(minOrMax.equals("min")) {
					if (numbers[i] % 2 != 0 && numbers[i] <= min) {
						repeatMinMax(numbers[i], i, "min");
					}
				}
			}

			if(isFound) {
				System.out.println(index);
			} else {
				System.out.println("No matches");
			}
		}
	}

	public static void repeatMinMax(int element, int i, String type) {
		if(type.equals("max")) {
			max = element;
		} else if(type.equals("min")){
			min = element;
		}
		index = i;
		isFound = true;
	}

	public static void exchange(int index) {
		int[] numbersFirst = Arrays.copyOfRange(numbers, index + 1, numbers.length);
		int[] numbersSecond = Arrays.copyOfRange(numbers, 0, index + 1);
		numbers = Arrays.copyOf(numbersFirst, numbersFirst.length + numbersSecond.length);
		System.arraycopy(numbersSecond, 0, numbers, numbersFirst.length, numbersSecond.length);
	}
}
