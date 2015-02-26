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

    public Item(int x, int y, String name, Stats stats, SpriteID id){
        super(x, y, name, id);
        this.stats = stats;
    }

    public Stats getStats(){
        return stats;
    }
}
