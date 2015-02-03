package Models;

import java.awt.*;

/**
 * Created by Marcus on 2/3/2015.
 */
public abstract class Item extends Entity {
    private Stats stats;

    public Item(){

    }

    public Item(Stats stats){
        this.stats = stats;
    }

    public Item(Stats stats, Point pos){
        super(pos);
        this.stats = stats;
    }

    public Stats getStats(){
        return stats;
    }
}
