package Models;

/**
 * Created by Marcus on 2/3/2015.
 */
public class Item extends Entity {
    private Stats stats;

    public Item(){

    }

    public Item(Stats stats){
        this.stats = stats;
    }

    public Item(Stats stats, int x, int y, SpriteID id, String name){
        super(x, y, SpriteID.None, name);
        this.stats = stats;
    }

    public Stats getStats(){
        return stats;
    }
}
