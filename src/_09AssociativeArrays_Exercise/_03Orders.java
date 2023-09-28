package _09AssociativeArrays_Exercise;

import java.util.*;

public class _03Orders {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LinkedHashMap<String, String> resourcesMap = new LinkedHashMap<>();

		String command;
		while(!"buy".equals(command = scanner.nextLine())) {
			String product = command.split(" ")[0];
			String priceAndQuantity = command.substring(command.indexOf(" ") + 1);

			double price = Double.parseDouble(priceAndQuantity.split(" ")[0]);
			int quantity = Integer.parseInt(priceAndQuantity.split(" ")[1]);

			if(!resourcesMap.containsKey(product)) {
				resourcesMap.put(product, String.format("%.2f %d", price, quantity));
			} else {
				double existingPrice = Double.parseDouble(resourcesMap.get(product).split(" ")[0]);
				if(price != existingPrice) {
					existingPrice = price;
				}
				int newQuantity = Integer.parseInt(resourcesMap.get(product).split(" ")[1]) + quantity;
				resourcesMap.put(product, String.format("%.2f %d", existingPrice, newQuantity));
			}
		}

		for (Map.Entry<String, String> entry : resourcesMap.entrySet()) {
			double price = Double.parseDouble(entry.getValue().split(" ")[0]);
			int quantity = Integer.parseInt(entry.getValue().split(" ")[1]);

			System.out.printf("%s -> %.2f%n", entry.getKey(), price * quantity);
		}
	}
}
