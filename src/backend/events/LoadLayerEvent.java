package backend.events;

public interface LoadLayerEvent
{
	public void loadLayer();
	public void unloadLayer();
	public int getLayer();
}
