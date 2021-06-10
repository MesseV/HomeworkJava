package GameRPG;
import GameRPG.Characters.NPC;
import GameRPG.Characters.PlayerCharacter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PlayerCharacter player = new PlayerCharacter(40,
                15,
                "Hero",
                0,
                1,
                0,
                30,
                0);


        int score = 0;
        while (player.getHp() > 0) {
            traversingWorld(player);
            score++;
        }
        System.out.println();
        System.out.println("Game over!");
        System.out.println("Congratulations, you defeated " + score + " enemies.");


    }


    public static void battlePhase(PlayerCharacter player, NPC enemy) {
        Scanner reader = new Scanner(System.in);
        while (player.getHp() > 0 && enemy.getHp() > 0) {
            System.out.println("1. Aggressive stance(+8 att/-3 armour)  -  " +
                    "2. Defensive stance(-8 att/+3 armour).  -  " +
                    "3.Balanced stance(-2 att/-0 armour).");
            int playerChoice = reader.nextInt();
            if (player.getHp() > 0) {
                int playerAttack = (int) (Math.random() * (player.getAttackPower() + 1) - 1 + 1);
                if (playerChoice == 3) {
                    System.out.println("You strike with a penalty to attack of 2 and no penalty to armour.");
                    if (playerAttack - 2 >= 0) {
                        System.out.println("You deal " + (playerAttack - 2) + " damage.");
                    } else {
                        System.out.println("You deal 0 damage.");
                    }
                    enemy.setHp(enemy.getHp() - (playerAttack - 2));
                } else if (playerChoice == 1) {
                    System.out.println("You lash out with a bonus to attack of 8 and a penalty to armour of 3.");
                    System.out.println("You deal " + (playerAttack + 8) + " damage.");
                    enemy.setHp(enemy.getHp() - (playerAttack + 8));
                } else if (playerChoice == 2) {
                    System.out.println("You defend with a penalty to attack of 8 and a bonus to armour of 3.");
                    if (playerAttack - 8 >= 0) {
                        System.out.println("You deal " + (playerAttack - 8) + " damage.");
                    } else {
                        System.out.println("You deal 0 damage.");
                    }
                    enemy.setHp(enemy.getHp() - (playerAttack - 8));
                }
                System.out.println("Enemy life points: " + enemy.getHp());
                System.out.println("----------------------------------------");
            }
            if (enemy.getHp() > 0) {
                int enemyAttack = (int) (Math.random() * (enemy.getAttackPower() + 1) - 1 + 1);
                if (playerChoice == 3) {
                    player.setHp(player.getHp() - (enemyAttack - player.getArmour()));
                    System.out.println("The enemy attacks you and deals " + enemyAttack + " damage. " +
                            "Your armour blocks " + player.getArmour() + " damage.");
                } else if (playerChoice == 1) {
                    player.setHp(player.getHp() - (enemyAttack + 3));
                    System.out.println("The enemy attacks you and deals " + (enemyAttack + 3) + " damage. " +
                            "Your armour blocks " + (player.getArmour() - 1) + " damage.");
                } else if (playerChoice == 2) {
                    if (enemyAttack - (player.getArmour() + 2) > 0) {
                        player.setHp(player.getHp() - (enemyAttack - (player.getArmour() + 3)));
                    }
                    System.out.println("The enemy attacks you and deals " + enemyAttack + " damage. " +
                            "Your armour blocks " + (player.getArmour() + 3) + " damage.");
                }
                System.out.println("Your life points: " + player.getHp());
                System.out.println("----------------------------------------");
            }
        }
        if (enemy.getHp() <= 0) {
            System.out.println("You defeated the " + enemy.getName() + ".");
            switch (enemy.getName()) {
                case "rat" -> {
                    player.setExperience(player.getExperience() + 4);
                    System.out.println("You received 4 experience points.");
                }
                case "Thug" -> {
                    player.setExperience(player.getExperience() + 6);
                    System.out.println("You received 6 experience points.");
                }
                case "Assassin" -> {
                    player.setExperience(player.getExperience() + 8);
                    System.out.println("You received 8 experience points.");
                }
            }
            System.out.println();
            System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
        }
    }

    public static void displayBattleResults(PlayerCharacter player, NPC enemy) {
        if (player.getHp() > 0) {
            Scanner reader = new Scanner(System.in);
            System.out.println("After the battle you assess your situation - Life points: " + player.getHp());
            System.out.println("You now have " + player.getExperience() + " experience points.");
            if (player.getExperience() >= (player.getLevel() * 5 + 10)) {
                player.setSkillPoints(player.getSkillPoints() + 1);
                player.setLevel(player.getLevel() + 1);
                System.out.println("You've leveled up. You are now level " + player.getLevel() + ". Your stats have increased by 2 and you received 1 skill point..");
                player.setExperience(player.getExperience() - ((player.getLevel() - 1) * 5 + 10));
                player.setMaxHp(player.getMaxHp() + 2);
                player.setHp(player.getHp() + 3);
                if (player.getHp() > player.getMaxHp()) {
                    player.setHp(player.getMaxHp());
                }
                player.setAttackPower(player.getAttackPower() + 2);
            }
            System.out.println("What should your next move be?");
            System.out.println("     1. Rest and heal.");
            System.out.println("     2. Sharpen your blade.");
            if (player.getSkillPoints() > 0) {
                System.out.println("     3. Spend skill points");
            }
            int afterBattleChoice = reader.nextInt();
            reader.nextLine();
            int randomHeal = (int) (Math.random() * 6 - 1 + 1);
            if (afterBattleChoice == 1) {
                player.setHp(player.getHp() + 3 + randomHeal);
                System.out.println("You decide to rest and heal " + (randomHeal+3) + " health.");
                if (player.getHp() > player.getMaxHp()) {
                    player.setHp(player.getMaxHp());
                }
            } else if (afterBattleChoice == 2) {
                player.setAttackPower(player.getAttackPower() + 2);
                System.out.println("You decide to sharpen your blade and gain 2 attack power. " +
                        "You now have " + player.getAttackPower() + " attack power.");
            } else if (afterBattleChoice == 3) {
                for (int i = player.getSkillPoints(); i > 0; i--) {
                    System.out.println("Choose what stat to improve with your skill point.");
                    System.out.println("1. +4 att.");
                    System.out.println("2. +1 armour.");
                    System.out.println("3. +6 max hp.");
                    int statChoice = reader.nextInt();
                    if (statChoice == 1) {
                        player.setAttackPower(player.getAttackPower() + 4);
                    } else if (statChoice == 2) {
                        player.setArmour(player.getArmour() + 1);
                    } else if (statChoice == 3) {
                        player.setMaxHp(player.getMaxHp() + 6);
                    }
                }
                player.setSkillPoints(0);
            }
            System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
            System.out.println();
        }
        if (player.getHp() <= 0) {
            System.out.println("You were defeated by: " + enemy.getName() + ".");
        }
    }

    public static void traversingWorld(PlayerCharacter player) {
            System.out.println("Level " + player.getLevel()
                    + " | Life points: " + player.getHp() + "/" + player.getMaxHp()
                    + " | Attack power: " + player.getAttackPower()
                    + " | Armour: " + player.getArmour());

            System.out.println("----------------------------------------");
            int random = (int) (Math.random() * 3 - 1 + 1);
            if (random == 0) {
                NPC rat = new NPC(15, 4, "rat", 0, 1, 0, 15, 0);
                System.out.println("You ran into a rat!");
                System.out.println("Enemy life points: " + rat.getHp() + " | Attack power: " + rat.getAttackPower());
                System.out.println("----------------------------------------");
                battlePhase(player, rat);
                displayBattleResults(player, rat);
            } else if (random == 1) {
                NPC thug = new NPC(25, 6, "Thug", 0, 3, 1, 25, 0);
                System.out.println("You ran into a lowly thug!");
                System.out.println("Enemy life points: " + thug.getHp() + " | Attack power: " + thug.getAttackPower());
                System.out.println("----------------------------------------");
                battlePhase(player, thug);
                displayBattleResults(player, thug);
            } else if (random == 2) {
                NPC assassin = new NPC(30, 8, "Assassin", 0, 5, 2, 30, 0);
                System.out.println("You ran into a trained assassin!");
                System.out.println("Enemy life points: " + assassin.getHp() + " | Attack power: " + assassin.getAttackPower());
                System.out.println("----------------------------------------");
                battlePhase(player, assassin);
                displayBattleResults(player, assassin);
            }

    }
}
