package BearWithMe.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import BearWithMe.Game;
import BearWithMe.input.KeyInput;
import BearWithMe.input.MouseInput;
import BearWithMe.rendering.ui.Button;
import BearWithMe.utils.Fonts;

public class OptionState implements State {
	 private Button[] options;
	    private int      currentSelection;

	    @Override
	    public void init() {
	        options = new Button[1];
	        options[0] = new Button("Back", 200 + 0 * 80,
	                new Font("Arial", Font.PLAIN, 32), new Font("Arial", Font.BOLD, 48),
	                Color.WHITE, Color.YELLOW);
	    }

	    @Override
	    public void enter() {}

	    @Override
	    public void tick(StateManager stateManager) {

	        if (KeyInput.wasPressed(KeyEvent.VK_UP) || KeyInput.wasPressed(KeyEvent.VK_W)) {
	            currentSelection--;
	            if (currentSelection < 0) currentSelection = options.length - 1;
	        }

	        if (KeyInput.wasPressed(KeyEvent.VK_DOWN) || KeyInput.wasPressed(KeyEvent.VK_S)) {
	            currentSelection++;
	            if (currentSelection >= options.length) currentSelection = 0;
	        }

	        boolean clicked = false;
	        for (int i = 0; i < options.length; i++) {
	            if (options[i].intersects(new Rectangle(MouseInput.getX(), MouseInput.getY(), 1, 1))) {
	                currentSelection = i;
	                clicked = MouseInput.wasPressed(MouseEvent.BUTTON1);
	            }
	        }

	        if (clicked || KeyInput.wasPressed(KeyEvent.VK_ENTER))
	            select(stateManager);
	    }

	    private void select(StateManager stateManager) {
	        switch (currentSelection) {
	            case 0:
	                stateManager.setState("menu");
	                break;
	        }
	    }

	    public void render(Graphics2D g) {
	        g.setColor(Color.BLACK);
	        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
	        Fonts.drawString(g, new Font("Arial", Font.BOLD, 72), Color.ORANGE, Game.TITLE, 80);

	       for (int i = 0; i < options.length; i++) {
	            if (i == currentSelection) options[i].setSelected(true);
	            else options[i].setSelected(false);

	            options[i].render(g);
	        }
	       Fonts.drawString(g, new Font("Arial", Font.BOLD, 50), Color.GREEN, Game.INSTRUCT_1, 280);
	       Fonts.drawString(g, new Font("Arial", Font.BOLD, 50), Color.GREEN, Game.INSTRUCT_2, 340);
	       Fonts.drawString(g, new Font("Arial", Font.BOLD, 50), Color.GREEN, Game.INSTRUCT_3, 400);
	    }

	    @Override
	    public void exit() {}

	    @Override
	    public String getName() {
	        return "menu2";
	    }
}
