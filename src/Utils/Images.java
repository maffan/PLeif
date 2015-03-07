package Utils;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import Models.SpriteID;

/**
 * Loads and stores all images we used in the game.
 * @author joh
 * @version 2015-02-25
 */
public class Images
{
	private HashMap<SpriteID, BufferedImage> images;
	
	/**
	 * Adds all images to a list
	 */
	public Images()
	{
		images = new HashMap<SpriteID, BufferedImage>();
		
		//Aes
		addToList(SpriteID.Tree);
		addToList(SpriteID.Stone);
		addToList(SpriteID.Water);
		addToList(SpriteID.WaterRightLeft);
		addToList(SpriteID.WaterUpDown);
		addToList(SpriteID.WaterTurnLeft);
		addToList(SpriteID.WaterEndRight);
		addToList(SpriteID.WaterEndLeft);
		addToList(SpriteID.WaterEndDown);
		
		//Items
		addToList(SpriteID.Armour);
		addToList(SpriteID.Sword);
		
		//Div
		addToList(SpriteID.Player);
		addToList(SpriteID.PlayerArmour);
		addToList(SpriteID.PlayerSword);
		addToList(SpriteID.PlayerArmourSword);
		addToList(SpriteID.Enemy);
		addToList(SpriteID.Boss);
		addToList(SpriteID.Bg);
	}
	
	/**
	 * Adds and loads all images into hashmap
	 * @param id SpriteID of the image.
	 */
	private void addToList(SpriteID id)
	{
		images.put(id, ImageLoader.LoadImage(id));
	}
	
	/**
	 * Returns image by SpriteID
	 * @param The sprite id to get.
	 * @return Image based on id.
	 */
	public BufferedImage getImage(SpriteID id)
	{
		return images.get(id);
	}
}