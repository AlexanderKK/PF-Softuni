package _13ExamPreparation4;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _03HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> heroHP = new LinkedHashMap<>();
        Map<String, Integer> heroMP = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] heroData = scanner.nextLine().split(" ");

            String hero = heroData[0];
            int health = Integer.parseInt(heroData[1]);
            int mana = Integer.parseInt(heroData[2]);

            if(health < 0) {
                health = 0;
            }

            if(mana < 0) {
                mana = 0;
            }

            heroHP.put(hero, health);
            heroMP.put(hero, mana);
        }

        String command;
        while(!"End".equals(command = scanner.nextLine())) {
            String[] action = command.split(" - ");
            String cmd = action[0];

            if(cmd.equals("CastSpell")) {
                String hero = action[1];
                int mana = Integer.parseInt(action[2]);
                String spell = action[3];

                if(mana < 0) {
                    mana = 0;
                }

                int totalMana = heroMP.get(hero);
                if(totalMana >= mana) {
                    totalMana -= mana;

                    //Update mana of hero
                    heroMP.put(hero, totalMana);

                    //Print hero data
                    System.out.printf("%s has successfully cast %s and now has %d MP!%n", hero, spell, totalMana);
                } else {
                    System.out.printf("%s does not have enough MP to cast %s!%n", hero, spell);
                }
            } else if(cmd.equals("TakeDamage")) {
                String hero = action[1];
                int damage = Integer.parseInt(action[2]);
                String attacker = action[3];

                if(damage < 0) {
                    damage = 0;
                }

                int totalHealth = heroHP.get(hero);
                totalHealth -= damage;

                if(totalHealth > 0) {
                    //Update health of hero
                    heroHP.put(hero, totalHealth);

                    //Print hero data
                    System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", hero, damage, attacker, totalHealth);
                } else {
                    heroHP.remove(hero);
                    heroMP.remove(hero);

                    System.out.printf("%s has been killed by %s!%n", hero, attacker);
                }
            } else if(cmd.equals("Recharge")) {
                String hero = action[1];
                int mana = Integer.parseInt(action[2]);

                if(mana < 0) {
                    mana = 0;
                }

                //Recharge hero with mana
                int totalMana = heroMP.get(hero);
                totalMana += mana;

                //Set a limit of 200 mana
                if(totalMana > 200) {
                    //maximum mana - current mana = mana left to add until max mana
                    mana = 200 - heroMP.get(hero);
                    totalMana = 200;
                }

                //Save hero data
                heroMP.put(hero, totalMana);

                System.out.printf("%s recharged for %d MP!%n", hero, mana);
            } else if(cmd.equals("Heal")) {
                String hero = action[1];
                int health = Integer.parseInt(action[2]);

                if(health < 0) {
                    health = 0;
                }

                //Recharge hero with health
                int totalHealth = heroHP.get(hero);
                totalHealth += health;

                //Set a limit of 100 health
                if(totalHealth > 100) {
                    //maximum health - current heath = health left to add until max health
                    health = 100 - heroHP.get(hero);
                    totalHealth = 100;
                }

                //Save hero data
                heroHP.put(hero, totalHealth);

                System.out.printf("%s healed for %d HP!%n", hero, health);
            }
        }

        heroHP.forEach((hero, health) -> System.out.printf("%s\n  HP: %s\n  MP: %s\n", hero, health, heroMP.get(hero)));
    }
}
