package backend.core;

import backend.events.LoadLayerHandler;
import backend.menu.TopMenuBar;
import frontend.MainFrame;

public class Scene
{
	public static void init()
	{
		new MainFrame(800 ,600);		
		//Initialisations
		AppButton button1 = new AppButton("Login", false, 0);
		button1.setFontSize(34);
		//AppButton button2 = new AppButton("Goto layer 0", false, 1);
		//AppButton button3 = new AppButton("Goto layer 0", false, 1);
		
		new TopMenuBar(0, 0, 0);
		
		//Definitions
		button1.setPos(0, 0);
		button1.getActions().setOnClickAction(() -> {
			LoadLayerHandler.loadLayer(1);
		});
		
		/*button2.setPos(100, 0);
		button2.getActions().setOnClickAction(() -> 
		{
			LoadLayerHandler.loadLayer(0);
		});
		
		button3.setPos(300, 0);
		button3.getActions().setOnClickAction(() -> 
		{
			LoadLayerHandler.loadLayer(0);
		});*/
		
		LoadLayerHandler.loadLayer(0);	
	}

}
