package _14Exam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02MessageDecrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^(?<prefix>[$%])(?<tag>[A-Z][a-z]{2,})\\1:\\s(?<message>(\\[\\d+\\]\\|){3})$";
        Pattern pattern = Pattern.compile(regex);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();

            Matcher matcher = pattern.matcher(input);
            if(matcher.matches()) {
                String[] message = matcher.group("message").replace("[", "").replace("]", "").split("\\|");

                StringBuilder decryptedMsg = new StringBuilder();
                for (String element : message) {
                    decryptedMsg.append((char) Integer.parseInt(element));
                }

                System.out.printf("%s: %s%n", matcher.group("tag"), decryptedMsg);
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
