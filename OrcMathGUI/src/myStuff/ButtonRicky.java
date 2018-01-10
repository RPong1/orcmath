package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonRicky extends Button implements ButtonInterfaceRicky {

	private Color newColor;
	private boolean isHighlighted = false;
	
	public ButtonRicky(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, "", null);
		update();
	}

	@Override
	public void setColor(Color colors) {
		this.newColor = colors;
		update();
	}

	@Override
	public void highlight() {
		isHighlighted =true;
		update();
	}

	@Override
	public void dim() {
		isHighlighted = false;
		update();
	}

	
	public void drawButton(Graphics2D g, boolean hover) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		if(isHighlighted) {
			this.setColor(newColor.brighter());
			g.drawRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		}
		else {
			this.setForeground(newColor.darker());
			g.drawRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		}
	}
}
