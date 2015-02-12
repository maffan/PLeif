package Models;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player extends Entity {
    private String name;
    private Stats stats;
    private Equippable armor;
    private Equippable weapon;
    private Equippable medallion;
    private LinkedList<Item> items;
    
    public Player(String name, Stats stats, int x, int y) {
        super(x, y);
        this.name = name;
        this.stats = stats;
        items = new LinkedList<Item>();
    }
    
    //------- Added code \/
	private List<Entity> entities;
	private String playerName;
	
	public Player(String playerName)
	{	
		super(5, 5, SpriteID.Player); // Need to be changed to variable starting point.
		entities = new ArrayList<Entity>();
		this.playerName = playerName;
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
	//------- Added code /\
	public String getPlayerName()
	{
		return playerName;
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
