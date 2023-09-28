package _05Lists_Exercise;

import java.util.*;
import java.util.stream.*;

public class _06CardsGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Integer> player1 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
		List<Integer> player2 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

		while(player1.size() > 0 && player2.size() > 0) {
			int firstHandCard = player1.get(0);
			int secondHandCard = player2.get(0);

			if(firstHandCard > secondHandCard) {
				player1.add(firstHandCard);
				player1.add(secondHandCard);
				player1.remove(0);
				player2.remove(0);
			} else if(secondHandCard > firstHandCard) {
				player2.add(secondHandCard);
				player2.add(firstHandCard);
				player1.remove(0);
				player2.remove(0);
			} else {
				player1.remove(0);
				player2.remove(0);
			}
		}

		String winner;
		if(player1.size() == 0) {
			winner = "Second";
			printWinner(player2, winner);
		} else {
			winner = "First";
			printWinner(player1, winner);
		}
	}

	private static void printWinner(List<Integer> winnerDeck, String winner) {
		int sum = 0;
		for (Integer card : winnerDeck) {
			sum += card;
		}
		System.out.printf("%s player wins! Sum: %d", winner, sum);
	}
}
