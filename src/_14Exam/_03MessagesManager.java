package _14Exam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _03MessagesManager {
    public static Map<String, Integer> userMsgSent = new LinkedHashMap<>();
    public static Map<String, Integer> userMsgReceived = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());
        if(capacity < 1 || capacity > 10000) {
            return;
        }

        String command;
        while(!"Statistics".equals(command = scanner.nextLine())) {
            String[] input = command.split("=");

            String cmd = input[0];
            if(cmd.equals("Add")) {
                String user = input[1];
                int sentMessages = Integer.parseInt(input[2]);
                int receivedMessages = Integer.parseInt(input[3]);

                userMsgSent.putIfAbsent(user, sentMessages);
                userMsgReceived.putIfAbsent(user, receivedMessages);
            } else if(cmd.equals("Message")) {
                String sender = input[1];
                String receiver = input[2];

                if(userMsgSent.containsKey(sender) && userMsgReceived.containsKey(receiver)) {
                    //Append msg to sender
                    userMsgSent.put(sender, userMsgSent.get(sender) + 1);

                    //Append msg to receiver
                    userMsgReceived.put(receiver, userMsgReceived.get(receiver) + 1);

                    //Check capacity
                    if(userMsgSent.get(sender) + userMsgReceived.get(sender) >= capacity) {
                        //Remove records for current user
                        userMsgSent.remove(sender);
                        userMsgReceived.remove(sender);

                        System.out.printf("%s reached the capacity!%n", sender);
                    }

                    if(userMsgReceived.get(receiver) + userMsgSent.get(receiver) >= capacity) {
                        //Remove records for current user
                        userMsgReceived.remove(receiver);
                        userMsgSent.remove(receiver);

                        System.out.printf("%s reached the capacity!%n", receiver);
                    }
                }
            } else if(cmd.equals("Empty")) {
                String user = input[1];

                if(user.equals("All")) {
                    //Remove records of all users
                    userMsgSent.clear();
                    userMsgReceived.clear();
                } else {
                    //Remove records of current user
                    userMsgSent.remove(user);
                    userMsgReceived.remove(user);
                }
            }
        }

        printUsersMessages();
    }

    private static void printUsersMessages() {
        System.out.printf("Users count: %d%n", userMsgSent.size());

        userMsgSent.forEach((user, sentMessages) -> System.out.printf("%s - %d%n", user, sentMessages + userMsgReceived.get(user)));
    }
}
