package BearWithMe.rendering;

import java.awt.Graphics2D;

import BearWithMe.Game;
import BearWithMe.rendering.textures.Texture;

public class ParallaxLayer {

    private Texture texture;
    private int     x, y;
    private int     width, height;
    private int     dx;
    private int     gap;
    private boolean left, right;

    public ParallaxLayer(Texture texture, int dx, int gap) {
        this.texture = texture;
        this.dx = dx;
        this.gap = gap;
        this.width = texture.getWidth();
        this.height = texture.getHeight();
        this.x = this.y = 0;
    }

    public ParallaxLayer(Texture texture, int dx) {
        this(texture, dx, 0);
    }

    public void setRight() {
        right = true;
        left = false;
    }

    public void setLeft() {
        right = false;
        left = true;
    }

    public void stop() {
        right = left = false;
    }

    public void move() {
        if (right) x = (x + dx) % (width + gap);
        else x = (x - dx) % width;
    }

    public void render(Graphics2D g) {
        if (x == 0)
            texture.render(g, 0, Game.WIDTH, 0, Game.WIDTH, y);
        else if (x > 0 && x < Game.WIDTH) {
            texture.render(g, x, Game.WIDTH, 0, Game.WIDTH - x, y);
            texture.render(g, 0, x, width - x, width, y);
        } else if (x >= Game.WIDTH)
            texture.render(g, 0, Game.WIDTH, width - x, width - x + Game.WIDTH, y);
        else if (x < 0 && x >= Game.WIDTH - width)
            texture.render(g, 0, Game.WIDTH, -x, Game.WIDTH - x, y);
        else if (x < Game.WIDTH - width) {
            texture.render(g, 0, width + x, -x, width, y);
            texture.render(g, gap + width + x, gap + Game.WIDTH, 0, Game.WIDTH - width - x, y);
        }
    }

}
