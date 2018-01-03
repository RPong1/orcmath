package myStuff;

import guiPlayer.CustomGUI;
import guiPlayer.CustomScreen;
import guiTeacher.GUIApplication;

public class SimonGameRicky extends GUIApplication {

	public SimonGameRicky(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		CustomScreen screen = new CustomScreen(getWidth(), getHeight());
		setScreen(screen);

	}

	public static void main(String[] args) {
		SimonGameRicky r = new SimonGameRicky(800, 550);
		Thread runner = new Thread(r);
		runner.start();
	}

}
