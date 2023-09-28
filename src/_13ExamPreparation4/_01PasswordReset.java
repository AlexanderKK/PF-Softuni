package _13ExamPreparation4;

import java.util.Scanner;

public class _01PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder password = new StringBuilder(scanner.nextLine());

        String command;
        while(!"Done".equals(command = scanner.nextLine())) {
            String[] input = command.split(" ");
            String cmd = input[0];

            if(cmd.equals("TakeOdd")) {
                String newPassword = "";
                for (int i = 0; i < password.length(); i++) {
                    if (i % 2 != 0)  {
                        newPassword += password.charAt(i);
                    }
                }
                password = new StringBuilder(newPassword);

                System.out.println(password);
            } else if(cmd.equals("Cut")) {
                int index = Integer.parseInt(input[1]);
                int length = Integer.parseInt(input[2]);

                if(index >= 0 && index <= password.length()) {
                    password.delete(index, index + length);
                }

                System.out.println(password);
            } else if(cmd.equals("Substitute")) {
                String subStr = input[1];
                String substitute = input[2];

                if(password.indexOf(subStr) >= 0) {
                    String pass = password.toString();
                    pass = pass.replace(subStr, substitute);
                    password = new StringBuilder(pass);

                    System.out.println(password);
                } else {
                    System.out.println("Nothing to replace!");
                }
            }
        }

        System.out.println("Your password is: " + password);
    }
}
