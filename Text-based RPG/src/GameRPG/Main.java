package GameRPG;

import GameRPG.Characters.NPC;
import GameRPG.Characters.PlayerCharacter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PlayerCharacter jucator = new PlayerCharacter(40, 20, "Hero", 0, 1, 1, 40);


        int score = 0;
        while (jucator.getHp() > 0) {
            System.out.println("Level " + jucator.getLevel()
                    + "| Life points: " + jucator.getHp()
                    + "| Attack power:" + jucator.getAttackPower()
                    + "| Armour: " + jucator.getArmour());

            System.out.println("----------------------------------------");
            int random = (int) (Math.random() * 3 - 1 + 1);
            if (random == 0) {
                NPC rat = new NPC(15, 4, "rat", 0, 1, 0);
                System.out.println("You ran into a rat!");
                System.out.println("Enemy life points: " + rat.getHp() + " | Attack power: " + rat.getAttackPower());
                System.out.println("----------------------------------------");
                battlePhase(jucator, rat);
                displayBattleResults(jucator, rat);
            } else if (random == 1) {
                NPC thug = new NPC(25, 6, "Thug", 0, 3, 1);
                System.out.println("You ran into a lowly thug!");
                System.out.println("Enemy life points: " + thug.getHp() + " | Attack power: " + thug.getAttackPower());
                System.out.println("----------------------------------------");
                battlePhase(jucator, thug);
                displayBattleResults(jucator, thug);
            } else if (random == 2) {
                NPC assassin = new NPC(30, 8, "Assassin", 0, 5, 2);
                System.out.println("You ran into a trained assassin!");
                System.out.println("Enemy life points: " + assassin.getHp() + " | Attack power: " + assassin.getAttackPower());
                System.out.println("----------------------------------------");
                battlePhase(jucator, assassin);
                displayBattleResults(jucator, assassin);
            }

        score++;
        }
        System.out.println();
        System.out.println("Game over!");
        System.out.println("Congratulations, you defeated " + score + " enemies.");


    }




    public static void battlePhase(PlayerCharacter jucator, NPC enemy) {
    Scanner reader=  new Scanner(System.in);
    while(jucator.getHp()>0 && enemy.getHp()>0)
    {
        System.out.println("1. Aggressive stance.  2. Defensive stance.  3.Balanced stance.");
        int alegereJucator = reader.nextInt();
        if (jucator.getHp() > 0) {
            int playerAttack = (int) (Math.random() * (jucator.getAttackPower() + 1) - 1 + 1);
            if (alegereJucator == 3) {
                System.out.println("You strike with a penalty to attack of 2 and no penalty to armour.");
                if (playerAttack-2 >= 0) {
                    System.out.println("You deal " + (playerAttack - 2) + " damage.");
                } else {
                    System.out.println("You deal 0 damage.");
                }
                enemy.setHp(enemy.getHp() - (playerAttack - 2));
            } else if (alegereJucator == 1) {
                System.out.println("You lash out with a bonus to attack of 8 and a penalty to armour of 3.");
                System.out.println("You deal " + (playerAttack+8) + " damage.");
                enemy.setHp(enemy.getHp() - (playerAttack + 8));
            } else if (alegereJucator == 2) {
                System.out.println("You defend with a penalty to attack of 8 and a bonus to armour of 3.");
                if (playerAttack-8 >= 0) {
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
            if (alegereJucator == 3) {
                jucator.setHp(jucator.getHp() - (enemyAttack - jucator.getArmour()));
                System.out.println("The enemy attacks you and deals " + enemyAttack + " damage. " +
                        "Your armour blocks " + jucator.getArmour() + " damage.");
            } else if (alegereJucator == 1) {
                jucator.setHp(jucator.getHp() - (enemyAttack + 3));
                System.out.println("The enemy attacks you and deals " + (enemyAttack+3) + " damage. " +
                        "Your armour blocks " + (jucator.getArmour()-1) + " damage.");
            } else if (alegereJucator == 2) {
                if (enemyAttack - (jucator.getArmour() + 2) > 0) {
                    jucator.setHp(jucator.getHp() - (enemyAttack - (jucator.getArmour() + 3)));
                }
                System.out.println("The enemy attacks you and deals " + enemyAttack + " damage. " +
                        "Your armour blocks " + (jucator.getArmour()+3) + " damage.");
            }
            System.out.println("Your life points: " + jucator.getHp());
            System.out.println("----------------------------------------");
        }
    }
    if(enemy.getHp()<=0) {
        System.out.println("You defeated the " + enemy.getName() + ".");
        if (enemy.getName().equals("rat")) {
            jucator.setExperience(jucator.getExperience() + 2);
            System.out.println("You received 2 experience points.");
        } else if (enemy.getName().equals("Thug")) {
            jucator.setExperience(jucator.getExperience() + 4);
            System.out.println("You received 4 experience points.");
        } else if (enemy.getName().equals("Assassin")) {
            jucator.setExperience(jucator.getExperience() + 6);
            System.out.println("You received 6 experience points.");
        }
        System.out.println();
        System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
    }
}

    public static void displayBattleResults (PlayerCharacter jucator, NPC enemy) {
    if (jucator.getHp() > 0) {
        Scanner reader = new Scanner(System.in);
        System.out.println("After the battle you assess your situation - Life points: " + jucator.getHp());
        System.out.println("You now have " + jucator.getExperience() + " experience points.");
        if (jucator.getExperience() >= (jucator.getLevel() * 5 + 10)) {
            jucator.setLevel(jucator.getLevel() + 1);
            System.out.println("You've leveled up. You are now level " + jucator.getLevel() + ". Your stats have increased by 2.");
            jucator.setExperience(0);
            jucator.setMaxHp(jucator.getMaxHp() + 2);
            jucator.setHp(jucator.getHp() + 3);
            if (jucator.getHp() > jucator.getMaxHp()) {
                jucator.setHp(jucator.getMaxHp());
            }
            jucator.setAttackPower(jucator.getAttackPower() + 2);
        }
        System.out.println("What should your next move be?");
        System.out.println("     1. Rest and heal.");
        System.out.println("     2. Sharpen your blade.");
        System.out.println("     3. Improve and repair your armour.");
        int alegereDupaBatalie = reader.nextInt();
        reader.nextLine();
        int randomHeal = (int) (Math.random() * 6 - 1 + 1);
        if (alegereDupaBatalie == 1) {
            jucator.setHp(jucator.getHp() + randomHeal);
            System.out.println("You decide to rest and heal " + randomHeal + " health.");
        } else if (alegereDupaBatalie == 2) {
            jucator.setAttackPower(jucator.getAttackPower() + 2);
            System.out.println("You decide to sharpen your blade and gain 2 attack power. " +
                    "You now have " + jucator.getAttackPower() + " attack power.");
        } else if (alegereDupaBatalie == 3) {
            jucator.setArmour(jucator.getArmour() + 1);
            System.out.println("You decide to improve your armour and gain 1 armour point.");
        }
        System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
        System.out.println();
    }
    if (jucator.getHp() <= 0) {
        System.out.println("You were defeated by: " + enemy.getName() + ".");
    }
}

}
