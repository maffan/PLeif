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
	public BufferedImage waterEndDown;
	
	
	//Item
	public BufferedImage armour;
	public BufferedImage sword;
	
	//Div
	public BufferedImage player;
	public BufferedImage enemy;
	public BufferedImage bg;
	public BufferedImage boss;
	public BufferedImage playerArmour;
	public BufferedImage playerSword;
	public BufferedImage playerArmourSword;
	
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
		waterTurnLeft = ImageLoader.LoadImage(SpriteID.WaterTurnLeft);
		waterEndRight = ImageLoader.LoadImage(SpriteID.WaterEndRight);
		waterEndLeft = ImageLoader.LoadImage(SpriteID.WaterEndLeft);
		waterEndDown = ImageLoader.LoadImage(SpriteID.WaterEndDown);
		
		
		
		//Items
		armour = ImageLoader.LoadImage(SpriteID.Armour);
		sword = ImageLoader.LoadImage(SpriteID.Sword);
		
		//Div
		player = ImageLoader.LoadImage(SpriteID.Player);
		playerArmour = ImageLoader.LoadImage(SpriteID.PlayerArmour);
		playerSword = ImageLoader.LoadImage(SpriteID.PlayerSword);
		playerArmourSword = ImageLoader.LoadImage(SpriteID.PlayerArmourSword);
		enemy = ImageLoader.LoadImage(SpriteID.Enemy);
		boss = ImageLoader.LoadImage(SpriteID.Boss);
		bg = ImageLoader.LoadImage(SpriteID.Bg);
	}
}