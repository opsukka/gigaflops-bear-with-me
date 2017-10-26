package BearWithMe;

import java.awt.Color;
import java.awt.Graphics;

public class Render {
	// private static Game game = Game.getInstance();

	public static void renderBackground(Graphics g) {
		switch (Game.state) {
		case MENU:
			Game.getInstance().menu.render(g);
			break;
		case GAME:
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		default:
			g.setColor(Color.RED);
			g.drawString("UNKNOWN GAME STATE", 150, 150);
			break;
		}
	}

	public static void renderForeground(Graphics g) {
		switch (Game.state) {
		case GAME:
			Game.getInstance().getController().render(g);
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
