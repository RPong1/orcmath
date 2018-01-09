package myStuff;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Component;

public class ProgressRicky extends Component implements ProgressInterfaceRicky {

	private boolean isPlaying ;
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

	}

	@Override
	public void setRound(int i) {
		roundNum = i;
	}

	@Override
	public void setSequenceSize(int i) {
		sequenceNum = i;
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		if(isPlaying) {
			g.drawString(" "+roundNum, getX(), getY());
			g.drawString(" "+sequenceNum, getX(), getY()+ 15);
		}else {
			g.drawString("Game over ", getX(), getY());
		}

	}
}

