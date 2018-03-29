package backend.core;

import javax.swing.JTextField;

import backend.events.LoadLayerHandler;
import backend.menu.TopMenuBar;
import backend.menu.WriteField;
import frontend.MainFrame;

public class Scene
{
	public static void init()
	{
		new MainFrame(800 ,600);		
		//Initialisations
		//Layer 0
		AppButton button1 = new AppButton("Login", false, 0);
		TopMenuBar menuBar = new TopMenuBar(0, 0, 0);
		WriteField username = new WriteField(false, 0); 
		WriteField password = new WriteField(false, 0);

		
		//Layer 1
		
		//Properties
		button1.setFontSize(20);
		button1.setPos(AppController.getMainFrame().getWidth()/2 - button1.getWidth()/2 + 100 , AppController.getMainFrame().getHeight()/2 - button1.getHeight()/2);
		
		//AppController.getAppPanel().add(username);
		//AppController.getAppPanel().add(password);
		username.setSize(150, 30);
		password.setSize(150, 30);
		username.setPos(button1.getPosX() - username.getWidth(), button1.getPosY() - username.getHeight()*2 - 20);
		password.setPos(username.getX(), username.getY() + username.getHeight() + 20);
		
		
		
		//Definitions
		button1.getActions().setOnClickAction(() -> {
			LoadLayerHandler.loadLayer(1);
		});
		
		LoadLayerHandler.loadLayer(0);	
	}

}
