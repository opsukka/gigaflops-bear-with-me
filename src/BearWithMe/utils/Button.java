package BearWithMe.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import BearWithMe.input.MouseInput;
import BearWithMe.libs.Colors;

@SuppressWarnings("serial")
public class Button extends Rectangle {

	private String text;
	
	public Button() {
		super();
	}

	public Button(Rectangle arg0) {
		super(arg0);

	}

	public Button(Point arg0) {
		super(arg0);

	}

	public Button(Dimension arg0) {
		super(arg0);

	}

	public Button(int arg0, int arg1) {
		super(arg0, arg1);

	}

	public Button(Point arg0, Dimension arg1) {
		super(arg0, arg1);

	}

	public Button(int x, int y, int width, int height) {
		super(x,y,width,height);

	}
	
	public Button setText(String text){
		this.text = text;
		return this;
	}
	
	public void drawButton(Graphics g, int offset, Color color, Color colortext){
		int xx = x +((width / 2)-offset);
		int yy = y + 51;
		Font tempFont = new Font("Long_Shot", Font.BOLD, 45);
		g.setFont(tempFont);
		if(MouseInput.MOUSE.intersects(this) && MouseInput.MOUSE != null){
			g.setColor(Colors.DARK_GREEN);
		}else if(!MouseInput.MOUSE.intersects(this) && MouseInput.MOUSE != null){
			g.setColor(color);
		}
		g.fillRect(x, y, width, height);
		if(MouseInput.MOUSE.intersects(this) && MouseInput.MOUSE != null){
			g.setColor(Colors.TAN);
		}else{
			g.setColor(colortext);
		}
		g.drawString(text, xx, yy);
	}

}