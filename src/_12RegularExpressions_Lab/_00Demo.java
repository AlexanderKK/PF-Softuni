package _12RegularExpressions_Lab;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class _00Demo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String regex = "[A-Za-z]+";
		Pattern pattern = Pattern.compile(regex);   //Нов шаблон, който да проверява регулярния израз regex

		String text = "Hello Java";
		Matcher matcher = pattern.matcher(text);   //всички текстове от "Hello Java", които отговарят на шаблона
		//matcher = {"Hello", "Java"}

//		System.out.println(matcher.find());
		//true -> ако има открити текстове, които отговарят на шаблона
		//false -> ако няма открити текстове, които отговарят на шаблона

		while(matcher.find()) {
			//Докато съществуват намерени текстове, извеждай срещането
			System.out.println(matcher.group());
		}
	}
}
