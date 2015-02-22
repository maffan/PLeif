package Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Utils.FilesRW;
import Utils.MapFileReader;

public class WorldData implements Serializable
{
	public Player player;
	public List<Entity> entities;
//	public MapFileReader mapFile;
	
	public WorldData()
	{
		entities = new ArrayList<Entity>();
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