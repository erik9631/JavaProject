package backend.core;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

import backend.events.LoadLayerEvent;
import backend.events.LoadLayerHandler;
import frontend.ComponentInformer;
import frontend.LabelButton;
import frontend.MainFrame;

public class AppButton extends BaseItem implements Clickable
{
	
	/*
	 * Back end reprezetacia tlacidla. Tu sa odohrava cela logika.
	 */
	private LabelButton guiButton;
	private String text;
	private Actions actions;
	int fontSize = 18;
	public Runnable saveDatabase;
	
	public AppButton(String text, boolean blacklisted, int ... layers) // Konstruktor
	{
		super(layers, blacklisted);
		this.text = text;
		actions = new Actions();
		guiButton = createGuiComponent(new LabelButton(this));
		
	}
	/*
	 * TODO
	 * Remove duplicite code
	 */
	public AppButton(String text, boolean blacklisted, JComponent panel ,int ... layers) // Konstruktor
	{
		super(layers, blacklisted);
		this.text = text;
		actions = new Actions();
		guiButton = createGuiComponent(new LabelButton(this, panel));	

	}
	
	
	public void setFontSize(int size) //Nastavenie velkosti fontu
	{
		guiButton.setFontSize(size);
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
	
	
	public class Actions // Interna nested trieda ktora reprezentuje mozne akcie
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
	
	public void setPos(int x, int y) // Nastavenie pozicie a notifikovanie viewerov
	{
		guiButton.setRelativePos(x, y);
		notifyOnMove();
	}
	
	@Override
	public void unloadLayer() // Odcitanie sceny
	{
		guiButton.setVisible(false);
	}
	
	@Override
	public void loadLayer() // Nacitanie sceny
	{
		guiButton.setVisible(true);
	}

	@Override
	public ArrayList<Integer> getLayers() // Vrstvy na ktorych sa zobrazi alebo nezobrazi (Zavisiac od blacklisted)
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
		return blackListed;
	}
	
	/*private void adaptSize()
	{
		int width = 100;//(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int height =  100;//(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		if(width < height)
		{
			setFontSize(fontSize * (width/800));	
		}
		else
		{
			setFontSize(fontSize * (height/600));
		}

		
		setPos(getPosX() * (width/600), getPosY() * (height/800));
	}*/
}
