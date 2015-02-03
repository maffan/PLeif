package Models;

import java.awt.*;

/**
 * Created by Marcus on 2/3/2015.
 */
public interface Drawable {
    /**
     * Gets the position of the object
     * @return A Point representing the position of the object. Returns null if object doesn't have a position
     */
    public Point getPosition();

    /**
     * Gets the type of the object
     * @return A String representation of the object
     */
    public String getType();
}
