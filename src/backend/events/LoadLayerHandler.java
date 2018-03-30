package backend.events;

import java.util.ArrayList;

/*
 * 
 * OBSERVER PATTERN
 * 
 */

public final class LoadLayerHandler
{
	private LoadLayerHandler()
	{
		
	}
	private final static ArrayList<LoadLayerEvent> subscribers = new ArrayList<LoadLayerEvent>();
	
	public static final void subscribe(LoadLayerEvent subscriber)
	{
		subscribers.add(subscriber);
	}
	
	public static final void loadLayer(int layer)
	{
		for(LoadLayerEvent i : subscribers)
		{
			if(i.isBlackList() == false)
			{
				for(int j : i.getLayers())
				{
					if(j == layer)
					{
						i.loadLayer();
						break;
					}
					else
						i.unloadLayer();
				}
			}
			else
			{
				for(int j : i.getLayers())
				{
					if(j == layer)
					{
						i.unloadLayer();
						break;
					}
					else
						i.loadLayer();
				}
			}
		}
	}
}
