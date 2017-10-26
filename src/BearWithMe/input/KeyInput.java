package BearWithMe.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import BearWithMe.Controller;
import BearWithMe.Game;
import BearWithMe.entity.Player;
import BearWithMe.libs.ObjectIds;

public class KeyInput extends KeyAdapter {

	private Player player;

	private boolean[] keyDown = new boolean[2];

	public KeyInput() {
		for (int k = 0; k < Controller.getObjects().size(); k++) {
			if (Controller.getObjects().get(k).getId() == ObjectIds.id.get("player")) {
				player = (Player) Controller.getObjects().get(k);
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		switch (Game.state) {
		case GAME:
			if (key == KeyEvent.VK_W) {
				player.setVelY(-5);
			}
			if (key == KeyEvent.VK_A) {
				player.setVelX(-5);
				keyDown[0] = true;
			}
			if (key == KeyEvent.VK_D) {
				player.setVelX(5);
				keyDown[1] = true;
			}
			break;
		case MENU:
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		default:
			break;

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch (Game.state) {
		case GAME:
			if (key == KeyEvent.VK_W) {
				player.setVelY(0);
			}
			if (key == KeyEvent.VK_A) {
				keyDown[0] = false;
			}
			if (key == KeyEvent.VK_D) {
				keyDown[1] = false;
			}
			
			if(keyDown[0] && !keyDown[1]){
				player.setVelX(-5);
			}
			if(!keyDown[0] && keyDown[1]){
				player.setVelX(5);
			}
			if(!keyDown[0] && !keyDown[1]){
				player.setVelX(0);
			}
			break;
		case MENU:
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		default:
			break;

		}
	}

}