package myStuff;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceRicky extends Clickable {

	void setColor(Color Color);
	void setAction(Action a);
	void highlight();
	void dim();
	
}
