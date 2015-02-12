package Models;

public class Aesthetics extends Entity
{
	private boolean hasCollision;
	
	public Aesthetics(int x, int y, SpriteID id, boolean hasCollision) {
		super(x, y, id);
		this.hasCollision = hasCollision;
	}
	
	public boolean hasCollision()
	{
		return hasCollision;
	}
}