package myStuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenRicky extends ClickableScreen implements Runnable {
	
	private TextLabel tl;
	private ButtonInterfaceRicky[] buttonI;
	private ProgressInterfaceRicky progressI;
	private ArrayList<MoveInterfaceRicky> moveI;
	
	int roundNumber;
	int sequenceIndex;
	int lastSelectedButton;
	boolean acceptingInput;

	public SimonScreenRicky(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceRicky b: buttonI){ 
		    viewObjects.add(b); 
		}
		progressI = getProgress();
		tl = new TextLabel(130,230,300,40,"Let's play Simon!");
		moveI = new ArrayList<MoveInterfaceRicky>();
		//add 2 moves to start
		lastSelectedButton = -1;
		moveI.add(randomMove());
		moveI.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progressI);
		viewObjects.add(tl);
	}

	private MoveInterfaceRicky randomMove() {
	    int bIndex = (int)(Math.random()*buttonI.length);
	    while(bIndex == lastSelectedButton){
	        bIndex = (int)(Math.random()*buttonI.length);
	    }
	    return getMove(bIndex);
	}

	/**
	Placeholder until partner finishes implementation of MoveInterface
	*/
	private MoveInterfaceRicky getMove(int bIndex) {
	    return null;
	}
	
	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceRicky getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	private void addButtons() {
		int numberOfButtons = 6;
		buttonI = new ButtonInterfaceRicky[numberOfButtons];
		Color[] colors = {Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.PINK, Color.RED};
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
