package BearWithMe.entities;


import java.awt.event.KeyEvent;

import BearWithMe.input.KeyInput;
import BearWithMe.rendering.textures.Animation;
import BearWithMe.rendering.textures.Texture;
import BearWithMe.world.TileMap;

public class Player extends Mob {

    public Player(double x, double y, TileMap tileMap) {
        super(new Texture(new Texture("player_sheet"), 1, 1, 64), x, y, tileMap,
                new Animation(5,
                        new Texture(new Texture("player_sheet"), 1, 1, 64),
                        new Texture(new Texture("player_sheet"), 2, 1, 64),
                        new Texture(new Texture("player_sheet"), 3, 1, 64),
                        new Texture(new Texture("player_sheet"), 4, 1, 64),
                        new Texture(new Texture("player_sheet"), 1, 2, 64),
                        new Texture(new Texture("player_sheet"), 2, 2, 64)));

    }

    @Override
    public void tick() {
        if(KeyInput.isDown(KeyEvent.VK_W)) jump(15);
//        if(KeyInput.isDown(KeyEvent.VK_S)) dy = 2;
        if(KeyInput.isDown(KeyEvent.VK_A)) dx = -2;
        if(KeyInput.isDown(KeyEvent.VK_D)) dx = 2;
        
//        if(KeyInput.wasReleased(KeyEvent.VK_W) || KeyInput.wasReleased(KeyEvent.VK_S)) dy = 0;
        if(KeyInput.wasReleased(KeyEvent.VK_A) || KeyInput.wasReleased(KeyEvent.VK_D)) dx = 0;
        super.tick();
    }

}
