package playground;

import guiTeacher.components.*;
import java.io.File;
import java.util.List;
import javax.swing.JFrame;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen implements FileRequester {
	
	private static final long serialVersionUID = 258186143576427947L;
	private TextField text;
	private TextArea textA;
	private Button addButton;
	private FileOpenButton openButton;
	private CatalogMaker catalog;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		text = new TextField(40,40,200,30,"Enter name here","Name");
		viewObjects.add(text);
		text = new TextField(40,100,200,30,"Enter price here","Price"); 
		viewObjects.add(text);
		text.setInputType(1); 
		text = new TextField(40,175,200,30,"Enter quantity here","Quantity"); 
		text.setInputType(1); 
		viewObjects.add(text);
		textA = new TextArea(350,40,150,100,"Text goes here");
		viewObjects.add(textA);
		addButton = new Button(350,100,50,50,"Add", new Action() {
			
			
			@Override
			public void act() {
				addClicked();
			}
		});
		
		viewObjects.add(addButton);
		
			addButton = new Button(400,100,50,50,"Save", new Action() {
			
			@Override
			public void act() {
				addClicked();
			}
		});
		
		viewObjects.add(addButton);
		
			addButton = new Button(450,100,50,50,"Delete", new Action() {
			
			@Override
			public void act() {
				addClicked();
			}
		});
		
		viewObjects.add(addButton);
		
			addButton = new Button(500,100,50,50,"Load", new Action() {
			
			@Override
			public void act() {
				addClicked();
			}
		});
		
		viewObjects.add(addButton);
		
		openButton = new FileOpenButton(550, 100, 50, 50, null, this);
		
		catalog = new CatalogMaker();
	}

	protected void addClicked() {
		Fruits f = new Fruits(text.getText(), Integer.parseInt(text.getText()), Integer.parseInt(text.getText()));
		textA.setText(f.toString());
		catalog.addFruit(f);
	}

	@Override
	public void setFile(File f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JFrame getWindow() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
