package GameRPG;

public class Character {

    private String name;
    private int hp;
    private int attackPower;

    public Character(int hp, int attackPower, String name) {
        this.hp = hp;
        this.attackPower = attackPower;
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
