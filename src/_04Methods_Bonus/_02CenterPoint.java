package _04Methods_Bonus;

import java.text.DecimalFormat;
import java.util.Scanner;

public class _02CenterPoint {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double x1 = Double.parseDouble(scanner.nextLine());
		double y1 = Double.parseDouble(scanner.nextLine());
		double x2 = Double.parseDouble(scanner.nextLine());
		double y2 = Double.parseDouble(scanner.nextLine());

		printClosestToCenter(x1, y1, x2, y2);
	}

	public static void printClosestToCenter(double x1, double y1, double x2, double y2) {
		double sumFirst = Math.abs(x1) + Math.abs(y1);
		double sumSecond = Math.abs(x2) + Math.abs(y2);
		DecimalFormat df = new DecimalFormat("0.#");

		if(sumFirst < sumSecond) {
			System.out.println("(" + df.format(x1) + ", " + df.format(y1) + ")");
		} else if(sumSecond < sumFirst) {
			System.out.println("(" + df.format(x2) + ", " + df.format(y2) + ")");
		} else {
			System.out.println("(" + df.format(x1) + ", " + df.format(y1) + ")");
		}
	}
}
