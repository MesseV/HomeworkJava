package GameRPG;

public class Character {

    private String name;
    private int hp;
    private int attackPower;
    private int experience;
    private int level;
    private int armour;

    public Character(int hp, int attackPower, String name, int experience, int level, int armour) {
        this.hp = hp;
        this.attackPower = attackPower;
        this.name = name;
        this.experience = experience;
        this.level = level;
        this.armour = armour;
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }
}
