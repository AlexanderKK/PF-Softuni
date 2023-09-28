package BasicsReview;

import java.util.Scanner;

public class _01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double rent = Double.parseDouble(scanner.nextLine());
		double cake = rent * .2;
		double drinks = cake * .55;
		double animator = rent / 3;
		double total = rent + cake + drinks + animator;
		System.out.printf("%.1f", total);
	}
}