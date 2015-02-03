package Models;

import java.awt.*;

/**
 * Created by Marcus on 2/3/2015.
 */
public abstract class Entity implements Drawable {
    private Point position;

    public Entity(){
    }

    public Entity(int xPos,int yPos){
        position = new Point(xPos,yPos);
    }

    public Entity(Point position){
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    /**
     * Action for this Entity to perform during a Turn
     */
    public abstract void doTurn();
}
