package backend.core;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JComponent;

import backend.events.LoadLayerEvent;
import backend.events.LoadLayerHandler;

public class BaseItem extends DefinedBehavior implements LoadLayerEvent
{
	protected ArrayList<Integer>layers;
	protected boolean blackListed;
	private JComponent guiComponent;
	
	protected BaseItem(int[] layers, boolean blackListed)
	{
		this.layers =  new ArrayList<Integer>();
		addToList(layers);
		this.blackListed = blackListed;
		LoadLayerHandler.subscribe(this);
	}
	
	protected <T extends JComponent> T createGuiComponent(T component)
	{
		guiComponent = component;
		return component;
	}
	
	private void addToList(int[] layers)
	{
		for(int i : layers)
		{
			this.layers.add(i);
		}
	}
	
	@Override
	public void loadLayer()
	{
		guiComponent.setVisible(true);
	}

	@Override
	public void unloadLayer()
	{
		guiComponent.setVisible(false);
	}

	@Override
	public ArrayList<Integer> getLayers()
	{
		return layers;
	}

	@Override
	public boolean isBlackList()
	{
		return blackListed;
	}
	
}
