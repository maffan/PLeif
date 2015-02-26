package Utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Models.SpriteID;

/**
 * Loads images
 * @author joh
 * @version 2015-02-25
 */
public class ImageLoader
{
	/**
	 * Loads image from file
	 * @param id Filename of image to load
	 * @return A BufferedImage
	 */
	public static BufferedImage LoadImage(SpriteID id)
	{
		BufferedImage image = null;
		
		File path = new File(GamePaths.Pictures + id.toString().toLowerCase() + ".png");

		try {
			image = ImageIO.read(path);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return image;
	}
}