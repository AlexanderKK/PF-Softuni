package _04Methods_Lab;

import java.util.Scanner;

public class _05Orders {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String product = scanner.nextLine();
		int qty = Integer.parseInt(scanner.nextLine());

		double total = calcOrder(product, qty);
		System.out.printf("%.2f", total);
	}

	public static double calcOrder(String product, int qty) {
		double price = 0.0;
		if(product.equals("coffee")) {
			price = 1.5;
		} else if(product.equals("water")) {
			price = 1;
		} else if(product.equals("coke")) {
			price = 1.4;
		} else if(product.equals("snacks")) {
			price = 2;
		}
		return price * qty;
	}
}
