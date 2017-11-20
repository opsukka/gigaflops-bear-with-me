package BearWithMe.entities;

import java.awt.Graphics2D;

import BearWithMe.rendering.textures.Texture;
import BearWithMe.world.TileMap;


public abstract class Entity {

    protected double  x, y;
    protected Texture texture;
    protected TileMap tileMap;

    public Entity(Texture texture, double x, double y, TileMap tileMap) {
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.tileMap = tileMap;
        tileMap.addEntity(this);
    }

    public abstract void tick();

    public void render(Graphics2D g, int offsetX, int offsetY) {
        texture.render(g, x + offsetX, y + offsetY);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
