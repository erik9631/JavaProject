package backend.core;


import backend.events.LoadLayerHandler;
import backend.events.ApplicationEventHandler;
import backend.menu.CourseMenu;
import backend.menu.FeedbackMenu;
import backend.menu.GradeMenu;
import backend.menu.TestMenu;
import backend.menu.TopMenuBar;
import backend.menu.WriteField;
import courses.Course;
import courses.Courses;
import frontend.MainFrame;
import tests.QuestionPanel;
import tests.Test;
import users.Instructor;
import users.Student;

public class Scene
{
	public static void init()
	{
		/*
		 * Nasa hlavna scena. Tu mame definovane vsetky objekty ktore sa realne zobrazia v programe
		 * Dalsie rozdelenie sceny pri refaktoringu.
		 * 
		 */
		new MainFrame(800 ,600);		
		/*
		 * New databse type of hash table
		 * load Students file and create student
		 * 
		 */
		
		Database database = new Database();
		int[] TopMenuBlacklist = new int[1001];
		TopMenuBlacklist[0] = 0;
		for(int i = 1, j = 1000; i < 1000; i++, j++)
			TopMenuBlacklist[i] = j;
		/*database.addUser(new Student("erik", "1234"));
		database.addUser(new Student("luke", "784"));
		database.addUser(new Student("jensen", "1478"));
		database.addUser(new Instructor("Brandon", "5555"));
		database.addUser(new Instructor("Miko", "fghj"));
		database.addUser(new Instructor("Peterson", "erta"));
		database.addUser(new Instructor("Hudson", "lkj"));*/
		new Courses(database);
		
		
		
		//Initialisations
			// Layer 0
		AppButton login = new AppButton("Login", false, 0);
		WriteField username = new WriteField(false, 0); 
		WriteField password = new WriteField(false, 0);
		
			// Layer 1
		TopMenuBar menuBar = new TopMenuBar(0, 0, TopMenuBlacklist);
		MessageBox box = new MessageBox(false, 1);
		box.setPosition(100, 100);
		
			// Layer 2
		new CourseMenu(false, 2);
		
			//Layer 3
		new TestMenu(false, 3);
			
			//Layer 4
		new FeedbackMenu(false, 4);
		
			//Layer 5
		new GradeMenu(false, database, 5);
		

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
			try
			{
				if(database.getUser(username.getText()).getPassword().equals(password.getText()))
				{
					Database.currentUser = database.getUser(username.getText());
					box.setMessageSource(Database.currentUser.getMessages());
					ApplicationEventHandler.notifyLogon();
					LoadLayerHandler.loadLayer(1);
					System.out.println(Database.currentUser.getAssignedCourse());
				}
			} catch (Exception e)
			{
				e.printStackTrace();
			}

		});
		
		LoadLayerHandler.loadLayer(0);
	}

}
