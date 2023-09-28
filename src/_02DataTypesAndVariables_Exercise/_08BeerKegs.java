package _02DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class _08BeerKegs {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		byte kegs = Byte.parseByte(scanner.nextLine());

		float max = 0;
		String biggestKeg = "";
		for (int i = 1; i <= kegs; i++) {
			String model = scanner.nextLine();
			float radius = Float.parseFloat(scanner.nextLine());
			int height = Integer.parseInt(scanner.nextLine());

			float volume = (float)(Math.PI * Math.pow(radius, 2) * height);
			if(volume > max) {
				max = volume;
				biggestKeg = model;
			}
		}
		System.out.println(biggestKeg);
	}
}