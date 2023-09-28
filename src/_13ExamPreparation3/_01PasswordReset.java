package _13ExamPreparation3;

import java.util.Scanner;

public class _01PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder key = new StringBuilder(scanner.nextLine());

        String command;
        while(!"Generate".equals(command = scanner.nextLine())) {
            String[] input = command.split(">>>");
            String cmd = input[0];

            if(cmd.equals("Contains")) {
                String subStr = input[1];

                if(key.indexOf(subStr) >= 0) {
                    System.out.printf("%s contains %s%n", key, subStr);
                } else {
                    System.out.println("Substring not found!");
                }
            } else if(cmd.equals("Flip")) {
                String casing = input[1];
                int startIndex = Integer.parseInt(input[2]);
                int endIndex = Integer.parseInt(input[3]);

                if(startIndex >= 0 && startIndex <= endIndex && endIndex <= key.length()) {
                    if(casing.equals("Upper")) {
                        //Get subStr from key and make it uppercase
                        String subStr = key.substring(startIndex, endIndex).toUpperCase();

                        //Replace with new subStr
                        key.replace(startIndex, endIndex, subStr);
                    } else if(casing.equals("Lower")) {
                        //Get subStr from key and make it lowercase
                        String subStr = key.substring(startIndex, endIndex).toLowerCase();

                        //Replace with new subStr
                        key.replace(startIndex, endIndex, subStr);
                    }
                    System.out.println(key);
                }
            } else if(cmd.equals("Slice")) {
                int startIndex = Integer.parseInt(input[1]);
                int endIndex = Integer.parseInt(input[2]);

                if(startIndex >= 0 && startIndex <= endIndex && endIndex <= key.length()) {
                    key.delete(startIndex, endIndex);
                }
                System.out.println(key);
            }
        }

        System.out.printf("Your activation key is: %s%n", key);
    }
}
