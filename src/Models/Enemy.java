package Models;

public class Enemy extends Entity
{
	private Stats stats;
	
	public Enemy(int x, int y, String name, Stats stats) {
		super(x, y, name, SpriteID.Enemy);
		this.stats = stats;
	}
	
	//doTurn() random move and stuff?
}