/*******************************************************************************
 * Copyright (c) 2016-2017 Benjamin Nockles
 *
 * This file is part of OrcMath.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License 
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package guiTeacher.userInterfaces;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.interfaces.Clickable;
import guiTeacher.interfaces.Visible;

public abstract class ComponentContainer {

	private List<Visible> viewObjects;
	private BufferedImage image;

	public ComponentContainer(int width, int height) {
		viewObjects = new ArrayList<Visible>();
		initImage(width, height);
		initObjects(viewObjects);
	}


	public ComponentContainer(int width, int height, ArrayList<Visible> initWithObjects) {
		viewObjects=initWithObjects;
		initImage(width, height);
		initObjects(viewObjects);
	}
	
	public void initImage(int width, int height) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		update();
		
	}
	/**
	 * adds objects to viewObjects 
	 */
	public abstract void initObjects(List<Visible> viewObjects);

	
	public int[] calculateMaxXY(){
		int maxX = 1;
		int maxY = 1;
		for(Visible v: viewObjects){
			int tempX = v.getX()+v.getWidth();
			int tempY = v.getY()+v.getHeight();
			maxX = (tempX > maxX)?tempX : maxX;
			maxY = (tempY > maxY)?tempY : maxY;
		}
		int[] max = {maxX,maxY};
		return max;
	}
	

	
	public void addObject(Visible v){
		viewObjects.add(v);
	}
	
	public void update() {
//		buffer = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = image.createGraphics();
		update(g);
//		Graphics2D gi = buffer.createGraphics();
//		gi.drawImage(buffer, getWidth(), getHeight(), null);
	}
	
	public void update(Graphics2D g2){
//		BufferedImage buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
//		Graphics2D g2 = buffer.createGraphics();
		g2.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
	             RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.white);
		g2.fillRect(0, 0, image.getWidth(), image.getHeight());
		g2.setColor(Color.black);
		drawObjects(g2);
//		g.drawImage(buffer, 0, 0, null);
	}
	
	public void drawObjects(Graphics2D g){
		//iterate through all view objects
				for(int i = 0; i < viewObjects.size(); i++){
					Visible v= viewObjects.get(i);
					if(v.isVisible())g.drawImage(v.getImage(), v.getX(), v.getY(), null);
				}
	}
	
	public void remove(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);//all other objects slide up in order
		}
	}
	
	public void moveToFront(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);//all other objects slide up in order
			viewObjects.add(v);
		}
	}
	
	public void moveToBack(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);//all other objects slide up in order
			viewObjects.add(0, v);
		}
	}
	
	public void removeAll(){
		viewObjects = new ArrayList<Visible>();
	}
	
	public BufferedImage getImage(){
		return image;
	}
	public int getWidth(){
		return image.getWidth();
	}
	
	public int getHeight(){
		return image.getHeight();
	}

}
