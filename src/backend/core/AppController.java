package backend.core;

import java.util.ArrayList;

import frontend.AppPanel;
import frontend.MainFrame;

public class AppController
{	/*
	* Aplikacny kontroler drzi v sebe scene a vsetky nutne globalne premenne
 	*/
	private static MainFrame frame;
	private static AppPanel panel;
	private static ArrayList<DefinedBehavior> scene = new ArrayList<DefinedBehavior>();
	
	public AppController(MainFrame frame, AppPanel panel)
	{
		AppController.frame = frame;
		AppController.panel = panel;
	}
	
	public static MainFrame getMainFrame()
	{
		return frame;
	}
	
	public static AppPanel getAppPanel()
	{
		return panel;
	}
	
	public static void addToScene(DefinedBehavior obj)
	{
		scene.add(obj);
	}
	public static int getSceneCount()
	{
		return scene.size();
	}
	
	public static <T> T getByTag(String tag) // Najdenie triedy podla tagu
	{
		for(DefinedBehavior i : scene)
			if(i.hasTag(tag))
				return (T)i;
		return null;
	}
	
}
