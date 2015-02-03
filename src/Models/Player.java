package Models;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Marcus on 2/3/2015.
 */
public class Player extends Entity {
    private String name;
    private Stats stats;
    private Equippable armor;
    private Equippable weapon;
    private Equippable medallion;
    private LinkedList<Item> items;

    public Player(){
        items = new LinkedList<Item>();
    }

    public Player(String name, Stats stats, Point pos) {
        super(pos);
        this.name = name;
        this.stats = stats;
        items = new LinkedList<Item>();
    }

    public void pickUpItem(Item item){
        items.add(item);
    }

    public void dropItem(Item item){
        items.remove(item);
    }

    public void equip(Equippable item){

    }

    public void unEquip(Equippable item){

    }

    public String getType() {
        return "Player";
    }

    public void doTurn() {

    }
}
