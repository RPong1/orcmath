package playground;

import java.util.ArrayList;
import java.util.Scanner;

public class CatalogMaker {
	
	ArrayList <Fruits> list;
	
	Scanner in = new Scanner(System.in);
	
	public CatalogMaker() {
		list = new ArrayList<Fruits>();
		list.add(new Fruits("Apples",1.99,10));
		list.add(new Fruits("Oranges",1.99,10));
	}
	
	public static void main(String[] args) {
		CatalogMaker maker = new CatalogMaker();
		maker.addFruits();
		System.out.println(maker.getCSVFile());
	}

	public String getCSVFile() {
		String data = "";
		for(Fruits f: list) {
			data += f + "\n";
		}
		return data;
	}
	
	public void addFruits() {
		System.out.println("Enter a fruit");
		String name = in.nextLine();
		System.out.println("Enter a price");
		String doubles = in.nextLine();
		System.out.println("Enter the quantity");
		String integer = in.nextLine();
		if(stringOrNot(name) && doubleOrNot(doubles) && numberOrNot(integer)) {
			System.out.println(name + ", " +doubles + ", " +integer);
		}
		else {
			System.out.println("Enter a valid name (String), price (double), and a quantity (int)");
		}
	}
	
	public boolean numberOrNot(String input){
	    try
	    {
	        Integer.parseInt(input);
	    }
	    catch(NumberFormatException ex)
	    {
	        return false;
	    }
	    return true;
	}
	
	public boolean doubleOrNot(String input){
	    try
	    {
	        Double.parseDouble(input);
	    }
	    catch(NumberFormatException ex)
	    {
	        return false;
	    }
	    return true;
	}
	
	public boolean stringOrNot(String input) {
		return(input.substring(0, 1).compareTo("A")> 0);
	}
	
	/*
	 * String[] data = line.split(",");
	 * list.add(new Fruits(data[0],data[1],data[2]
	 */
}
