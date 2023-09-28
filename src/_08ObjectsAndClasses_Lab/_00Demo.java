package _08ObjectsAndClasses_Lab;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class _00Demo {
	public static class Dice {
		private int side;

		public Dice(int side) {
			this.side = side;
		}

		public Dice() {

		}

		public Dice(int bound, int side) {
			Random rnd = new Random();
			this.side = rnd.nextInt(bound);
		}

		public int getSide() {
			return this.side;
		}

		public void setSide(int side) {
			this.side = side;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//object birthday has properties/characteristics - year, month, day of month
		LocalDate birthday = LocalDate.of(1986, 4, 19);
		System.out.println(birthday);

		//Non-static class Random
		Random rnd = new Random();
		int rndNum = rnd.nextInt(10);
		System.out.println(rndNum);

//		Set a property side = 4 in the class Dice
//		dice.setSide(4);

//		Create object from Class with constructor(parameters{1...n})
//		Cannot create empty constructor with 0 parameters
		Dice dice = new Dice(6);

		//Get a property value side from class DIce
		System.out.println(dice.getSide());
	}
}