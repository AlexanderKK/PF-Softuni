package _05Lists_Exercise;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _10SoftUniCoursePlanning {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<String> schedule = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

		String command;
		while(!(command = scanner.nextLine()).equals("course start")) {
			if(command.startsWith("Add")) {
				String lesson = command.split(":")[1];

				if(!schedule.contains(lesson)) {
					schedule.add(lesson);
				}
			} else if(command.startsWith("Insert")) {
				String lesson = command.split(":")[1];
				int index = Integer.parseInt(command.split(":")[2]);

				if(!schedule.contains(lesson) && index > -1 && index < schedule.size()) {
					schedule.add(index, lesson);
				}
			} else if(command.startsWith("Remove")) {
				String lesson = command.split(":")[1];
				int indexNext = schedule.indexOf(lesson);
				schedule.remove(lesson);

				if(schedule.get(indexNext).equals(lesson + "-Exercise")) {
					schedule.remove(indexNext);
				}
			} else if(command.startsWith("Swap")) {
				String lesson = command.split(":")[1];
				String lesson2 = command.split(":")[2];

				if(schedule.contains(lesson) && schedule.contains(lesson2)) {
					int indexLesson1 = schedule.indexOf(lesson);
					int indexLesson2 = schedule.indexOf(lesson2);

					schedule.set(indexLesson1, lesson2);
					schedule.set(indexLesson2, lesson);

					if(indexLesson1 != 0 && indexLesson2 != schedule.size() - 1 && schedule.get(indexLesson2 + 1).equals(schedule.get(indexLesson1) + "-Exercise")) {
						String lastEl = schedule.get(indexLesson2 + 1);
						schedule.remove(lastEl);
						schedule.add(indexLesson1 + 1, lastEl);
					} else if(indexLesson1 != schedule.size() - 1 && indexLesson2 != 0 && schedule.get(indexLesson1 + 1).equals(schedule.get(indexLesson2) + "-Exercise")) {
						String lastEl = schedule.get(indexLesson1 + 1);
						schedule.remove(lastEl);
						schedule.add(indexLesson2 + 1, lastEl);
					}
				}
			} else if(command.startsWith("Exercise")) {
				String lesson = command.split(":")[1];

				if(!schedule.contains(lesson)) {
					schedule.add(lesson);
					schedule.add(lesson + "-Exercise");
				} else {
					int indexExistingLesson = schedule.indexOf(lesson);
					schedule.add(indexExistingLesson, lesson + "-Exercise");
				}
			}
		}

		for (int i = 0; i < schedule.size(); i++) {
			String lesson = schedule.get(i);
			System.out.printf("%d.%s%n", i + 1, lesson);
		}
	}
}
