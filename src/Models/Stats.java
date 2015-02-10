package Models;

/**
 * Created by Marcus on 2/3/2015.
 */
public class Stats {
    private int health;
    private int endurance;
    private int damage;
    private double luck;
    private int space;

    public Stats(int health, int endurance, int damage, double luck, int space) {
        this.health = health;
        this.endurance = endurance;
        this.damage = damage;
        this.luck = luck;
        this.space = space;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getLuck() {
        return luck;
    }

    public void setLuck(double luck) {
        this.luck = luck;
    }

    public int getWeight() {
        return space;
    }

    public void setWeight(int weight) {
        this.space = weight;
    }
}
