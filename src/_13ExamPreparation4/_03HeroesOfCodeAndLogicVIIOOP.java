package _13ExamPreparation4;

import _13ExamPreparation1._03NeedForSpeedIII;

import java.util.*;

public class _03HeroesOfCodeAndLogicVIIOOP {
    public static class Party {
        private static final Set<Hero> party = new LinkedHashSet<>();

        private static String getPartyData() {
            String result = "";
            for (Hero hero : party) {
                result += hero.getName() + "\n  HP: " + hero.getHealth() + "\n  MP: " + hero.getMana() + "\n";
            }
            return result;
        }

        private static void castSpell(String name, int mana, String spell) {
            if(mana < 0) {
                mana = 0;
            }

            for (Hero hero : party) {
                if(hero.getName().equals(name)) {
                    int totalMana = hero.getMana();

                    if(totalMana >= mana) {
                        totalMana -= mana;

                        //Update mana of hero
                        hero.setMana(totalMana);

                        //Print hero data
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", name, spell, totalMana);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", name, spell);
                    }
                }
            }
        }

        private static void takeDamage(String name, int damage, String attacker) {
            for (Hero hero : party) {
                if(hero.getName().equals(name)) {
                    if(damage < 0) {
                        damage = 0;
                    }

                    int totalHealth = hero.getHealth();
                    totalHealth -= damage;

                    if(totalHealth > 0) {
                        //Update health of hero
                        hero.setHealth(totalHealth);

                        //Print hero data
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", name, damage, attacker, totalHealth);
                    } else {
                        party.remove(hero);

                        System.out.printf("%s has been killed by %s!%n", name, attacker);
                    }
                }
            }
        }

        private static void rechargeMana(String name, int mana) {
            for (Hero hero : party) {
                if(name.equals(hero.getName())) {
                    if(mana < 0) {
                        mana = 0;
                    }

                    //Recharge hero with mana
                    int totalMana = hero.getMana();
                    totalMana += mana;

                    //Set a limit of 200 mana
                    if(totalMana > 200) {
                        //maximum mana - current mana = mana left to add until max mana
                        mana = 200 - hero.getMana();
                        totalMana = 200;
                    }

                    //Save hero data
                    hero.setMana(totalMana);

                    System.out.printf("%s recharged for %d MP!%n", name, mana);
                }
            }
        }

        private static void heal(String name, int health) {
            for (Hero hero : party) {
                if(name.equals(hero.getName())) {
                    if(health < 0) {
                        health = 0;
                    }

                    //Recharge hero with health
                    int totalHealth = hero.getHealth();
                    totalHealth += health;

                    //Set a limit of 100 health
                    if(totalHealth > 100) {
                        //maximum health - current heath = health left to add until max health
                        health = 100 - hero.getHealth();
                        totalHealth = 100;
                    }

                    //Save hero data
                    hero.setHealth(totalHealth);

                    System.out.printf("%s healed for %d HP!%n", name, health);
                }
            }
        }
    }

    public static class Hero {
        private String name;
        private int health;
        private int mana;

        public String getName() {
            return name;
        }

        public int getHealth() {
            return health;
        }

        public int getMana() {
            return mana;
        }

        public Hero(String name, int health, int mana) {
            this.name = name;
            this.health = health;
            this.mana = mana;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public void setMana(int mana) {
            this.mana = mana;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] heroData = scanner.nextLine().split(" ");

            String name = heroData[0];
            int health = Integer.parseInt(heroData[1]);
            int mana = Integer.parseInt(heroData[2]);

            if(health < 0) {
                health = 0;
            }

            if(mana < 0) {
                mana = 0;
            }

            Party.party.add(new Hero(name, health, mana));
        }

        String command;
        while(!"End".equals(command = scanner.nextLine())) {
            String[] action = command.split(" - ");
            String cmd = action[0];
            //Name
            String name = action[1];

            if(cmd.equals("CastSpell")) {
                int mana = Integer.parseInt(action[2]);
                String spell = action[3];

                Party.castSpell(name, mana, spell);
            } else if(cmd.equals("TakeDamage")) {
                int damage = Integer.parseInt(action[2]);
                String attacker = action[3];

                Party.takeDamage(name, damage, attacker);
            } else if(cmd.equals("Recharge")) {
                int mana = Integer.parseInt(action[2]);

                Party.rechargeMana(name, mana);
            } else if(cmd.equals("Heal")) {
                int health = Integer.parseInt(action[2]);

                Party.heal(name, health);
            }
        }

        System.out.println(Party.getPartyData());
    }
}
