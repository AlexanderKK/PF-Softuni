package _13ExamPreparation3;

import java.util.*;

public class _03Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Integer>> cities = new LinkedHashMap<>();

        String command;
        while(!"Sail".equals(command = scanner.nextLine())) {
            String[] input = command.split("\\|\\|");

            String city = input[0];
            int population = Integer.parseInt(input[1]);
            int gold = Integer.parseInt(input[2]);

            if(population > 0 && gold > 0) {
                if(!cities.containsKey(city)) {
                    cities.put(city, new ArrayList<>(2));

                    //Add initial values
                    cities.get(city).add(0);
                    cities.get(city).add(0);
                }

                List<Integer> values = cities.get(city);

                //Add to values
                values.set(0, values.get(0) + population);
                values.set(1, values.get(1) + gold);
            }
        }

        while(!"End".equals(command = scanner.nextLine())) {
            String[] input = command.split("=>");
            String cmd = input[0];

            if(cmd.equals("Prosper")) {
                String city = input[1];
                int gold = Integer.parseInt(input[2]);

                if(gold < 0) {
                    System.out.println("Gold added cannot be a negative number!");
                } else {
                    cities.get(city).set(1, cities.get(city).get(1) + gold);

                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, city, cities.get(city).get(1));
                }
            } else if(cmd.equals("Plunder")) {
                String city = input[1];
                int people = Integer.parseInt(input[2]);
                int gold = Integer.parseInt(input[3]);

                List<Integer> values = cities.get(city);

                //Kill people and steal gold
                values.set(0, values.get(0) - people);
                values.set(1, values.get(1) - gold);

                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", city, gold, people);

                if(values.get(0) <= 0 || values.get(1) <= 0) {
                    cities.remove(city);
                    System.out.printf("%s has been wiped off the map!%n", city);
                }
            }
        }

        printCitiesLeft(cities);
    }

    public static void printCitiesLeft(Map<String, List<Integer>> cities) {
        if(cities.size() > 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cities.size());
            cities.forEach((city, stats) -> {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", city, stats.get(0), stats.get(1));
            });
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
