package BearWithMe.states;

import java.awt.Graphics2D;

import BearWithMe.Game;
import BearWithMe.world.TileMap;

public class GameState implements State {


    private TileMap tileMap;
    
    @Override
    public void init() {
        tileMap = new TileMap("level1");
    }

    @Override
    public void enter() {}

    @Override
    public void tick(StateManager stateManager) {
        tileMap.tick();
    }

    @Override
    public void render(Graphics2D g) {
        tileMap.render(g, Game.WIDTH, Game.HEIGHT);
    }

    @Override
    public void exit() {
    }

    @Override
    public String getName() {
        return "level1";
    }

}
