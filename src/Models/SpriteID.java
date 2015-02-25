package Models;

public enum SpriteID
{
	Path, Wall, Enemy, Player, Test, Sword, Shield, None, Tree, Bg, Armour;
	
	public static SpriteID stringToID(String id)
	{
		for(SpriteID sid: SpriteID.values())
		{
			if(sid.toString().toLowerCase().equals(id))
			{
				return sid;
			}
		}
		return None;
	}
}