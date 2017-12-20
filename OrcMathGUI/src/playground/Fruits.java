package playground;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Fruits extends AnimatedComponent {

	private String name;
	private double price;
	private int quantity;
	
	public Fruits(String name, int price, int quantity) {
		
		super(0, 100, 64, 64);
		
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		
		addSequence("resources/professor.png", 200, 0, 0, 64, 64, 9);
		Thread animation = new Thread(this);
		animation.start();
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.ORANGE);
		//g.fillRect(0, 0, getWidth(), getHeight());
		super.update(g);
	}

	public String toString() {
		return name + ", " + price + ", " + quantity;
	}
	
}