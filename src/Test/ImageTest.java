package Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageTest {

	public static void main(String[] args) {

		try {
			BufferedImage img = ImageIO.read(new File("src/Test/futuristic-city-wallpaper-25.jpg"));

			//Graphics2D g = img.createGraphics();
			int clr = img.getRGB(0,0);
			int  red   = (clr & 0x00ff0000) >> 16;
			int  green = (clr & 0x0000ff00) >> 8;
			int  blue  =  clr & 0x000000ff;
			System.out.println("Red Color value = " + red);
			System.out.println("Green Color value = " + green);
			System.out.println("Blue Color value = " + blue);

			img.setRGB(1,1,0);



		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}
