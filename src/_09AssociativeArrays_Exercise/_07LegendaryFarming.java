package _09AssociativeArrays_Exercise;

import java.util.*;

public class _07LegendaryFarming {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LinkedHashMap<String, Long> farmingMap = new LinkedHashMap<>();

		String command;
		while(!"".equals(command = scanner.nextLine())) {
			String[] inputArr = command.split(" ");

			if(inputArr.length % 2 == 0) {// 1 a 2 b 3 c 4 d -> a 1 |
				for (int i = 0; i < inputArr.length; i += 2) {
					inputArr[i + 1] = inputArr[i + 1].toLowerCase();

					if(!farmingMap.containsKey(inputArr[i + 1])) {
						//Add item and quantity if not present in map
						farmingMap.put(inputArr[i + 1], Long.parseLong(inputArr[i]));
					} else {
						//Append quantity to already existing key in map (existing item)
						farmingMap.put(inputArr[i + 1], farmingMap.get(inputArr[i + 1]) + Long.parseLong(inputArr[i]));
					}

					if(isItemPresent(farmingMap)) {
						break;
					}
				}
			}

			if(isItemPresent(farmingMap)) {
				break;
			}
		}

		//Print legendary item and get materials left
		printLegendaryItem(farmingMap);

		//Set key with value 0 if key material not present
		if(!farmingMap.containsKey("shards")) {
			farmingMap.put("shards", 0L);
		} else if(!farmingMap.containsKey("fragments")) {
			farmingMap.put("fragments", 0L);
		} else if(!farmingMap.containsKey("motes")) {
			farmingMap.put("motes", 0L);
		}

		Map<String, Long> keyMaterials = new LinkedHashMap<>();
		Map<String, Long> junkMaterials = new LinkedHashMap<>();

		//Append key materials
		for (Map.Entry<String, Long> entry : farmingMap.entrySet()) {
			if(entry.getKey().equals("shards") || entry.getKey().equals("fragments") || entry.getKey().equals("motes")) {
				keyMaterials.put(entry.getKey(), entry.getValue());
			} else {
				junkMaterials.put(entry.getKey(), entry.getValue());
			}
		}

		//Print key materials left
		printKeyMaterials(keyMaterials);

		//Print junk materials
		printJunkMaterials(junkMaterials);
	}

	private static void printJunkMaterials(Map<String, Long> junkMaterials) {
		for (Map.Entry<String, Long> entry : junkMaterials.entrySet()) {
			System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
		}
	}

	private static void printKeyMaterials(Map<String, Long> keyMaterials) {
		System.out.printf("shards: %d%n", keyMaterials.get("shards"));
		System.out.printf("fragments: %d%n", keyMaterials.get("fragments"));
		System.out.printf("motes: %d%n", keyMaterials.get("motes"));
	}

	private static void printLegendaryItem(LinkedHashMap<String, Long> farmingMap) {
		if(farmingMap.containsKey("motes") && farmingMap.get("motes") >= 250) {
			farmingMap.put("motes", farmingMap.get("motes") - 250);
			System.out.println("Dragonwrath obtained!");
		} else if(farmingMap.containsKey("fragments") && farmingMap.get("fragments") >= 250) {
			farmingMap.put("fragments", farmingMap.get("fragments") - 250);
			System.out.println("Valanyr obtained!");
		} else if(farmingMap.containsKey("shards") && farmingMap.get("shards") >= 250) {
			farmingMap.put("shards", farmingMap.get("shards") - 250);
			System.out.println("Shadowmourne obtained!");
		}
	}

	private static boolean isItemPresent(LinkedHashMap<String, Long> farmingMap) {
		if(farmingMap.containsKey("shards") && farmingMap.get("shards") >= 250) {
			return true;
		} else if(farmingMap.containsKey("fragments") && farmingMap.get("fragments") >= 250) {
			return true;
		} else {
			return farmingMap.containsKey("motes") && farmingMap.get("motes") >= 250;
		}
	}
}
