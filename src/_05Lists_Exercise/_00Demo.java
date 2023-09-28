package _05Lists_Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class _00Demo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<String> list = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

		list.add(list.size(), String.valueOf(0));

		System.out.println(String.join(" ", list));

		list.retainAll(Arrays.asList("0"));

		System.out.println(String.join(" ", list));
	}
}
