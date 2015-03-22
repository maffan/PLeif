package Models;

/**
 * Applied to entities in the code to identify if they have collision 
 * @author joh
 * @version 2015-02-25
 */
public class Aesthetics extends Entity
{
	private boolean hasCollision;
	
	/**
	 * Constructor
	 * @param x value
	 * @param y value
	 * @param id SpriteID of Aes.
	 * @param hasCollision if Aes. has collision
	 * @param name of Aes.
	 */
	public Aesthetics(int x, int y, SpriteID id, boolean hasCollision, String name) {
		super(x, y, name, id);
		this.hasCollision = hasCollision;
	}
	
	/**
	 * @return if object has collision.
	 */
	public boolean hasCollision()
	{
		return hasCollision;
	}
}