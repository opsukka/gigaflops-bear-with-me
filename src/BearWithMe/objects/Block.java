package BearWithMe.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import BearWithMe.core.CoreObject;
import BearWithMe.utils.Texture;

public class Block extends CoreObject{

	private BufferedImage image;
	
	public Block(int x, int y, int id, Texture tex, BufferedImage image,int width, int height) {
		super(x, y, id, tex,width,height);
		this.image = image;
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, x, y, null);
	}
	public Rectangle getTopBounds(){
		return new Rectangle(x,y,width, height/2);
	}

}