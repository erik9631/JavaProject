package frontend;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import backend.core.AppController;
import backend.events.LoadLayerEvent;

@SuppressWarnings("serial")
public class AppPanel extends JPanel implements LoadLayerEvent
{
	ArrayList<Integer>layers;
	boolean blacklisted = true;
	public AppPanel(int width, int height, Color color)
	{
		if(AppController.getAppPanel() != null)
			AppController.getAppPanel().add(this);
		
		setSize(width, height);
		setLayout(null);
		setVisible(true);
		setBackground(color);
	}
	
	private void addToList(int[] layers)
	{
		for(int i : layers)
			this.layers.add(i);
	}
	
	public AppPanel(int width, int height, Color color, boolean blacklisted, int ... layers)
	{
		this(width, height, color);
		addToList(layers);
	}

	@Override
	public void loadLayer()
	{
		this.setVisible(true);
	}

	@Override
	public void unloadLayer()
	{
		this.setVisible(false);
	}

	@Override
	public ArrayList<Integer> getLayers()
	{
		return layers;
	}

	@Override
	public boolean isBlackList()
	{
		return blacklisted;
	}
}
