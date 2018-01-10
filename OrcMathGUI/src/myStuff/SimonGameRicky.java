package myStuff;

import guiPlayer.CustomGUI;
import guiPlayer.CustomScreen;
import guiTeacher.GUIApplication;

public class SimonGameRicky extends GUIApplication {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5700313395181523002L;

	public SimonGameRicky(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		SimonScreenRicky screen = new SimonScreenRicky(getWidth(), getHeight());
		setScreen(screen);

	}

	public static void main(String[] args) {
		SimonGameRicky r = new SimonGameRicky(800, 550);
		Thread runner = new Thread(r);
		runner.start();
	}

}
