package myStuff;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonRicky extends Button implements ButtonInterfaceRicky {

	private Color Color;
	private boolean isHighlighted;
	
	public ButtonRicky(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, "", action);
		isHighlighted = false;
	}

	@Override
	public void setColor(Color color) {
		this.Color = color;
		update();
	}

	@Override
	public void highlight() {
		isHighlighted = true;
		update();
	}

	@Override
	public void dim() {
		isHighlighted = false;
		update();
	}

	
	public void drawButton(Graphics2D g, boolean hover) {
		if(isHighlighted) {
			g.setColor(Color.darker());
			g.fillRect(0, 0, getWidth(), getHeight());
		}
		else {
			g.setColor(Color);
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	}
}
