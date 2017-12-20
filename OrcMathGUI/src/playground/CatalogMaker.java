package playground;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import guiPlayer.Book;

public class CatalogMaker {
	
	ArrayList <Fruits> list;
	
	Scanner in = new Scanner(System.in);
	
	public CatalogMaker() {
		list = new ArrayList<Fruits>();
		list.add(new Fruits("Apples",2,10));
		list.add(new Fruits("Oranges",2,10));
	}
	
	public static void main(String[] args) {
		CatalogMaker maker = new CatalogMaker();
		maker.add();
		System.out.println(maker.getCSVFile());
	}

	public String getCSVFile() {
		String data = "";
		for(Fruits f: list) {
			data += f + "\n";
		}
		return data;
	}
	
	public void add() {
		System.out.println("Enter a fruit");
		String name = in.nextLine();
		System.out.println("Enter a price");
		String ints = in.nextLine();
		System.out.println("Enter the quantity");
		String integer = in.nextLine();
		if(stringOrNot(name) && doubleOrNot(ints) && numberOrNot(integer)) {
			addFruit(new Fruits(name,Integer.parseInt(ints),Integer.parseInt(integer)));
			System.out.println(name + ", " +ints + ", " +integer);
		}
		else {
			System.out.println("Enter a valid name (String), price (double), and a quantity (int)");
		}
	}
	
	public void addFruit(Fruits b){
		list.add(b);
	}
	
	public void save() {
		try{    
			FileWriter fw = new FileWriter("FruitCatalog.csv");
			for(Fruits b: list){
				fw.write(b+"\n");    	
			}
			fw.close();    
			System.out.println("Success! File \"FruitCatalog.csv\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
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
