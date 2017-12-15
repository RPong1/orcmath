package playground;

import java.util.ArrayList;

public class CatalogMaker {
	
	ArrayList <Fruits> list;
	
	public CatalogMaker() {
		list = new ArrayList<Fruits>();
		list.add(new Fruits("Apples",0.99,20,"resources/apples.png"));
		list.add(new Fruits("Oranges",0.99,20,"resources/oranges.png"));
	}
	
	public static void main(String[] args) {
		
	}

	public String getCSVFile() {
		String data = "";
		for(Fruits f: list) {
			data += f + "\n";
		}
		return data;
	}
	
}
