package Models;

import java.io.Serializable;
import java.util.Observable;

/**
 * Created by Marcus on 2/3/2015.
 */
 
 //Testar kommentarer
    //En kommentar till
public class Stats extends Observable implements Serializable
{
    private int health;
    private int endurance;
    private int damage;
    private double luck;
    private int space;
    
    public Stats()
    {
    	health = 0; endurance = 0; damage = 0; luck = 0; space = 0;
    }

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
        setChanged();
        notifyObservers();
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
        setChanged();
        notifyObservers();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
        setChanged();
        notifyObservers();
    }

    public double getLuck() {
        return luck;
    }

    public void setLuck(double luck) {
        this.luck = luck;
        setChanged();
        notifyObservers();
    }

    public int getWeight() {
        return space;
    }

    public void setWeight(int weight) {
        this.space = weight;
        setChanged();
        notifyObservers();
    }
}
