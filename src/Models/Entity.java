package Models;

import java.awt.*;
import java.io.Serializable;
import java.util.Observable;

public class Entity extends Observable implements Serializable
{
	private Point p;
	private SpriteID id;
	private String name;
	
	public Entity()
	{
		
	}
	
	public Entity(int x, int y, SpriteID id, String name)
	{
		this.p = new Point(x,y);
		this.id = id;
		this.name = name;
	}
	
	public SpriteID getSpriteID()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getX()
	{
		return p.x;
	}
	
	public int getY()
	{
		return p.y;
	}
	
	public void setX(int x)
	{
		p.x = x;
        setChanged();
        notifyObservers();
	}
	
	public void setY(int y)
	{
		p.y = y;
        setChanged();
        notifyObservers();
	}

    /**
     * Action for this Entity to perform during a Turn
     */
    //public abstract void doTurn();
}