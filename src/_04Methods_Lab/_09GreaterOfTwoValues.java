package _04Methods_Lab;

import java.util.Scanner;

public class _09GreaterOfTwoValues {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String datatype = scanner.nextLine();

		if(datatype.equals("int")) {
			int first = Integer.parseInt(scanner.nextLine());
			int second = Integer.parseInt(scanner.nextLine());

			System.out.println(getMax(first, second));
		} else if(datatype.equals("char")) {
			char first = scanner.nextLine().charAt(0);
			char second = scanner.nextLine().charAt(0);

			System.out.println(getMax(first, second));
		} else if(datatype.equals("string")) {
			String first = scanner.nextLine();
			String second = scanner.nextLine();

			System.out.println(getMax(first, second));
		}
	}

	public static int getMax(int first, int second) {
		return Math.max(first, second);
	}

	public static char getMax(char first, char second) {
		if(first > second) {
			return first;
		} else {
			return second;
		}
	}

	public static String getMax(String first, String second) {
		if(first.compareTo(second) > 0) {
			return first;
		} else {
			return second;
		}
	}
}
