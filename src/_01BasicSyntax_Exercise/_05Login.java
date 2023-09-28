package _01BasicSyntax_Exercise;

import java.util.Scanner;

public class _05Login {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String username = scanner.nextLine();
		String passwordInput = scanner.nextLine();
		String password = "";

		for (int i = 0; i < username.length(); i++) {
			password += username.charAt(username.length() - 1 - i);
		}

		int tries = 0;
		boolean isBlocked = false;
		while (!passwordInput.equals(password)) {
			tries++;
			if(tries == 4) {
				isBlocked = true;
				break;
			}

			System.out.println("Incorrect password. Try again.");
			passwordInput = scanner.nextLine();
		}

		if(isBlocked) {
			System.out.printf("User %s blocked!", username);
		} else {
			System.out.printf("User %s logged in.", username);
		}
	}
}