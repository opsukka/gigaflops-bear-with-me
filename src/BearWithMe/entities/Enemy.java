package BearWithMe.entities;

import java.awt.Graphics2D;

import BearWithMe.rendering.textures.Animation;
import BearWithMe.rendering.textures.Texture;
import BearWithMe.world.TileMap;

public abstract class Enemy extends Entity {

    protected double    dx, dy;
    protected double    maxDY;
    protected double    gravity;
    protected boolean   falling;
    protected boolean   canJump;
    protected boolean   moving;
    protected Animation anime;

    public Enemy(Texture texture, double x, double y, TileMap tileMap, Animation anime) {
        super(texture, x, y, tileMap);
        this.anime = anime;
        gravity = 0.5;
        maxDY = 7;
    }

    @Override
    public void tick() {
        if (dy > 0) falling = true;
        else if (dy < 0) falling = false;
        move();
        fall();
        if (dx != 0) moving = true;
        else moving = false;
        if (moving) anime.run();
    }

    @Override
    public void render(Graphics2D g, int offsetX, int offsetY) {
        if (!moving)
            super.render(g, offsetX, offsetY);
        else anime.render(g, x + offsetX, y + offsetY);
    }

    public void move() {
        boolean horiz = tileMap.getTileCollision(texture.getWidth(), x, y, x + dx, y, false);
        boolean vert = tileMap.getTileCollision(texture.getWidth(), x, y, x, y + dy, true);
        if (!horiz) x += dx;
        if (!vert) y += dy;
    }

    protected void fall() {
        dy += gravity;
        if (dy > maxDY) dy = maxDY;
    }

    public void setVelocityY(double dy) {
        this.dy = dy;
    }

    public boolean isFalling() {
        return falling;
    }

    public boolean isMovingLeft() {
        return dx < 0;
    }

    public boolean isMovingRight() {
        return dx > 0;
    }

    public boolean isMoving() {
        return moving;
    }

}
