package BearWithMe.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import BearWithMe.Controller;
import BearWithMe.core.CoreObject;
import BearWithMe.libs.ObjectIds;
import BearWithMe.objects.Block;
import BearWithMe.utils.Texture;

public class Player extends CoreObject{
		
	private double gravity = 0.7;
	private boolean falling = true;
	private boolean jumping = false;
	private static ArrayList<CoreObject> blocks = Controller.getObjects();
	private Block block;
	
	public Player(int x, int y, int id, Texture tex,int width, int height) {
		super(x, y, id, tex, width, height);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		fall();
		checkCollision();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width,height);
		
	}
	
	private void checkCollision(){
		for(CoreObject obj : blocks){
			if(obj.getId() == ObjectIds.id.get("grass")){
				block = (Block) obj;
				if(getBottomBounds().intersects(block.getTopBounds())){
					velY = 0;
					y = block.getY()-height;
				}
			}
		}
	}
	
	public void fall(){
		if(falling){
			velY += gravity;
		}
	}
	
	public Rectangle getBottomBounds(){
		return new Rectangle(x,y+(height/2),30, height/2);
	}

}