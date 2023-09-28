package _02DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class _10PokeMon {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int startingPower = Integer.parseInt(scanner.nextLine());
		int distance = Integer.parseInt(scanner.nextLine());
		int exhaustionFactor = Integer.parseInt(scanner.nextLine());

		short targetsPoked = 0;
		int power = startingPower;
		while(power >= distance) {
			power -= distance;

			targetsPoked++;

			if(power == startingPower / 2 && exhaustionFactor != 0) {
				power /= exhaustionFactor;
			}
		}
		System.out.println(power);
		System.out.println(targetsPoked);
	}
}