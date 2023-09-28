package _08ObjectsAndClasses_Exercise;

import java.util.Random;
import java.util.Scanner;

public class _01AdvertisementMessage {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.",	"Exceptional product.",	"I can't live without this product."};
		String[] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.",	"Try it yourself, I am very satisfied.", "I feel great!"};
		String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
		String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

		int msgCount = Integer.parseInt(scanner.nextLine());
		for (int i = 1; i <= msgCount; i++) {
			Random rnd = new Random();
			int rndIndexPhrases = rnd.nextInt(phrases.length);
			int rndIndexEvents = rnd.nextInt(events.length);
			int rndIndexAuthors = rnd.nextInt(authors.length);
			int rndIndexCities = rnd.nextInt(cities.length);

			String rndMsg = String.format("%s %s %s - %s", phrases[rndIndexPhrases], events[rndIndexEvents], authors[rndIndexAuthors], cities[rndIndexCities]);
			System.out.println(rndMsg);
		}
	}
}
