package Utils;

import java.awt.image.BufferedImage;

import Models.SpriteID;

public class Images
{
	//Aes
	public BufferedImage tree;
	public BufferedImage stone;
	public BufferedImage water;
	
	//Item
	public BufferedImage armour;
	public BufferedImage sword;
	
	//Div
	public BufferedImage player;
	public BufferedImage enemy;
	public BufferedImage bg;

	
	/**
	 * Loads all images to be used.
	 */
	public Images()
	{
		//Aes
		tree = ImageLoader.LoadImage(SpriteID.Tree);
		stone = ImageLoader.LoadImage(SpriteID.Stone);
		water = ImageLoader.LoadImage(SpriteID.Water);
		
		//Items
		armour = ImageLoader.LoadImage(SpriteID.Armour);
		sword = ImageLoader.LoadImage(SpriteID.Sword);
		
		//Div
		player = ImageLoader.LoadImage(SpriteID.Player);
		enemy = ImageLoader.LoadImage(SpriteID.Enemy);
		bg = ImageLoader.LoadImage(SpriteID.Bg);
		
	}
}