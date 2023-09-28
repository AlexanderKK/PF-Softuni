package _02DataTypesAndVariables_Bonus;

import java.math.BigDecimal;
import java.util.Scanner;

public class _03FloatingEquality {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		BigDecimal first = new BigDecimal(scanner.nextLine());
		BigDecimal second = new BigDecimal(scanner.nextLine());
		BigDecimal diff = first.subtract(second).abs();

		if(diff.compareTo(BigDecimal.valueOf(0.000001)) < 0) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}
}