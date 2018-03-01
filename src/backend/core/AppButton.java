package backend.core;
import backend.events.LoadLayerEvent;
import backend.events.LoadLayerHandler;
import frontend.LabelButton;

public class AppButton extends DefinedBehavior implements LoadLayerEvent, Clickable
{
	int layer;
	private LabelButton GuiButton;
	private String text;
	private Actions actions;
	
	
	// Introdukcia noveho menovaneho typu na invokovanie dodatocnych metods
	
	public AppButton(int layer, String text)
	{
		actions = new Actions();
		this.text = text;
		this.layer = layer;
		GuiButton = new LabelButton(this);
		LoadLayerHandler.subscribe(this);
		
	}
	
	public AppButton(int layer, String text, int x, int y)
	{
		
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
		GuiButton.setLocation(x, y);
	}
	
	@Override
	public void unloadLayer()
	{
		GuiButton.setVisible(false);
	}
	
	@Override
	public void loadLayer()
	{
		GuiButton.setVisible(true);
	}

	@Override
	public int getLayer()
	{
		return layer;
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
	
}
