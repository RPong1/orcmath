package playground;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextMaker {

	public static void main(String[] args) {
		List<String> content = userInput();
		testSaveContent("test.txt");
	}

	private static List<String> userInput() {
		Scanner in = new Scanner(System.in);
		String userInput = "";
		List<String> content = new ArrayList<String>();
		boolean exit = false;
		while(!exit) {
			System.out.println("What would you like to save?");
			userInput = in.nextLine();
			if(userInput != "") {
				content.add(userInput);
				exit = true;
			}
			else {
				System.out.println("Enter a valid input.");
			}
		}
		return content;
	}
	
	private static void testSaveContent(String fileName) {
		try{    
			FileWriter fw=new FileWriter(fileName);    
			fw.write("This file was created programmatically.");    
			fw.close();    
			System.out.println("Success! File \""+fileName+"\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}
}
