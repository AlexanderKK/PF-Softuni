package _11TextProcessing_Lab;

import java.util.Scanner;

public class _00Demo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//1
		String str = "Hello";
		char ch = str.charAt(4);
		System.out.println(2 + 3 + 4 + String.valueOf(ch));
		String joinedStr = String.join(", ", "asd", "Java", "sfd");
		System.out.println(joinedStr);

		//2
		String string = new String(new char[] {'s', 't', 'r'});
		char[] charArr = string.toCharArray();
	}
}
