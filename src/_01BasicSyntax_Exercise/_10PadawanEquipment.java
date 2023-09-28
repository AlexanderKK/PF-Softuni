package _01BasicSyntax_Exercise;

import java.util.Scanner;

public class _10PadawanEquipment {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double budget = Double.parseDouble(scanner.nextLine());
		int students = Integer.parseInt(scanner.nextLine());
		double priceSaber = Double.parseDouble(scanner.nextLine());
		double priceRobe = Double.parseDouble(scanner.nextLine());
		double priceBelt = Double.parseDouble(scanner.nextLine());

		double totalSabers = Math.ceil(students * 1.1) * priceSaber;
		double totalRobes = students * priceRobe;
		double totalBelts = Math.ceil(students - students / 6.0) * priceBelt;

		double totalCost = totalSabers + totalRobes + totalBelts;
		if(totalCost <= budget) {
			System.out.printf("The money is enough - it would cost %.2flv.", totalCost);
		} else {
			System.out.printf("George Lucas will need %.2flv more.", totalCost - budget);
		}
	}
}