package Models;

import Views.BoardPanel;

import java.util.LinkedList;
import java.util.List;

public class Player extends Entity {
	private Stats stats;
	public Item armour;
	public Item weapon;
	private Item medallion;
	private List<Item> items;

	public Player(int x, int y, String name, Stats stats) {
		super(x, y, name, SpriteID.Player);
		this.stats = stats;
		items = new LinkedList<Item>();
	}

	public void addItem(Item e) {
		items.add(e);
		setChanged();
		notifyObservers();
	}
	
	public void removeItem(Item e) {
		items.remove(e);
		setChanged();
		notifyObservers();
	}
	
	public Stats getStats()
	{
		return stats;
	}

	public void move(String direction, int max)
	{
		max--;
		if (direction.equals("north") || direction.equals("n"))
		{
			if(!BoardPanel.world.hasCollision(getX(), getY()-1))
			{
				setY(Math.max(0, BoardPanel.world.player.getY() - 1));
			}
		}
		else if (direction.equals("east") || direction.equals("e")) {
			if(!BoardPanel.world.hasCollision(getX()+1, getY()))
			{
				setX(Math.min(max, BoardPanel.world.player.getX() + 1));
			}
		}
		else if (direction.equals("south") || direction.equals("s")) {
			if(!BoardPanel.world.hasCollision(getX(), getY()+1))
			{
				setY(Math.min(max, BoardPanel.world.player.getY() + 1));
			}
		}
		else if (direction.equals("west") || direction.equals("w")) {
			if(!BoardPanel.world.hasCollision(getX()-1, getY()))
			{
				setX(Math.max(0, BoardPanel.world.player.getX() - 1));
			}
		}
		else
		{
			System.out.println("move(): Invalid command");
		}
	}

	public List<Item> getItems() {
		return items;
	}

	public boolean pickUpItem() {
		boolean itemExists = false;
		for(int i = 0; i < BoardPanel.world.items.size(); i++)
		{
			if(BoardPanel.world.items.get(i).getX() == getX() &&BoardPanel.world.items.get(i).getY() == getY())
			{
				itemExists = true;
				addItem(BoardPanel.world.items.remove(i));
			}
		}
		return itemExists;
	}

	public void dropItem(Item item) {
		items.remove(item);
	}

	public String equip(String id) {
		if(!id.matches("\\d+"))
		{
			return "En siffra tack.";
		}
		else
		{
			int index = Integer.valueOf(id) - 1;
			if(index >= items.size())
			{
				return "En annan siffra tack.";
			}
			else
			{
				if(items.get(index).getSpriteID() == SpriteID.Sword)
				{
					if(weapon != null)
						return "Har redan ett vapen i hand.";
					weapon = items.remove(index);
					setChanged();
					notifyObservers();
				}
				else if(items.get(index).getSpriteID() == SpriteID.Armour)
				{
					if(armour != null)
						return "Har redan skydd";
					armour = items.remove(index);
					setChanged();
					notifyObservers();
				}
				return "Nu e jag stark!";
			}
		}
	}

	public void unEquip(Item item) {

	}

	public String getType() {
		return "Player";
	}

	public void doTurn() {

	}
}
