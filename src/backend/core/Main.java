package backend.core;

import backend.events.LoadLayerEvent;
import backend.events.LoadLayerHandler;
import frontend.LabelButton;
import frontend.MainFrame;

public class Main
{
	public static void main(String args[])
	{
		new MainFrame(800 ,600);
		new AppButton(0, "Goto layer 1").getActions().setOnClickAction(()->
		{
			LoadLayerHandler.loadLayer(1);
			System.out.println("Loading layer 1");
		});
		new AppButton(1, "Goto layer 0").getActions().setOnClickAction(() -> 
		{
			LoadLayerHandler.loadLayer(0);
			System.out.println("Loading layer 0");
		});
		LoadLayerHandler.loadLayer(0);
	}
}
