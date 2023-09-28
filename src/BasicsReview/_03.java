package BasicsReview;

import java.util.Scanner;

public class _03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String fruit = scanner.nextLine();
		String size = scanner.nextLine();
		int qty = Integer.parseInt(scanner.nextLine());

		double price = 0;
		if(fruit.equals("Watermelon")) {
			if(size.equals("small")) {
				price = 56 * 2;
			} else if(size.equals("big")) {
				price = 28.7 * 5;
			}
		} else if(fruit.equals("Mango")) {
			if(size.equals("small")) {
				price = 36.66 * 2;
			} else if(size.equals("big")) {
				price = 19.6 * 5;
			}
		} else if(fruit.equals("Pineapple")) {
			if(size.equals("small")) {
				price = 42.1 * 2;
			} else if(size.equals("big")) {
				price = 24.8 * 5;
			}
		} else if(fruit.equals("Raspberry")) {
			if(size.equals("small")) {
				price = 20 * 2;
			} else if(size.equals("big")) {
				price = 15.2 * 5;
			}
		}

		double total = price * qty;
		if(total >= 400 && total <= 1000) {
			total *= .85;
		} else if(total > 1000) {
			total /= 2;
		}

		System.out.printf("%.2f lv.", total);
	}
}
