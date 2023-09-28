package _04Methods_Lab;

import java.util.Scanner;

public class _06CalculateRectangleArea {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double width = Double.parseDouble(scanner.nextLine());
		double height = Double.parseDouble(scanner.nextLine());

		double area = getRectArea(width, height);
		System.out.printf("%.0f", area);
	}

	public static double getRectArea(double w, double h) {
		return w * h;
	}
}
