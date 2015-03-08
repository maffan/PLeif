package Models;

import Views.BoardPanel;
import Views.InfoPanel;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author joh
 * @version 2015-03-07
 */
public class Player extends Entity {
	private Stats stats;
	public Item armour;
	public Item weapon;
	private List<Item> items;
	
	private int health;
	private int xp;
	private int lvl;

	public Player(int x, int y, String name, Stats stats) {
		super(x, y, name, SpriteID.Player);
		this.stats = stats;
		items = new LinkedList<Item>();
		health = stats.getHealth();
		xp = 0; lvl = 1;
	}
	
	public SpriteID getSpriteID(){
		if(this.armour != null && this.weapon != null){
			return SpriteID.PlayerArmourSword;
		}
		else if(this.weapon != null){
			return SpriteID.PlayerSword;
		}
		else if(this.armour != null){
			return SpriteID.PlayerArmour;
		}
		return SpriteID.Player;	
	}

	private void addItem(Item e) {
		items.add(e);
		setChanged();
		notifyObservers();
	}
	
	public Stats getStats()
	{
		addObserver(InfoPanel.getStatsInfoPanelInstance());
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
					health += armour.getStats().getHealth();
					setChanged();
					notifyObservers();
				}
				return "Nu e jag stark!";
			}
		}
	}
	
	public String unequip(String string) {
		if(string.equals("armour"))
		{
			addItem(armour);
			health -= armour.getStats().getHealth();
			armour = null;
			return "Brr, kallt.";
		}
		if(string.equals("weapon"))
		{
			addItem(weapon);
			weapon = null;
			return "Nu e jag klen..";
		}
		
		return "Nu skrev du fel va?";
	}
	
	public String getHealth()
	{
		return Integer.toString(health);
	}

	public List<Item> getItems() {
		return items;
	}
	
	public void levelUp()
	{
		xp++;
		int lvlMeter =xp/2+1;
		
		if(lvl != lvlMeter)
		{
			int currHealth = stats.getHealth();
			if(lvlMeter == 2)
			{
				stats = MobStats.getPlayerLVL2();
				stats.setHealth(currHealth);
				lvl = 2;
			}
			else if(lvlMeter == 3)
			{
				stats = MobStats.getPlayerLVL3();
				stats.setHealth(currHealth);
				lvl = 3;
			}
			else if(lvlMeter == 4)
			{
				stats = MobStats.getPlayerLVL4();
				stats.setHealth(currHealth);
				lvl = 4;
			}
		}
		setChanged();
		notifyObservers();
	}
	
	public String getLevel()
	{
		return Integer.toString(lvl);
	}

	public void minorHeal() {
		Random rng = new Random();
		int health = stats.getHealth()+rng.nextInt(2);
		if(health <= MobStats.getPlayerLVL1().getHealth())
		{
			stats.setHealth(health);
		}
	}
	
	private int getDamage()
	{
		return getStats().getDamage() + (weapon == null ? 0 : weapon.getStats().getDamage());
	}
	
	private double getLuck()
	{
		return getStats().getLuck() + (weapon == null ? 0 : weapon.getStats().getLuck());
	}
	
	private int getEndurance()
	{
		return getStats().getEndurance() + (armour == null ? 0 : armour.getStats().getHealth());
	}
	
	public int doAttack(Enemy e, boolean isAttacking)
	{
		int damage = isAttacking ? getDamage() : e.getStats().getDamage();
		
		if(isAttacking)
			e.getStats().setHealth(e.getStats().getHealth()-getDamage());
		else
		{
			double random = new Random().nextDouble();
		    
		    if(random < getLuck()){
		    	damage -= getEndurance()*random;
		    }
		    health -= damage;
			setChanged();
			notifyObservers();
		}
		return damage;
	}
}