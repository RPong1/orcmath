package myStuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenRicky extends ClickableScreen implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4523343284186696742L;
	
	private TextLabel tl;
	private ButtonInterfaceRicky[] buttonI;
	private TextLabel progressI;
	//private ProgressInterfaceRicky progressI;
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
	public void run(){
	    tl.setText("");
	    nextRound();
	}

	private void nextRound() {
		acceptingInput = false;
		roundNumber++;
		moveI.add(randomMove());
		//progressI.setRound(roundNumber);
		//progressI.setSequenceSize(moveI.size());
		progressI.setText("Round: "+roundNumber+"  Size: "+moveI.size());
		changeText("Simon's turn");
		playSequence();
		changeText("Your turn");
		acceptingInput = true;
		sequenceIndex = 0;
	}
	
	private void playSequence() {
		ButtonInterfaceRicky b = null;
		for(int i=0; i< moveI.size(); i++) {
			if(b != null) {
				b.dim();
			}
			b = moveI.get(i).getButton();
			b.highlight();
			int sleepTime = 1000 / roundNumber;
			try {
				Thread.sleep(sleepTime);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		b.dim();
	}

	private void changeText(String string) {
		tl.setText(string);
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tl.setText("");
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceRicky b: buttonI){ 
		    viewObjects.add(b); 
		}
		//progressI = getProgress();
		progressI = new TextLabel(230,330,300,40,"");
		tl = new TextLabel(130,230,300,40,"Let's play Simon!");
		
		moveI = new ArrayList<MoveInterfaceRicky>();
		//add 2 moves to start
		lastSelectedButton = -1;
		moveI.add(randomMove());
		moveI.add(randomMove());
		roundNumber = 0;
		viewObjects.add(tl);
		viewObjects.add(progressI);
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
		return new MoveRicky(buttonI[bIndex]);
	}
	
	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceRicky getProgress() {
		return new ProgressRicky(0,0,100,40);

	}

	private void addButtons() {
		int numberOfButtons = 6;
		buttonI = new ButtonInterfaceRicky[numberOfButtons];
		Color[] colors = {Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.PINK, Color.RED};
		for(int i = 0; i < numberOfButtons; i++){
			final ButtonInterfaceRicky b = getAButton();
			b.setColor(colors[i]);
			b.setX(50*i+50);
			b.setY(100);
			b.setAction(new Action(){
				public void act(){
					if(acceptingInput){
						Thread blink = new Thread(new Runnable(){
							public void run(){
								b.highlight();
								try {
									Thread.sleep(800);
								}catch (InterruptedException e) {
									e.printStackTrace();
								}
								b.dim();
							}
						});
						blink.start();
						if(b == moveI.get(sequenceIndex).getButton()){
							sequenceIndex++;
						}
						else{
							//progressI.gameOver();
							progressI.setText("Game Over");
						}
						
						if(sequenceIndex == moveI.size()){ 
						    Thread nextRound = new Thread(SimonScreenRicky.this); 
						    nextRound.start(); 
						}
					}
				}
			});
			//buttonI[i] = b;
		}
	}
	
	/**
	Placeholder until partner finishes implementation of ButtonInterface
	*/
	private ButtonInterfaceRicky getAButton() {
		return new ButtonRicky(20,20,40,40,"",null);
	}
}