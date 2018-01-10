package myStuff;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import guiTeacher.components.Component;
import guiTeacher.components.TextLabel;

public class ProgressRicky extends Component implements ProgressInterfaceRicky {

	private TextLabel text;
	private int rounds;
	private int sequence;
	private boolean isPlaying;

	public ProgressRicky(int x, int y, int w, int h) {
		super(x, y, w, h);
		isPlaying = true;
	}
	
	@Override
	public void gameOver() {
		isPlaying = false;
		update();
	}

	@Override
	public void setRound(int round) {
		this.rounds = round;
		update();
	}

	@Override
	public void setSequenceSize(int size) {
		this.sequence = size;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		FontMetrics font = g.getFontMetrics();
		int fontSize = 12;
		g.setFont(new Font("Calibri", Font.PLAIN, fontSize));
		if(isPlaying) {
			g.setColor(Color.GREEN);
			g.fillRect(0,0,100,100);
			g.setColor(Color.BLACK);
			g.drawString("Round:  "+rounds, getX(), getY());
			g.drawString("Sequence: "+sequence, getX(), getY()+ 20);
		}else {
			g.setColor(Color.ORANGE);
			g.fillRect(0, 0, 100, 100);
			g.setColor(Color.BLACK);
			g.drawString("Game over ", getX(), getY());
		}
	}

}
