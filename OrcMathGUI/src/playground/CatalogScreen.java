package playground;

import guiTeacher.components.TextField;
import java.util.List;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {
	
	private static final long serialVersionUID = 258186143576427947L;
	private TextField text;
	
	
	public CatalogScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		text = new TextField(40,40,200,30,"Enter Title of book here","Title");
		viewObjects.add(text);
		text = new TextField(40,100,200,50,"Enter Author of book here","Author"); 
		viewObjects.add(text);
		text = new TextField(40,200,300,70,"Enter Number of Pages of book here","Number of Pages"); 
		viewObjects.add(text);
	}

}
