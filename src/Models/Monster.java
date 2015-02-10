package Models;

/**
 * Created by Marcus on 2/4/2015.
 */
public class Monster extends Entity {
    private Stats stats;

    public Monster(){

    }

    public Monster(Stats stats){
        this.stats = stats;
    }
    //@Override
    public void doTurn() {

    }

    //@Override
    public String getType() {
        return "Monster";
    }
}
