package backend.core;

import java.util.ArrayList;


public abstract class MenuInformer extends DefinedBehavior implements Resizable
{
	protected ArrayList<Integer>layers;
	protected boolean blacklisted = true;
	
	public MenuInformer()
	{
		layers = new ArrayList<Integer>();
	}
	
	protected void addToLayerList(int[] layers)
	{
		for(int i : layers)
			this.layers.add(i);
	}
	
	public void onResize(){};
}
