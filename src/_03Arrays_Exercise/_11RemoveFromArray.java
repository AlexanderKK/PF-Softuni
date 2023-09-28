package _03Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _11RemoveFromArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//Read Input
		System.out.print("Array of integers: ");
		String[] textArray = scanner.nextLine().split(" ");

		//Transform String array into an Integer array
		int[] numbers = new int[textArray.length];
		for (int i = 0; i < textArray.length; i++) {
			numbers[i] = Integer.parseInt(textArray[i]);
		}

		//Read position
		System.out.print("Delete by index: ");
		int index = Integer.parseInt(scanner.next());

		//Remove element at current position
		numbers = remove(numbers, index);

		//Print array
		printArr(numbers);
	}

	public static void printArr(int[] arr) {
		System.out.print("Array is: ");

		for (int i = 0; i < arr.length; i++) {
			if(i != arr.length - 1) {
				System.out.print(arr[i] + " ");
			} else {
				System.out.print(arr[i]);
			}
		}
	}

	public static int[] remove(int[] arr, int index) {
		if (arr == null || index < 0 || index >= arr.length) {
			return arr;
		}

		int[] newArr = new int[arr.length - 1];

		//1
		for (int i = 0, j = 0; i < arr.length; i++) {
			if(i != index) {
				newArr[j++] = arr[i];
			}
		}


		//2
//		for (int i = index; i < arr.length - 1; i++) {
//			arr[i] = arr[i + 1];
//		}
//
//		for (int i = 0; i < arr.length - 1; i++) {
//			newArr[i] = arr[i];
//		}


		//3
//		for (int i = 0; i < index; i++) {
//			newArr[i] = arr[i];
//		}
//
//		for (int i = index; i < arr.length - 1; i++) {
//			newArr[i] = arr[i + 1];
//		}

		return newArr;
	}
}
