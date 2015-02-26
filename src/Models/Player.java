package Models;

import Views.BoardPanel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player extends Entity {
	private Stats stats;
	private Equippable armor;
	private Equippable weapon;
	private Equippable medallion;
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
	
	public Stats getStats()
	{
		return stats;
	}

	public void move(String direction, int max)
	{
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

	public void removeItem(Item e) {
		items.remove(e);
	}

	public List<Item> getItems() {
		return items;
	}

	public void pickUpItem(Item item) {
		items.add(item);
	}

	public void dropItem(Item item) {
		items.remove(item);
	}

	public void equip(Equippable item) {

	}

	public void unEquip(Equippable item) {

	}

	public String getType() {
		return "Player";
	}

	public void doTurn() {

	}
}
