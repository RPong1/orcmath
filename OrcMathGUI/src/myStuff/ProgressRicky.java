package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Component;

public class ProgressRicky extends Component implements ProgressInterfaceRicky {

	private boolean isPlaying;
	private int roundNum;
	private int sequenceNum;

	public ProgressRicky(int x, int y, int w, int h) {
		super(x, y, w, h);
		isPlaying = true;
		roundNum = 1;
		sequenceNum = 1;
	}

	@Override
	public void gameOver() {
		isPlaying = false;
		update();
	}

	@Override
	public void setRound(int i) {
		roundNum = i;
		update();
	}

	@Override
	public void setSequenceSize(int i) {
		sequenceNum = i;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		clear();
		if(isPlaying) {
			g.setColor(Color.DARK_GRAY);
			g.drawString("Round:  "+roundNum, getX(), getY());
			g.drawString("Sequence: "+sequenceNum, getX(), getY()+ 15);
		}else {
			g.setColor(Color.DARK_GRAY);
			g.drawString("Game over ", getX(), getY());
		}

	}
}

