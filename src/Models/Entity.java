package Models;

import java.awt.*;
import java.util.Observable;

public class Entity extends Observable
{
	private Point p;
	private SpriteID id;
	
	public Entity()
	{
		
	}
	
	public Entity(int x, int y)
	{
		this.p = new Point(x,y);
	}
	
	public Entity(int x, int y, SpriteID id)
	{
		this.p = new Point(x,y);
		this.id = id;
	}
	
	public Entity(SpriteID id)
	{
		this.p = new Point(0,0);
		this.id = id;
	}
	
	public SpriteID getSpriteID()
	{
		return id;
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