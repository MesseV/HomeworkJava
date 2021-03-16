package GameRPG;

public class Main {
    public static void main(String[] args) {
        PlayerCharacter jucator = new PlayerCharacter(100, 15, "Hero");

        System.out.println("Your life points: " + jucator.getHp() + "| Attack power:" + jucator.getAttackPower());
        System.out.println("----------------------------------------");
        int score = 0;
        while (jucator.getHp() > 0) {
            int random = (int) (Math.random() * 3 - 1 + 1);
            if (random == 0) {
                NPC rat = new NPC(20, 2, "rat");
                System.out.println("You ran into a rat!");
                System.out.println("Enemy life points: " + rat.getHp() + " | Attack power: " + rat.getAttackPower());
                System.out.println("----------------------------------------");
                battlePhase(jucator, rat);
                displayBattleResults(jucator, rat);
            } else if (random == 1) {
                NPC thug = new NPC(25, 4, "Thug");
                System.out.println("You ran into a lowly thug!");
                System.out.println("Enemy life points: " + thug.getHp() + " | Attack power: " + thug.getAttackPower());
                System.out.println("----------------------------------------");
                battlePhase(jucator, thug);
                displayBattleResults(jucator, thug);
            } else if (random == 2) {
                NPC assassin = new NPC(35, 6, "Assassin");
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


    public static int playerAttacks(PlayerCharacter jucator) {
        int randomAttack = (int) (Math.random() * (jucator.getAttackPower() + 1) - 1 + 1);
        System.out.println("You attack the enemy and deal " + randomAttack + " damage.");
        return randomAttack;
    }

    public static int enemyAttacks(NPC enemy) {
        int enemyRandomAttack = (int) (Math.random() * (enemy.getAttackPower() + 1) - 1 + 1);
        System.out.println("The enemy attacks you and deals " + enemyRandomAttack + " damage.");
        return enemyRandomAttack;
    }

    public static void battlePhase(PlayerCharacter jucator, NPC enemy) {

    while(jucator.getHp()>0 && enemy.getHp()>0)
    {
        if (jucator.getHp() > 0) {
            int playerAttack = playerAttacks(jucator);
            enemy.setHp(enemy.getHp() - playerAttack);
            System.out.println("Enemy life points: " + enemy.getHp());
            System.out.println("----------------------------------------");
        }
        if (enemy.getHp() > 0) {
            int enemyAttack = enemyAttacks(enemy);
            jucator.setHp(jucator.getHp() - enemyAttack);
            System.out.println("Your life points: " + jucator.getHp());
            System.out.println("----------------------------------------");
        }
    }
    if(enemy.getHp()<=0) {
        System.out.println("You defeated the " + enemy.getName() + ".");
        System.out.println();
        System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
    }
}

    public static void displayBattleResults (PlayerCharacter jucator, NPC enemy) {
    if (jucator.getHp() > 0) {
        System.out.println("After the battle you assess your situation - Life points: " + jucator.getHp());
        int randomHeal = (int) (Math.random() * 6 - 1 + 1);
        jucator.setHp(jucator.getHp() + randomHeal);
        System.out.println("You decide to rest and heal " + randomHeal + " health points. You now have " + jucator.getHp() + " health points.");
        System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
        System.out.println();
    }
    if (jucator.getHp() <= 0) {
        System.out.println("You were defeated by: " + enemy.getName() + ".");
    }
}

}
