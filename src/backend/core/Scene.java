package backend.core;

import java.util.ArrayList;
import java.util.Hashtable;

import backend.events.LoadLayerHandler;
import backend.events.UserEventHandler;
import backend.menu.LogonEvent;
import backend.menu.LogonHandler;
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
		System.out.println(database.getSubDatabase("Students"));
		
		Hashtable<String, Student>instanceDatabase = (Hashtable<String, Student>) database.instanciateSubDatabase("Students", "STUDENT");
		//System.out.println(instanceDatabase.get("Jason").getPassword());
			
		
		
		
		//Initialisations
			// Layer 0
		AppButton login = new AppButton("Login", false, 0);
		WriteField username = new WriteField(false, 0); 
		WriteField password = new WriteField(false, 0);
		
			// Layer 1
		TopMenuBar menuBar = new TopMenuBar(0, 0, 0, 2);
		MessageBox box = new MessageBox(false, 1);
		box.setPosition(100, 100);
		
			// Layer 2
		Test test = new Test(false, 2);
		QuestionPanel question1 = new QuestionPanel(false, 2);
		question1.setQuestion("Triedy v jazyku C++ majú pôvod v mechanizme: ");
		question1.setAnswers("Union", "Struct", "Template", "Enum");
		question1.setCorrectAnswer(1);
		
		QuestionPanel question2 = new QuestionPanel(false, 2);
		question2.setQuestion("Co v jazyku C# zodpoveda pristupovym metodam v jazyku Java");
		question2.setAnswers("Setter", "Delegate", "Accessor", "Property");
		question2.setCorrectAnswer(2);

		
		QuestionPanel question3 = new QuestionPanel(false, 2);
		question3.setQuestion("Co v jazyku C++ umoznuje emulovat spravanie rozhrani v jazyku java");
		question3.setAnswers("Virtualne metody", "Abstraktne triedy", "Namespace", "Ine");
		question3.setCorrectAnswer(1);

		QuestionPanel question4 = new QuestionPanel(false, 2);
		question4.setQuestion("Zachytenie výnimky v Jave");
		question4.setAnswers("automaticky opravuje vzniknutú chybu", "ohrozuje integritu programu", "automaticky zastavuje program", "umožňuje jej spracovanie a pokračovanie v programe");
		question4.setCorrectAnswer(3);

		
		test.addQuestion(question1);
		test.addQuestion(question2);
		test.addQuestion(question3);
		test.addQuestion(question4);
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
				LogonHandler.notifySubscribers();
				System.out.println("Logged in as " + UserDatabase.currentUser);
				UserEventHandler.notifyLogon();
			}

		});
		
		LoadLayerHandler.loadLayer(0);	
	}

}
