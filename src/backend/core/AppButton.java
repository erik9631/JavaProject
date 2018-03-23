package backend.core;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

import backend.events.LoadLayerEvent;
import backend.events.LoadLayerHandler;
import frontend.ComponentInformer;
import frontend.LabelButton;
import frontend.MainFrame;

public class AppButton extends DefinedBehavior implements LoadLayerEvent, Clickable, ComponentInformer
{
	private ArrayList<Integer> layers;
	private LabelButton guiButton;
	private String text;
	private Actions actions;
	int fontSize = 18;
	private boolean blacklisted;
	
	//Responsibility calculation
	
		
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
		MainFrame.subscribe(this);
		adaptSize();


	}

	
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
		adaptSize();

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

	@Override
	public void mainFrameResized()
	{
		adaptSize();
	}
	
	private void adaptSize()
	{
		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		System.out.println(fontSize * (height/600));
		
		if(width < height)
		{
			setFontSize(fontSize * (width/800));	
		}
		else
		{
			setFontSize(fontSize * (height/600));
		}
		/*
		 * TODO
		 */
		//Make responsive
		
		setPos(getPosX() * (width/600), getPosY() * (height/800));
	}
	
}
