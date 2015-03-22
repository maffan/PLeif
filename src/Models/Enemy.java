package Models;

/**
 * Specific variables for enemies.
 * @author joh
 * @version 2015-03-03
 */
public class Enemy extends Aesthetics
{
	private Stats stats;
	
	/**
	 * @param x value
	 * @param y value
	 * @param id SpriteID of Enemy
	 * @param name
	 * @param stats
	 */
	public Enemy(int x, int y,SpriteID id, String name, Stats stats) {
		super(x, y, id, true, name);
		this.stats = stats;
	}

    /**
     * @return stats for enemy
     */
    public Stats getStats() {
        return stats;
    }
}