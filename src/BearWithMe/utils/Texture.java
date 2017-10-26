package BearWithMe.utils;

import java.awt.image.BufferedImage;

import BearWithMe.libs.Images;

public class Texture {

	private SpriteSheet sheetTest;
	
	public BufferedImage blockGrass, unused;
	
	public Texture(){
		sheetTest = new SpriteSheet(Images.spritesheet_test, 32);
		
		initTextures();
	}
	
	private void initTextures(){
		blockGrass = sheetTest.getSprite(1, 1);
		unused = sheetTest.getSprite(2, 1);
	}
	
}