package Models;

import java.awt.Point;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Utils.MapFileReader;

/**
 * Stores all map data and player information.
 * @author joh
 * @version 2015-02-26
 */
public class WorldData implements Serializable
{
	public Player player;
	public List<Entity> entities;
	private HashMap<Point, String> mapDescriptions;
	public List<Enemy> enemies;
	public List<Item> items;
	public List<Aesthetics> aes;
	
	/**
	 * Reads map file using MapFileReader and stores it.
	 * @param mapPath Path to map file.
	 */
	public WorldData(String mapPath)
	{
		entities = new ArrayList<Entity>();
		mapDescriptions = new HashMap<Point, String>();
		
        MapFileReader fileReader = new MapFileReader(new File(mapPath));

        mapDescriptions = fileReader.getDescriptions();
        player = fileReader.getPlayer();
        enemies = fileReader.getListOfEnemies();
        items = fileReader.getListOfItems();
        aes = fileReader.getListOfAestethics();
	}
	
	/**
	 * Get a map description from point p
	 * @param p Point to get description from
	 * @return Description
	 */
	public String getDescription(Point p)
	{
		return mapDescriptions.get(p);
	}
	
	/**
	 * Checks if position can be moved to.
	 * @param x
	 * @param y
	 * @return true or false
	 */
	public boolean hasCollision(int x, int y)
	{
		for(Entity e : aes)
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