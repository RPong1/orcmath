package myStuff;


import guiTeacher.GUIApplication;

public class SimonGameRicky extends GUIApplication {


	private static final long serialVersionUID = -5700313395181523002L;

	private static SimonScreenRicky screen;
	private static SimonGameRicky game;
	
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
		game = new SimonGameRicky(800, 550);
		Thread runner = new Thread(game);
		runner.start();
	}

}
