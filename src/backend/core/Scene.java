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
		button1.setFontSize(30);;
		
		new TopMenuBar(0, 0, 0);
		
		//Definitions
		button1.setPos(50, 100);
		button1.getActions().setOnClickAction(() -> {
			LoadLayerHandler.loadLayer(1);
		});
		
		LoadLayerHandler.loadLayer(0);	
	}

}
