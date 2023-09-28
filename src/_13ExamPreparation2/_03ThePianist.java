package _13ExamPreparation2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _03ThePianist {
	static Map<String, String> pieceComposerMap = new LinkedHashMap<>();
	static Map<String, String> pieceKeyMap = new LinkedHashMap<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 1; i <= n; i++) {
			String[] inputArr = scanner.nextLine().split("\\|");

			fillMaps(inputArr);
		}

		String command;
		while(!"Stop".equals(command = scanner.nextLine())) {
			String[] cmdArr = command.split("\\|");

			if(command.startsWith("Add")) {
				String piece = cmdArr[1];
				String composer = cmdArr[2];
				String key = cmdArr[3];

				appendPiece(piece, composer, key);
			} else if(command.startsWith("Remove")) {
				String piece = cmdArr[1];

				removePiece(piece);
			} else if(command.startsWith("ChangeKey")) {
				String piece = cmdArr[1];
				String newKey = cmdArr[2];

				changeKey(piece, newKey);
			}
		}

		for (Map.Entry<String, String> entry : pieceComposerMap.entrySet()) {
			System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue(), pieceKeyMap.get(entry.getKey()));
		}
	}

	private static void changeKey(String piece, String newKey) {
		if(pieceKeyMap.containsKey(piece)) {
			pieceKeyMap.put(piece, newKey);
			System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
		} else {
			System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
		}
	}

	private static void removePiece(String piece) {
		if(pieceComposerMap.containsKey(piece) || pieceKeyMap.containsKey(piece)) {
			pieceComposerMap.remove(piece);
			pieceKeyMap.remove(piece);
			System.out.printf("Successfully removed %s!%n", piece);
		} else {
			System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
		}
	}

	private static void appendPiece(String piece, String composer, String key) {
		if(pieceComposerMap.containsKey(piece) || pieceKeyMap.containsKey(piece)) {
			System.out.printf("%s is already in the collection!%n", piece);
		} else {
			pieceComposerMap.put(piece, composer);
			pieceKeyMap.put(piece, key);
			System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
		}
	}

	private static void fillMaps(String[] inputArr) {
		String piece = inputArr[0];
		String composer = inputArr[1];
		String key = inputArr[2];

		pieceComposerMap.putIfAbsent(piece, composer);
		pieceKeyMap.putIfAbsent(piece, key);
	}
}
