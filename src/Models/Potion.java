package Models;

/**
 * Created by Marcus on 2/3/2015.
 */
public abstract class Potion implements Usable {
    private Stats stats;
    public Potion(Stats stats) {
        this.stats = stats;
    }
}
