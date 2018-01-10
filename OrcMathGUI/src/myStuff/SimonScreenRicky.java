package myStuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenRicky extends ClickableScreen implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4523343284186696742L;
	
	private ProgressInterfaceRicky progress;
	private TextArea response;
	private ArrayList<MoveInterfaceRicky> move;
	private ButtonInterfaceRicky[] buttons;
	
	
	int rNum;
	int sequenceIndex;
	int lastButton;
	boolean acceptInput;

	public SimonScreenRicky(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run(){
	    response.setText("");
	    nextRound();
	}

	private void nextRound() {
		acceptInput = false;
		rNum++;
		move.add(randomMove());
		progress.setRound(rNum);
		progress.setSequenceSize(move.size());
		changeText("Simon's turn");
		response.setText("");
		playSequence();
		changeText("Your turn");
		acceptInput = true;
		sequenceIndex = 0;
	}
	
	private void playSequence() {
		ButtonInterfaceRicky b = null;
		for(int i=0; i< move.size(); i++) {
			if(b != null) {
				b.dim();
			}
			b = move.get(i).getButton();
			b.highlight();
			int sleepTime = 1000 / rNum;
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
		Thread sleep = new Thread(new Runnable(){
			public void run(){
				response.setText(string);
				try{
					Thread.sleep(100);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		});
		sleep.start();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceRicky b: buttons){ 
		    viewObjects.add(b); 
		}
		progress = getProgress();
		response = new TextArea(230,330,300,40,"Simon's Turn");
		viewObjects.add(response);
		
		move = new ArrayList<MoveInterfaceRicky>();
		//add 2 moves to start
		lastButton = -1;
		move.add(randomMove());
		move.add(randomMove());
		rNum = 0;
		viewObjects.add(progress);
	}

	private MoveInterfaceRicky randomMove() {
		ButtonInterfaceRicky b = null;
	    int bIndex = (int)(Math.random()*buttons.length);
	    while(bIndex == lastButton){
	        bIndex = (int)(Math.random()*buttons.length);
	    }
	    b = buttons[bIndex];
	    lastButton = bIndex;
	    return getMove(b);
	}

	/**
	Placeholder until partner finishes implementation of MoveInterface
	*/
	private MoveInterfaceRicky getMove(ButtonInterfaceRicky b) {
		return new MoveRicky(b);
	}
	
	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceRicky getProgress() {
		return new ProgressRicky(50,350,100,100);

	}

	private void addButtons() {
		int numberOfButtons = 5;
		buttons = new ButtonInterfaceRicky[numberOfButtons];
		Color[] colors = {Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.PINK, Color.RED};
		for(int i = 0; i < numberOfButtons; i++){
			buttons[i] = getAButton();
			buttons[i].setColor(colors[i]);
			buttons[i].setX(100*i+50);
			buttons[i].setY(100);
			final ButtonInterfaceRicky b = buttons[i];
			b.dim();
			b.setAction(new Action(){
				public void act(){
					if(acceptInput){
						Thread changeButton = new Thread(new Runnable(){
							public void run(){
								b.highlight();
								try {
									Thread.sleep(800);
								}catch (InterruptedException e) {
									e.printStackTrace();
								}
								b.highlight();
							}
						});
						changeButton.start();
						if(b == move.get(sequenceIndex).getButton()){
							sequenceIndex++;
						}
						else{
							progress.gameOver();
							acceptInput = false;
						}
						
						if(sequenceIndex == move.size()){ 
						    Thread nextRound = new Thread(SimonScreenRicky.this); 
						    nextRound.start(); 
						}
					}
				}
			});
		}
	}
	
	/**
	Placeholder until partner finishes implementation of ButtonInterface
	*/
	private ButtonInterfaceRicky getAButton() {
		return new ButtonRicky(0,0,75,75,"",null);
	}
}