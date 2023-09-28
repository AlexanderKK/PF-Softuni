package _01BasicSyntax_Exercise;

import java.util.Scanner;

public class _05Login2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String username = scanner.nextLine();
		String pwd = scanner.nextLine();

		String pass = "";
		for (int i = username.length() - 1; i >= 0 ; i--) {
			pass += username.charAt(i);
		}

		boolean isBlocked = false;
		int tries = 0;
		while(!pwd.equals(pass)) {
			tries++;
			if(tries == 4) {
				isBlocked = true;
				break;
			}

			System.out.println("Incorrect password. Try again.");
			pwd = scanner.nextLine();
		}

		if(isBlocked) {
			System.out.printf("User %s blocked!", username);
		} else {
			System.out.printf("User %s logged in.", username);
		}
	}
}