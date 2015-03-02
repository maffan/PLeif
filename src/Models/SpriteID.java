package Models;

/**
 * Enum class to use to check if entities are of a certain type.
 * @author joh
 * @version 2015-02-25
 */
public enum SpriteID
{
	Path, Wall, Enemy, Player, Test, Sword, Shield, None, Tree, Bg, Armour, Water, WaterRightLeft, WaterUpDown,	 WaterTurnLeft, WaterEndRight, WaterEndLeft, Stone;
	
	/**
	 * Compares a string to enums and return
	 * the SpriteID enum for it if it exists.
	 * @param id The enum to check for
	 * @return The enum if it exists, otherwise None
	 */
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