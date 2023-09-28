package Softuniada;

import java.util.Scanner;

public class _02Rocket {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());
		if(n >= 4 && n <= 30 && n % 2 == 0) {
			drawTop(n);

			drawBorder(n);

			drawCenter(n);

			drawBottom(n);
		}
	}

	private static void drawBottom(int n) {
		for (int i = n / 2; i > 0; i--) {
			for (int j = i; j > 0; j--) {
				System.out.print("_");
			}
			System.out.print("//");

			for (int j = n / 2 - i; j > 0 ; j--) {
				System.out.print(".");
			}
			System.out.print("!");
			for (int j = n / 2 - i; j > 0 ; j--) {
				System.out.print(".");
			}

			System.out.print("\\\\");

			for (int j = i; j > 0; j--) {
				System.out.print("_");
			}
			System.out.println();
		}
	}

	private static void drawBorder(int n) {
		System.out.println();
		System.out.print("_/");

		for (int j = 1; j <= ((n + 5) - 7) / 2; j++) {
			System.out.print(".");
		}

		System.out.print("|||");

		for (int j = 1; j <= ((n + 5) - 7) / 2; j++) {
			System.out.print(".");
		}

		System.out.print("\\_");
		System.out.println();
	}

	private static void drawCenter(int n) {
		for (int i = 1; i <= n + 1; i++) {
			for (int j = 1; j <= n / 2 + 1; j++) {
				System.out.print("_");
			}

			if(i != n + 1) {
				System.out.print("|||");
			} else {
				System.out.print("~~~");
			}

			for (int j = 1; j <= n / 2 + 1; j++) {
				System.out.print("_");
			}

			System.out.println();
		}
	}

	private static void drawTop(int n) {
		int left = (n + 5) / 2;
		int right = (n + 5) / 2;

		int row = 1;
		for (int i = 1; i <= n + 1; i++) {
			for (int j = left - i; j >= 0; j--) {
				System.out.print("_");
			}
			if(i == 1) {
				System.out.print("^");
			} else {
				if(i == 2) {
					System.out.print("/");
					System.out.print("|");
					System.out.print("\\");
				} else if(i == 3) {
					System.out.print("/");
					System.out.print("|||");
					System.out.print("\\");
				} else {
					if(row <= n / 2) {
						System.out.print("/");

						for (int j = 1; j <= row; j++) {
							System.out.print(".");
						}

						System.out.print("|||");

						for (int j = 1; j <= row; j++) {
							System.out.print(".");
						}

						System.out.print("\\");
						row++;
					}
				}


			}
			for (int j = right - i; j >= 0; j--) {
				System.out.print("_");
			}

			if(row <= n / 2) {
				System.out.println();
			}
		}
	}
}
