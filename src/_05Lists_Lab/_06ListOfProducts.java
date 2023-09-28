package _05Lists_Lab;

import java.util.*;

public class _06ListOfProducts {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine()); //брой на продукти
		List<String> products = new ArrayList<>(); //списък с продукти

		for (int i = 0; i < n; i++) {
			String product = scanner.nextLine();
			products.add(product);
		}

		Collections.sort(products); //sort -> във възходящ ред (азбучен ред)

//		int number = 1;
//		for (String product : products) {
//			System.out.printf("%d.%s%n", number, product);
//			number++;
//		}

		for (int i = 0; i < products.size(); i++) {
			System.out.printf("%d.%s%n", i + 1, products.get(i));
		}
	}
}
