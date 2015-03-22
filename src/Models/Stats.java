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
    
    
    /**
     * Stats constructor for things with no values 
     */
    public Stats()
    {
    	health = 0; endurance = 0; damage = 0; luck = 0; space = 0;
    }

    /**
     * contructor for setting stats
     * @param health
     * @param endurance
     * @param damage
     * @param luck
     * @param space
     */
    public Stats(int health, int endurance, int damage, double luck, int space) {
        this.health = health;
        this.endurance = endurance;
        this.damage = damage;
        this.luck = luck;
        this.space = space;
    }

    /**
     * @return health value
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets health, notifies observers
     * @param health value
     */
    public void setHealth(int health) {
        this.health = health;
        setChanged();
        notifyObservers();
    }

    /**
     * 
     * @return endurance value
     */
    public int getEndurance() {
        return endurance;
    }

    /**
     * Sets endurance, notifies observers
     * @param endurance value
     */
    public void setEndurance(int endurance) {
        this.endurance = endurance;
        setChanged();
        notifyObservers();
    }

    /**
     * @return damage value
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Sets damage, notifies observers
     * @param damage value
     */
    public void setDamage(int damage) {
        this.damage = damage;
        setChanged();
        notifyObservers();
    }

    /**
     * @return luck value
     */
    public double getLuck() {
        return luck;
    }

    /**
     * sets luck, notifies observers
     * @param luck value
     */
    public void setLuck(double luck) {
        this.luck = luck;
        setChanged();
        notifyObservers();
    }

    /**
     * @return space value
     */
    public int getWeight() {
        return space;
    }

    /**
     * sets weight, notifies observer
     * @param weight
     */
    public void setWeight(int weight) {
        this.space = weight;
        setChanged();
        notifyObservers();
    }
}
