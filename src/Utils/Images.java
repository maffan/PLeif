package Utils;

import java.awt.image.BufferedImage;

import Models.SpriteID;

/**
 * Loads and stores all images we used in the game.
 * @author joh
 * @version 2015-02-25
 */
public class Images
{
	//Aes
	public BufferedImage tree;
	public BufferedImage stone;
	public BufferedImage water;
	public BufferedImage waterRightLeft;
	public BufferedImage waterUpDown;
	public BufferedImage waterTurnLeft;
	public BufferedImage waterEndRight;
	public BufferedImage waterEndLeft;
	
	
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
		waterRightLeft = ImageLoader.LoadImage(SpriteID.WaterRightLeft);
		waterUpDown = ImageLoader.LoadImage(SpriteID.WaterUpDown);
		waterTurnLeft = ImageLoader.LoadImage(SpriteID.WaterUpDown);
		waterEndRight = ImageLoader.LoadImage(SpriteID.WaterEndRight);
		waterEndLeft = ImageLoader.LoadImage(SpriteID.WaterEndLeft);
		
		
		
		//Items
		armour = ImageLoader.LoadImage(SpriteID.Armour);
		sword = ImageLoader.LoadImage(SpriteID.Sword);
		
		//Div
		player = ImageLoader.LoadImage(SpriteID.Player);
		enemy = ImageLoader.LoadImage(SpriteID.Enemy);
		bg = ImageLoader.LoadImage(SpriteID.Bg);
	}
}