package backend.core;
import java.util.ArrayList;

import javax.swing.JPanel;

import backend.events.LoadLayerEvent;
import backend.events.LoadLayerHandler;
import frontend.LabelButton;

public class AppButton extends DefinedBehavior implements LoadLayerEvent, Clickable
{
	private ArrayList<Integer> layers;
	private LabelButton guiButton;
	private String text;
	private Actions actions;
	private boolean blacklisted;
	
	// Introdukcia noveho menovaneho typu na invokovanie dodatocnych metods
	
	private void addToList(int layers[])
	{
		for(int i = 0; i < layers.length; i++)
			this.layers.add(layers[i]);
			
	}
	
	public void setFontSize(int size)
	{
		guiButton.setFontSize(size);
	}
	
	public AppButton(String text, boolean blacklisted, JPanel panel ,int ... layers)
	{
		this(layers, text, blacklisted);
		guiButton = new LabelButton(this, panel);
		LoadLayerHandler.subscribe(this);
	}
	
	/*public AppButton(String text, boolean blacklisted, int ... layers)
	{
		guiButton = new LabelButton(this);
		initAppButton(text, blacklisted, layers);
	}*/
	
	private AppButton(int layers[], String text, boolean blacklisted)
	{
		this.layers = new ArrayList<Integer>();
		addToList(layers);
		actions = new Actions();
		this.text = text;
		LoadLayerHandler.subscribe(this);
		this.blacklisted = blacklisted;
		addTag(text);
	}
	
	public AppButton(String text, boolean blacklisted, int ... layers)
	{
		this(layers, text, blacklisted);
		guiButton = new LabelButton(this);
		LoadLayerHandler.subscribe(this);
	}
	
	
	public int getHeight()
	{
		return guiButton.getHeight();
	}
	
	public int getWidth()
	{
		return guiButton.getWidth();
	}
	
	public int getPosX()
	{
		return guiButton.getX();
	}
	
	public int getPosY()
	{
		return guiButton.getY();
	}
	
	public Actions getActions()
	{
		return actions;
	}
	
	
	public class Actions
	{
		private Runnable onClickAction;
		private Runnable onPressAction;
		private Runnable onReleaseAction;
		
		public void setOnClickAction(Runnable action)
		{
			onClickAction = action;
		}
		
		public void setOnPressAction(Runnable action)
		{
			onPressAction = action;
		}
		
		public void setOnReleaseAction(Runnable action)
		{
			onReleaseAction = action;
		}
		
		
		public void onClick()
		{
			try
			{
				onClickAction.run();				
			}
			catch(Exception e){}
		}
		
		public void onPress()
		{
			try
			{
				onPressAction.run();
			}
			catch(Exception e){}
		}
		
		public void onRelease()
		{
			try
			{
				onReleaseAction.run();	
			}
			catch(Exception e){}
		}
		
	}
	
	public void setPos(int x, int y)
	{
		guiButton.setLocation(x, y);
	}
	
	@Override
	public void unloadLayer()
	{
		guiButton.setVisible(false);
	}
	
	@Override
	public void loadLayer()
	{
		guiButton.setVisible(true);
	}

	@Override
	public ArrayList<Integer> getLayers()
	{
		return layers;
	}

	@Override
	public void onClick()
	{
		actions.onClick();
	}

	@Override
	public String getText()
	{
		return text;
	}

	@Override
	public void onPress()
	{
		actions.onPress();
	}

	@Override
	public void onRelease()
	{
		actions.onRelease();
	}

	@Override
	public boolean isBlackList()
	{
		return blacklisted;
	}
	
}
