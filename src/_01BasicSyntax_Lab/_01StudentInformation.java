package _01BasicSyntax_Lab;

import java.util.Scanner;

public class _01StudentInformation {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        double grade = Double.parseDouble(scanner.nextLine());

        String result = String.format("Name: %s, Age: %d, Grade: %.2f", name, age, grade);
        System.out.println(result);
    }
}