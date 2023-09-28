package _05Lists_Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class _08AnonymousTreat {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<String> anonymous = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

		String command;
		while(!"3:1".equals(command = scanner.nextLine())) {
			String cmd = command.split(" ")[0];

			//команда за сливане
			if(cmd.equals("merge")) {
				//Начало и край на обхват на сливане
				int startIndex = Integer.parseInt(command.split(" ")[1]);
				int endIndex = Integer.parseInt(command.split(" ")[2]);

				//Сливане на парченца елементчета
				merge(anonymous, startIndex, endIndex);
			} else if(cmd.equals("divide")) {
				int index = Integer.parseInt(command.split(" ")[1]);
				int count = Integer.parseInt(command.split(" ")[2]);

				//Разделяне на елемент на парченца
				divide(anonymous, index, count);
			}
		}

		System.out.println(String.join(" ", anonymous));
	}

	private static void merge(List<String> anonymous, int startIndex, int endIndex) {
		//Проверки за валидност на индекс - допустим само в рамките на списъка
		if(startIndex < 0 || startIndex >= anonymous.size()) {
			startIndex = 0;
		}
		if(endIndex < 0 || endIndex >= anonymous.size()) {
			endIndex = anonymous.size() - 1;
		}

		//Конкатенация в нов елемент
		String newElement = anonymous.get(startIndex);
		for (int i = startIndex + 1; i <= endIndex; i++) {
			newElement += anonymous.get(i);
		}

		//Заменяне на елемент на започващие индекс с нов елемент получен след конкатенация на елементи между start & end index
		anonymous.set(startIndex, newElement);

		//Изтриване на елементите след слятия
		for (int i = endIndex; i > startIndex; i--) {
			anonymous.remove(i);
		}
	}

	private static void divide(List<String> anonymous, int index, int count) {
		//Проверка за валиден индекс и брой дялове
		String strToDivide = anonymous.get(index);
		if(index <= anonymous.size() - 1 && count != 0 && count != 1 && count <= strToDivide.length()) {
			anonymous.remove(index);

			//Символи във всяка част
			int countSymbolsPerPart = strToDivide.length() / count;

			//всички равни части без последната
			int beginIndex = 0;
			for (int part = 1; part < count; part++) {
				String textPerPart = strToDivide.substring(beginIndex, beginIndex + countSymbolsPerPart);
				anonymous.add(index, textPerPart);
				index++;   //място на поставяне на разбитата част в главния списък
				beginIndex += countSymbolsPerPart;
			}

			//последната част
			String testLastParts = strToDivide.substring(beginIndex);
			anonymous.add(testLastParts);
		}


//		String strToDivide = anonymous.get(index);
//
//		if(index >= 0 && index <= anonymous.size() - 1 && count != 0 && count != 1 && count <= strToDivide.length()) {
//			//стъпка (индекс, на който ще делим текста)
//			int steps = strToDivide.length() / count;
//
//			List<String> list= new ArrayList<>();
//			for (int i = 0; i < strToDivide.length(); i += steps) {
//				String subStr;
//
//				//Докато не сме стигнали края делим от индекса до индекса + стъпката abcdef  6 / 4 = 1 a b c def
//				if(steps == 1 && i <= count - 1) {
//					if(i == count - 1) {
//						list.add(strToDivide.substring(i));
//						break;
//					} else {
//						subStr = strToDivide.substring(i, i + steps);
//						list.add(subStr);
//					}
//				} else {
//					if(i < strToDivide.length() - 1) {
//						//добавяме в списък
//						subStr = strToDivide.substring(i, i + steps);
//						list.add(subStr);
//					} else {
//						//накрая добавяме и последният символ от текста
//						list.add(String.valueOf(strToDivide.charAt(strToDivide.length() - 1)));
//					}
//				}
//			}
//
//			if(strToDivide.length() % 2 != 0 && steps > 1) {
//				//При нечетна дължина на текста сливаме предпоследния елемент с последния
//				String lastElement = list.get(list.size() - 2) + list.get(list.size() - 1);
//
//				//Заменяме предпоследния елемент с конкатенирания
//				list.set(list.size() - 2, lastElement);
//
//				//Премахваме последния елемент
//				list.remove(list.size() - 1);
//			}
//
//			//Разделеният текст се получава от сливане на елементите на списъка
//			String dividedStr = list.toString().replace("[", "").replace("]","").replaceAll(",","");
//
//			//Заменяме началния текст с готовия разделен текст
//			anonymous.set(index, dividedStr);
//		}
	}
}
