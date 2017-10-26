package BearWithMe.input;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import BearWithMe.Game;
import BearWithMe.enums.GameState;
import BearWithMe.libs.Audio;
import BearWithMe.screens.Menu;

public class MouseInput extends MouseAdapter {

	public static int MOUSE_X, MOUSE_Y;
	public static Rectangle MOUSE = new Rectangle(1, 1, 1, 1);

	
	@Override
	public void mouseClicked(MouseEvent e) {
		int mouse = e.getButton();
		Rectangle rect = new Rectangle(e.getX(), e.getY(), 1, 1);

		if (mouse == MouseEvent.BUTTON1) {
			switch (Game.state) {
			case GAME:
				break;
			case MENU:
				if (rect.intersects(Menu.play)) {
					Game.state = GameState.GAME;
				} else if (rect.intersects(Menu.options)) {

				} else if (rect.intersects(Menu.quit)) {
					System.exit(1);
				}
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

	@Override
	public void mouseMoved(MouseEvent e) {
		MOUSE_X = e.getX();
		MOUSE_Y = e.getY();

		MOUSE = new Rectangle(MOUSE_X, MOUSE_Y, 1, 1);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (MOUSE.intersects(Menu.quit)) {

		}
	}
}