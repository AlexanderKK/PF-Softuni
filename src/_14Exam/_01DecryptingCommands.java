package _14Exam;

import java.util.Scanner;

public class _01DecryptingCommands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());

        String command;
        while(!"Finish".equals(command = scanner.nextLine())) {
            String[] cmdArr = command.split(" ");
            String cmd = cmdArr[0];

            if(cmd.equals("Replace")) {
                String oldSubStr = cmdArr[1];
                String substitute = cmdArr[2];

                String newStr = input.toString().replace(oldSubStr, substitute);
                input = new StringBuilder(newStr);

                System.out.println(input);
            } else if(cmd.equals("Cut")) {
                int startIndex = Integer.parseInt(cmdArr[1]);
                int endIndex = Integer.parseInt(cmdArr[2]);

                if(areIndicesValid(startIndex, endIndex, input)) {
                    input.delete(startIndex, endIndex + 1);

                    System.out.println(input);
                } else {
                    System.out.println("Invalid indices!");
                }
            } else if(cmd.equals("Make")) {
                String casing = cmdArr[1];

                if(casing.equals("Upper")) {
                    input = new StringBuilder(input.toString().toUpperCase());
                } else if(casing.equals("Lower")) {
                    input = new StringBuilder(input.toString().toLowerCase());
                }

                System.out.println(input);
            } else if(cmd.equals("Check")) {
                String str = cmdArr[1];

                if(input.indexOf(str) != -1) {
                    System.out.printf("Message contains %s%n", str);
                } else {
                    System.out.printf("Message doesn't contain %s%n", str);
                }
            } else if(cmd.equals("Sum")) {
                int startIndex = Integer.parseInt(cmdArr[1]);
                int endIndex = Integer.parseInt(cmdArr[2]);

                if(areIndicesValid(startIndex, endIndex, input)) {
                    String subStr = input.substring(startIndex, endIndex + 1);

                    int sumASCII = 0;
                    for (char ch : subStr.toCharArray()) {
                        sumASCII += ch;
                    }

                    System.out.println(sumASCII);
                } else {
                    System.out.println("Invalid indices!");
                }
            }
        }
    }

    private static boolean areIndicesValid(int start, int end, StringBuilder sb) {
        return start >= 0 && start <= end && end <= sb.length() - 1;
    }
}
