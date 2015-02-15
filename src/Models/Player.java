package Models;

import Models.Item;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player extends Entity
{
    private Stats stats;
    private Equippable armor;
    private Equippable weapon;
    private Equippable medallion;
    private List<Item> items;
    
    public Player(String name, Stats stats, int x, int y)
    {
        super(x, y, SpriteID.Player, name);
        this.stats = stats;
        items = new LinkedList<Item>();
    }
	
	public Player(String playerName)
	{	
		super(5, 5, SpriteID.Player, playerName); // Need to be changed to variable starting point? MJ
		items = new ArrayList<Item>();
	}
    
	public void addItem(Item e)
	{
		items.add(e);
        setChanged();
        notifyObservers();
	}
    
	public void removeItem(Item e)
	{
		items.remove(e);
	}
	
	public List<Item> getItems()
	{
		return items;
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
