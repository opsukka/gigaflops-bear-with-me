package BearWithMe.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import BearWithMe.Game;
import BearWithMe.libs.Colors;
import BearWithMe.libs.Images;
import BearWithMe.libs.Reference;
import BearWithMe.utils.Button;

public class Menu {

	public static Button play, options, quit;
	private int buttonWidth = 200;
	private int buttonHeight = 75;

	public void create() {
		play = new Button(Reference.CENTER_X - (buttonWidth / 2), 150, buttonWidth, buttonHeight).setText("Play");
		options = new Button(Reference.CENTER_X - (buttonWidth / 2), 250, buttonWidth, buttonHeight).setText("Options");
		quit = new Button(Reference.CENTER_X - (buttonWidth / 2), 350, buttonWidth, buttonHeight).setText("Quit");
	}

	public void drawButton(Graphics g, Rectangle rect, Color box, Color font, String text, int offset) {
		
		g.setColor(box);
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
		g.setColor(font);
		g.drawString(text, rect.x + offset, rect.y + 51);
	}

	public void render(Graphics g) {
		g.setColor(Colors.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		play.drawButton(g, 51,Colors.LIGHT_GREEN, Colors.RED);
		options.drawButton(g, 85,Colors.LIGHT_GREEN,Colors.RED);
		quit.drawButton(g, 51,Colors.LIGHT_GREEN,Colors.RED);
		g.drawImage(Images.title, 0, 0, null);
	}
}