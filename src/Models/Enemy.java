package Models;

public class Enemy extends Aesthetics
{
	private Stats stats;
	
	public Enemy(int x, int y, String name, Stats stats) {
		super(x, y,SpriteID.Enemy,true, name);
		this.stats = stats;
	}
	
	//doTurn() random move and stuff?
}