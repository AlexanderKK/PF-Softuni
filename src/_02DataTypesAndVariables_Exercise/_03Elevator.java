package _02DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class _03Elevator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		byte people = Byte.parseByte(scanner.nextLine());
		byte capacity = Byte.parseByte(scanner.nextLine());

		int courses = people / capacity;
		if(people % capacity != 0) {
			courses++;
		}
//		int courses = (int)Math.ceil((double)people / capacity);
		System.out.println(courses);
	}
}