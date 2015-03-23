package Models;

/**
 * Specific variables for items
 * Created by Marcus on 2/3/2015.
 *
 */

public class Item extends Entity {
	private Stats stats;

	/**
	 * empty constructor 
	 */
	public Item(){

	}

	/**
	 * @param x value
	 * @param y value
	 * @param name unique name for item
	 * @param stats 
	 * @param id SpriteID of item
	 */
	public Item(int x, int y, String name, Stats stats, SpriteID id){
		super(x, y, name, id);
		this.stats = stats;
	}

	/**
	 * @return stats for the item.
	 */
	public Stats getStats(){
		return stats;
	}
}
