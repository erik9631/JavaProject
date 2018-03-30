package backend.core;

import javax.swing.JPanel;

import frontend.TextLabel;

public class AppLabel extends BaseItem
{

	TextLabel label;
	
	public AppLabel(boolean blackListed, JPanel panel, int ... layers)
	{
		super(layers, blackListed);
		label = createGuiComponent(new TextLabel(panel));
	}
	
	public void setPosition(int x, int y)
	{
		label.setRelativePos(x, y);
	}
	
	public void setSize(int size)
	{
		label.setFontSize(size);
	}
	
	public void setText(String text, int style)
	{
		label.setLabelText(text, style);
	}
	

}
