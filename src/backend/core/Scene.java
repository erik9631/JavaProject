package backend.core;

import backend.events.LoadLayerHandler;
import frontend.MainFrame;

public class Scene
{
	public static void init()
	{
		new MainFrame(800 ,600);
		new AppButton(0, "Goto layer 1").getActions().setOnClickAction(()->
		{
			AppButton crap = DefinedBehavior.getLast();
			LoadLayerHandler.loadLayer(1);
		});
		new AppButton(1, "Goto layer 0").getActions().setOnClickAction(() -> 
		{
			LoadLayerHandler.loadLayer(0);
			System.out.println("Loading layer 0");
		});
		LoadLayerHandler.loadLayer(0);	
	}
}
