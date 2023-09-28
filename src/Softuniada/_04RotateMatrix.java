package Softuniada;

import java.util.Arrays;
import java.util.Scanner;

public class _04RotateMatrix {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int rows = Integer.parseInt(scanner.nextLine());
		int cols = rows;

		int[][] matrix = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = numbers[j];
			}
		}

		int[][] rotatedMatrix = new int[cols][rows];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				rotatedMatrix[j][rows - 1 - i] = matrix[i][j];
			}
		}

		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				System.out.print(rotatedMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
