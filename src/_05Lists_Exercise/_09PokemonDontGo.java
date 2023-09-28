package _05Lists_Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class _09PokemonDontGo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//Получаване на списък от числа
		List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

		//Декларация на списък за премахнати елементи
		List<Integer> removedNumbers = new ArrayList<>();

		while(numbers.size() > 0) {
			//Въвеждане на индекс за изтриване
			int index = Integer.parseInt(scanner.nextLine());
			int removedElement;

			if(index < 0) {
				//При индекс отговарящ на условието се премахва последния елемент от списъка и се копира в първия елемент

				//1. Взимаме последния елемент
				int lastElement = numbers.get(numbers.size() - 1);

				//2. Взимаме първия елемент
				int firstElement = numbers.get(0);

				//3. Заменяме първи елемент с последен
				numbers.set(0, lastElement);

				//4. Запазване на елемент за изтриване (първи)
				removedElement = firstElement;
			} else if(index > numbers.size() - 1) {
				//При индекс отговарящ на условието се премахва първия елемент от списъка и се копира в последния елемент

				//1. Взимаме първия елемент
				int firstElement = numbers.get(0);

				//2. Взимаме последния елемент
				int lastElement = numbers.get(numbers.size() - 1);

				//3. Замяна на последен елемент с първи
				numbers.set(numbers.size() - 1, firstElement);

				//4. Запазване на елемент за изтриване (последен елемент)
				removedElement = lastElement;
			} else {
				//1. Запазване на елемент за изтриване
				removedElement = numbers.get(index);

				//2. Премахване на елемент за изтриване от списъка с числа
				numbers.remove(index);
			}

			//Добавяне на изтрития елемент в списък с премахнати елементи
			removedNumbers.add(removedElement);

			//Обхождане на списъка с числа и увеличаване / намаляване на стойности на елементи
			// (елементи със стойност <= стойността на премахнатия се увеличават със стойността на премахнатия)
			// (елементи със стойност > стойността на премахнатия се намаляват със стойността на премахнатия)
			modifyList(numbers, removedElement);
		}

		//Извеждане на сумата от елементите на списъка с премахнати елементи
		printSumOfRemovedElements(removedNumbers);
	}

	private static void modifyList(List<Integer> numbers, int removedElement) {
		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) <= removedElement) {
				numbers.set(i, numbers.get(i) + removedElement);
			} else {
				numbers.set(i, numbers.get(i) - removedElement);
			}
		}
	}

	private static void printSumOfRemovedElements(List<Integer> removedNumbers) {
		int sum = 0;
		for (Integer removedNumber : removedNumbers) {
			sum += removedNumber;
		}
		System.out.println(sum);
	}
}
