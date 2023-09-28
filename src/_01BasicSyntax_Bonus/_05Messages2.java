package _01BasicSyntax_Bonus;

import java.util.Scanner;

public class _05Messages2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		scanner.nextLine();
		String n = scanner.nextLine();

		String result = "";
		while(n != "") {
			String str = n;

			if(str.contains("2")) {
				if(str.length() == 1) {
					result += 'a';
				} else if(str.length() == 2) {
					result += 'b';
				} else if(str.length() == 3){
					result += 'c';
				}
			} else if(str.contains("3")) {
				if(str.length() == 1) {
					result += 'd';
				} else if(str.length() == 2) {
					result += 'e';
				} else if(str.length() == 3){
					result += 'f';
				}
			} else if(str.contains("4")) {
				if(str.length() == 1) {
					result += 'g';
				} else if(str.length() == 2) {
					result += 'h';
				} else if(str.length() == 3){
					result += 'i';
				}
			} else if(str.contains("5")) {
				if(str.length() == 1) {
					result += 'j';
				} else if(str.length() == 2) {
					result += 'k';
				} else if(str.length() == 3){
					result += 'l';
				}
			} else if(str.contains("6")) {
				if(str.length() == 1) {
					result += 'm';
				} else if(str.length() == 2) {
					result += 'n';
				} else if(str.length() == 3){
					result += 'o';
				}
			} else if(str.contains("7")) {
				if(str.length() == 1) {
					result += 'p';
				} else if(str.length() == 2) {
					result += 'q';
				} else if(str.length() == 3){
					result += 'r';
				} else if(str.length() == 4){
					result += 's';
				}
			} else if(str.contains("8")) {
				if(str.length() == 1) {
					result += 't';
				} else if(str.length() == 2) {
					result += 'u';
				} else if(str.length() == 3){
					result += 'v';
				}
			} else if(str.contains("9")) {
				if(str.length() == 1) {
					result += 'w';
				} else if(str.length() == 2) {
					result += 'x';
				} else if(str.length() == 3){
					result += 'y';
				} else if(str.length() == 4){
					result += 'z';
				}
			} else if(str.contains("0")) {
				result += " ";
			}

			n = scanner.nextLine();
		}
		System.out.print(result);
	}
}