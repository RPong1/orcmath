package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonRicky extends Button implements ButtonInterfaceRicky {

	private Color newColor;
	
	public ButtonRicky(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, "", null);
		update();
	}

	@Override
	public void setColor(Color colors) {
		this.setForeground(colors);
		newColor = colors;
		update();
	}

	@Override
	public void highlight() {
		this.setColor(newColor.brighter());
		update();
	}

	@Override
	public void dim() {
		this.setForeground(newColor.darker());
		update();
	}

	
	public void drawButton(Graphics2D g, boolean hover) {
		if(hover) {
			highlight();
			g.drawRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		}
		else {
			dim();
			g.drawRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		}
	}
}
