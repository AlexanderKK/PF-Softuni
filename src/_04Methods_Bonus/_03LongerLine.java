package _04Methods_Bonus;

import java.text.DecimalFormat;
import java.util.Scanner;

public class _03LongerLine {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double x1 = Double.parseDouble(scanner.nextLine());
		double y1 = Double.parseDouble(scanner.nextLine());
		double x2 = Double.parseDouble(scanner.nextLine());
		double y2 = Double.parseDouble(scanner.nextLine());
		double x3 = Double.parseDouble(scanner.nextLine());
		double y3 = Double.parseDouble(scanner.nextLine());
		double x4 = Double.parseDouble(scanner.nextLine());
		double y4 = Double.parseDouble(scanner.nextLine());

		printLongestLine(x1, y1, x2, y2, x3, y3, x4, y4);
	}

	public static void printLongestLine(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
		double distanceOne = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
		double distanceTwo = Math.sqrt(Math.pow((x3 - x4), 2) + Math.pow((y3 - y4), 2));
		DecimalFormat df = new DecimalFormat("0.#");

		if(distanceOne > distanceTwo) {
			if(checkClosestToCenter(x1, y1, x2, y2)) {
				System.out.println("(" + df.format(x1) + ", " + df.format(y1) + ")(" + df.format(x2) + ", " + df.format(y2) + ")");
			} else {
				System.out.println("(" + df.format(x2) + ", " + df.format(y2) + ")(" + df.format(x1) + ", " + df.format(y1) + ")");
			}
		} else if(distanceTwo > distanceOne) {
			if(checkClosestToCenter(x3, y3, x4, y4)) {
				System.out.println("(" + df.format(x3) + ", " + df.format(y3) + ")(" + df.format(x4) + ", " + df.format(y4) + ")");
			} else {
				System.out.println("(" + df.format(x4) + ", " + df.format(y4) + ")(" + df.format(x3) + ", " + df.format(y3) + ")");
			}
		} else {
			if(checkClosestToCenter(x1, y1, x2, y2)) {
				System.out.println("(" + df.format(x1) + ", " + df.format(y1) + ")(" + df.format(x2) + ", " + df.format(y2) + ")");
			} else {
				System.out.println("(" + df.format(x2) + ", " + df.format(y2) + ")(" + df.format(x1) + ", " + df.format(y1) + ")");
			}
		}
	}

	public static boolean checkClosestToCenter(double x1, double y1, double x2, double y2) {
		return Math.abs(x1) + Math.abs(y1) < Math.abs(x2) + Math.abs(y2);
	}
}
