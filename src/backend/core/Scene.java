package backend.core;

import javax.swing.JTextField;

import backend.events.LoadLayerHandler;
import backend.menu.TopMenuBar;
import backend.menu.WriteField;
import frontend.MainFrame;
import users.CsvSerializer;
import users.Student;

public class Scene
{
	public static void init()
	{
		new MainFrame(800 ,600);		
		//Initialisations
		//Layer 0
		AppButton login = new AppButton("Login", false, 0);
		TopMenuBar menuBar = new TopMenuBar(0, 0, 0);
		WriteField username = new WriteField(false, 0); 
		WriteField password = new WriteField(false, 0);

		
		//Layer 1
		
		//Properties
		login.setFontSize(20);
		login.setPos(AppController.getMainFrame().getWidth()/2 - login.getWidth()/2 + 100 , AppController.getMainFrame().getHeight()/2 - login.getHeight()/2);
		
		username.setSize(150, 30);
		password.setSize(150, 30);
		username.setPos(login.getPosX() - username.getWidth(), login.getPosY() - username.getHeight()*2 - 20);
		password.setPos(username.getX(), username.getY() + username.getHeight() + 20);
		
		
		
		//Definitions
		login.getActions().setOnClickAction(() -> {
			Student student = new Student(username.getText(), password.getText());
			CsvSerializer<Student> serializer = new CsvSerializer<Student>();
			//serializer.saveToCsv("Students.csv", student);
			
			String[] properties = {student.getUserName(), student.getPassword()};
			int[] colums = {0, 1};
			
			
			if(serializer.findMatchingProperties(colums, properties, "Students.csv") > -1)
				LoadLayerHandler.loadLayer(1);
		});
		
		LoadLayerHandler.loadLayer(0);	
	}

}
