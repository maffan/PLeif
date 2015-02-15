package Models;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player extends Entity
{
    private Stats stats;
    private Equippable armor;
    private Equippable weapon;
    private Equippable medallion;
    private LinkedList<Item> items;
    
    public Player(String name, Stats stats, int x, int y)
    {
        super(x, y, SpriteID.Player, name);
        this.stats = stats;
        items = new LinkedList<Item>();
    }
    
	private List<Entity> entities;
	
	public Player(String playerName)
	{	
		super(5, 5, SpriteID.Player, playerName); // Need to be changed to variable starting point? MJ
		entities = new ArrayList<Entity>();
	}
    
	public void addItem(Entity e)
	{
		entities.add(e);
	}
    
	public void removeItem(Entity e)
	{
		entities.remove(e);
	}
	
	public List<Entity> getEntities()
	{
		return entities;
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
