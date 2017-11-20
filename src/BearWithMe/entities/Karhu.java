package BearWithMe.entities;

import java.awt.event.KeyEvent;

import BearWithMe.input.KeyInput;
import BearWithMe.rendering.textures.Animation;
import BearWithMe.rendering.textures.Texture;
import BearWithMe.world.TileMap;

public class Karhu extends Mob {
	public Karhu(double x, double y, TileMap tileMap) {
		 super(new Texture(new Texture("karhu_sheet"), 1, 1, 64), x, y, tileMap,
	                new Animation(5,
	                        new Texture(new Texture("karhu_sheet"), 1, 1, 64)));
	}
}
