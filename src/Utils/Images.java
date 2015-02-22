package Utils;

import java.awt.image.BufferedImage;

import Models.SpriteID;

public class Images
{
	public BufferedImage tree;
	public BufferedImage player;
	
	/**
	 * Loads all images to be used.
	 */
	public Images()
	{
		tree = ImageLoader.LoadImage(SpriteID.Tree);
		player = ImageLoader.LoadImage(SpriteID.Player);
	}
}