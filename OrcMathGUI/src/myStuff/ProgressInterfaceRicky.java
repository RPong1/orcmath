package myStuff;


import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;

public interface ProgressInterfaceRicky extends Visible {
	
	void gameOver();
	void setRound(int round);
	void setSequenceSize(int size);
}
