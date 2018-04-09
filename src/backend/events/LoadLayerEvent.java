package backend.events;

import java.util.ArrayList;

public interface LoadLayerEvent // Observer visitor pre LayerEvent. Sluzi na nacitavanie scen. Vyuzivame polymorfyzmus
{
	public void loadLayer();
	public void unloadLayer();
	public ArrayList<Integer> getLayers();
	public boolean isBlackList();
}
