package backend.core;

import java.util.ArrayList;
import java.util.Hashtable;

import backend.events.LoadLayerHandler;
import backend.menu.TopMenuBar;
import backend.menu.WriteField;
import frontend.MainFrame;
import tests.QuestionPanel;
import tests.Test;
import users.CsvSerializer;
import users.Student;
import users.User;

public class Scene
{
	public static void init()
	{
		new MainFrame(800 ,600);		
		/*
		 * New databse type of hash table
		 * load Students file and create student
		 * 
		 */
		CsvSerializer<Student> csvserializer = new CsvSerializer<Student>();
		UserDatabase database = new UserDatabase();
		database.AddSubDatabase("Students", csvserializer.loadDatabase("Students.csv"));
		
		Hashtable<String, Student>instanceDatabase = (Hashtable<String, Student>) database.instanciateSubDatabase("Students", "STUDENT");
		System.out.println(instanceDatabase.get("Jason").getPassword());
		
		instanceDatabase.get("Jason").sendMessage("Go fuck yourself");
		
		
		
		
		//Initialisations
			// Layer 0
		AppButton login = new AppButton("Login", false, 0);
		WriteField username = new WriteField(false, 0); 
		WriteField password = new WriteField(false, 0);
		
			// Layer 1
		TopMenuBar menuBar = new TopMenuBar(0, 0, 0, 2);
		
			// Layer 2
		Test test = new Test(false, 2);
		QuestionPanel question1 = new QuestionPanel(false, 2);
		question1.setQuestion("What language do you like?");
		question1.setAnswers("C#", "Java", "C", "C++");
		question1.setCorrectAnswer(0);
		
		QuestionPanel question2 = new QuestionPanel(false, 2);
		question2.setQuestion("How much is 2+2?");
		question2.setAnswers("4", "7", "2", "8");
		question2.setCorrectAnswer(0);

		
		QuestionPanel question3 = new QuestionPanel(false, 2);
		question3.setQuestion("Are static methods useful in OOP based languages?");
		question3.setAnswers("Yes", "They are useful only in certian situations", "They are useless", "They should be used all the time");
		question2.setCorrectAnswer(0);

		
		test.addQuestion(question1);
		test.addQuestion(question2);
		test.addQuestion(question3);
		
		//Properties
			// Layer 0
		login.setFontSize(20);
		login.setPos(AppController.getMainFrame().getWidth()/2 - login.getWidth()/2 + 100 , AppController.getMainFrame().getHeight()/2 - login.getHeight()/2);
		
		username.setSize(150, 30);
		password.setSize(150, 30);
		username.setPos(login.getPosX() - username.getWidth(), login.getPosY() - username.getHeight()*2 - 20);
		password.setPos(username.getX(), username.getY() + username.getHeight() + 20);
		
		
		
		//Definitions
			// Layer 0
		login.getActions().setOnClickAction(() -> {
			if(database.findByUsername("Students", username.getText()).get(1).equals(password.getText()))
			{
				UserDatabase.currentUser = instanceDatabase.get(username.getText());
				LoadLayerHandler.loadLayer(1);
				System.out.println("Logged in as " + UserDatabase.currentUser);
			}

		});
		
		LoadLayerHandler.loadLayer(0);	
	}

}
