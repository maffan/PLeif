package Models;

import java.awt.Point;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Utils.MapFileReader;

public class WorldData implements Serializable
{
	public Player player;
	public List<Entity> entities;
	private HashMap<Point, String> mapDescriptions;
	
	public WorldData()
	{
		entities = new ArrayList<Entity>();
		mapDescriptions = new HashMap<Point, String>();
		
        MapFileReader fileReader = new MapFileReader(new File("PLeif/Data/testMap.xml"));
        fileReader.getCells().forEach((cell) -> {
        	mapDescriptions.put(cell.getPoint(), cell.getDescription());
        });
	}
	
	public String getDescription(Point p)
	{
		return mapDescriptions.get(p);
	}
	
	public boolean hasCollision(int x, int y)
	{
		for(Entity e : entities)
		{
			if(e instanceof Aesthetics && ((Aesthetics) e).hasCollision())
			{
				if(e.getX() == x && e.getY() == y)
				{
					return true;
				}
			}
		}
		return false;
	}
}