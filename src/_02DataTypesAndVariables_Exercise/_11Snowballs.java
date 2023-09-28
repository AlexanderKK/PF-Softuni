package _02DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class _11Snowballs {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		byte snowballs = Byte.parseByte(scanner.nextLine());

		double maxSnowballValue = 0;
		int maxSnowballSnow = 0;
		int maxSnowballTime = 0;
		int maxSnowballQuality = 0;

		for (int i = 1; i <= snowballs; i++) {
			short snowballSnow = Short.parseShort(scanner.nextLine());
			short snowballTime = Short.parseShort(scanner.nextLine());
			byte snowballQuality = Byte.parseByte(scanner.nextLine());

			double snowballValue = Math.pow((double)snowballSnow / snowballTime, snowballQuality);
			if(snowballValue > maxSnowballValue) {
				maxSnowballValue = snowballValue;
				maxSnowballSnow = snowballSnow;
				maxSnowballTime = snowballTime;
				maxSnowballQuality = snowballQuality;
			}
		}

		System.out.printf("%d : %d = %.0f (%d)", maxSnowballSnow, maxSnowballTime, maxSnowballValue, maxSnowballQuality);
	}
}