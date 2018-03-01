package backend.events;

import java.util.ArrayList;

/*
 * 
 * OBSERVER PATTERN
 * 
 */

public class LoadLayerHandler
{
	private static ArrayList<LoadLayerEvent> subscribers = new ArrayList<LoadLayerEvent>();
	
	public static void subscribe(LoadLayerEvent subscriber)
	{
		subscribers.add(subscriber);
	}
	
	public static void loadLayer(int layer)
	{
		for(LoadLayerEvent i : subscribers)
		{
			if(i.getLayer() == layer)
				i.loadLayer();
			else
				i.unloadLayer();
		}
	}
}
