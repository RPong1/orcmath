package myStuff;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceRicky extends Clickable {

	void setColor(Color colors);
	void setAction(Action action);
	void highlight();
	void dim();
	
}
