package Utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Models.SpriteID;

public class ImageLoader
{
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