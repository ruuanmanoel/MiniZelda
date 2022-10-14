package zeldaminiclone;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {
	public static BufferedImage spritesheet;
	public static BufferedImage[] playerFront;
	public static BufferedImage enemyFront;
	public static BufferedImage tileWall;
	
	
	public Spritesheet() {
		try {
			spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		playerFront = new BufferedImage[2];
		enemyFront = Spritesheet.getSprite(35, 232, 16, 16);
		playerFront[0] = Spritesheet.getSprite(0, 11, 16, 16);
		playerFront[1] = Spritesheet.getSprite(16, 11, 16, 16);
		tileWall = Spritesheet.getSprite(304, 240, 16, 16); 
 
		
	}
	
	public static BufferedImage getSprite(int x, int y, int width,int height) {
		return spritesheet.getSubimage(x, y, width, height);
	}
}
