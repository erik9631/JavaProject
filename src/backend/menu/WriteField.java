package backend.menu;

import java.awt.Dimension;
import java.nio.channels.SelectableChannel;

import backend.core.BaseItem;
import backend.events.LoadLayerEvent;
import frontend.AppTextField;

public class WriteField extends BaseItem implements LoadLayerEvent
{
	private AppTextField field;
	/*
	 * Back end reprezentacia textFieldu
	 */
	public WriteField(boolean blackListed, int... layers)
	{
		super(layers, blackListed);
		field = createGuiComponent(new AppTextField());
	}
	
	public void setPos(int x, int y)
	{
		field.setRelativePos(x, y);
	}
	
	public void setSize(int width, int height)
	{
		field.setSize(new Dimension(width, height));
	}
	
	public String getText()
	{
		return field.getText();
	}
	
	public int getWidth()
	{
		return field.getWidth();
	}
	
	public int getHeight()
	{
		return field.getHeight();
	}
	
	public int getX()
	{
		return field.getX();
	}
	
	public int getY()
	{
		return field.getY();
	}
	
}
