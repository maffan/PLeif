package Models;

public class Enemy extends Aesthetics
{
	private Stats stats;
	
	public Enemy(int x, int y,SpriteID id, String name, Stats stats) {
		super(x, y, id, true, name);
		this.stats = stats;
	}

    public Stats getStats() {
        return stats;
    }
}