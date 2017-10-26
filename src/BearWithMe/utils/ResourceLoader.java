package BearWithMe.utils;

import java.io.IOException;

import BearWithMe.libs.Audio;
import BearWithMe.libs.Fonts;
import BearWithMe.libs.Images;

public class ResourceLoader {

	private static BufferedImageLoader imageLoader = new BufferedImageLoader();

	public static void loadImages() {

		try {
			Images.title = imageLoader.loadImage("BearWithMe Logo.png");
			Images.spritesheet_test = imageLoader.loadImage("test_Spritesheet.png");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void loadFonts() {
		Fonts.addFont(new Fonts("Long_Shot.ttf"));
	}

}