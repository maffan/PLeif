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
	
	private boolean isAlive;
	private int health;
	private int xp;
	private int lvl;

	/**
	 * @param x value
	 * @param y value
	 * @param name playername
	 * @param stats player stats
	 */
	public Player(int x, int y, String name, Stats stats) {
		super(x, y, name, SpriteID.Player);
		this.stats = stats;
		items = new LinkedList<Item>();
		isAlive = true;
		health = stats.getHealth();
		xp = 0; lvl = 1;
	}
	
	/**
	 * @return Players current sprite, based on equipped objects
	 */
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

	/**
	 * adds adds an object and notifies the observers
	 * @param e item object
	 */
	private void addItem(Item e) {
		items.add(e);
		setChanged();
		notifyObservers();
	}
	
	/**
	 * @return stats for player
	 */
	public Stats getStats()
	{
		addObserver(InfoPanel.getStatsInfoPanelInstance());
		return stats;
	}

	/**
	 * moves the player across the map
	 * @param direction 
	 * @param max is to make sure you don't step outside of the map
	 */
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
	
	/**
	 * Checks if item exists in cell. If it does returns item. 
	 * @return true or false. 
	 */
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
	
	/**
	 * Equips an item using its placement in the list.
	 * @param id value
	 * @return string with information on wether or not the equip was successful
	 */
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
	
	/**
	 * Method used to unequip items from the player. Returns them to the inventory
	 * @param string
	 * @return string different response for success or failure
	 */
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
	
	/**
	 * @return health
	 */
	public int getHealth()
	{
		return health;
	}

	/**
	 * @return items list
	 */
	public List<Item> getItems() {
		return items;
	}
	
	/**
	 * Increases player stats after defeating monsters.
	 * notifies observers of changes. 
	 * 
	 */
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
	
	/**
	 * @return string of lvl
	 */
	public String getLevel()
	{
		return Integer.toString(lvl);
	}

	/**
	 * Method that heals the Player when moving around the map
	 * 
	 */
	public void minorHeal() {
		Random rng = new Random();
		int heal = getHealth() + rng.nextInt(2);
		if(health <= getHealthMax())
		{
			this.health = heal;
		}
	}
	
	/**
	 * 
	 * @return total damage stats
	 */
	private int getDamage()
	{
		return getStats().getDamage() + (weapon == null ? 0 : weapon.getStats().getDamage());
	}
	
	/**
	 * @return total luck stats
	 */
	private double getLuck()
	{
		return getStats().getLuck() + (weapon == null ? 0 : weapon.getStats().getLuck());
	}
	
	/**
	 * @return total endurance stats
	 */
	private int getEndurance()
	{
		return getStats().getEndurance() + (armour == null ? 0 : armour.getStats().getEndurance());
	}
	
	/**
	 * @return total max health
	 */
	private int getHealthMax()
	{
		return getStats().getHealth() + (armour == null ? 0 : armour.getStats().getHealth());
	}
	
	/**
	 * Method used to attack monsters 
	 * 
	 * @param e enemy object
	 * @param isAttacking
	 * @return damage returns damage done by player or enemy, depending on turn.
	 */
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
		    if(health <= 0)
		    	isAlive = false;
			setChanged();
			notifyObservers();
		}
		return damage;
	}
	
	/**
	 * @return true / false
	 */
	public boolean isAlive()
	{
		return isAlive;
	}
	
	/**
	 * Notifies observers
	 */
	public void iveChanged()
	{
		setChanged();
		notifyObservers();
	}
}