package BearWithMe.core;

import java.awt.Graphics;

import BearWithMe.utils.Texture;

public abstract class CoreObject {

	protected int x, y, velX, velY;
	protected int id;
	protected int width;
	protected int height;
	protected Texture tex;
	public CoreObject(int x, int y, int id, Texture tex) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.tex = tex;
		width = 32;
		height = 32;
	}
	
	public CoreObject(int x, int y, int id, Texture tex, int width, int height) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.tex = tex;
		this.width = width;
		this.height = width;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public long getId() {
		return id;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

}