package Models;

import java.awt.*;
import java.io.Serializable;
import java.util.Observable;

/**
 * @author joh
 * @version 2015-03-08
 */
public class Entity extends Observable implements Serializable
{
	private Point p;
	private SpriteID id;
	private String name;
	
	/**
	 * Empty constructor
	 */
	public Entity()
	{
		
	}
	
	/**
	 * @param x value
	 * @param y value
	 * @param name of Entity
	 * @param id SpriteID of Entity
	 */
	public Entity(int x, int y, String name, SpriteID id)
	{
		this.p = new Point(x,y);
		this.id = id;
		this.name = name;
	}
	
	/**
	 * @return SpriteID of Entity
	 */
	public SpriteID getSpriteID()
	{
		return id;
	}
	
	/**
	 * @return name of Entity
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * @return x-value of Entity
	 */
	public int getX()
	{
		return p.x;
	}
	
	/**
	 * @return y-value of Entity
	 */
	public int getY()
	{
		return p.y;
	}
	
	/**
	 * @param x value to set for Entity
	 */
	public void setX(int x)
	{
		p.x = x;
        setChanged();
        notifyObservers();
	}
	
	/**
	 * @param y value to set for Entity
	 */
	public void setY(int y)
	{
		p.y = y;
        setChanged();
        notifyObservers();
	}
}