package backend.events;

import java.util.ArrayList;

public interface LoadLayerEvent
{
	public void loadLayer();
	public void unloadLayer();
	public ArrayList<Integer> getLayers();
	public boolean isBlackList();
}
