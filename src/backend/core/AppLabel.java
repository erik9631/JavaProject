package backend.core;

import javax.swing.JComponent;
import javax.swing.JPanel;

import frontend.TextLabel;

public class AppLabel extends BaseItem
{

	TextLabel label;
	/*
	 * 
	 * Reprezentacia textu v backende. Tu sa odohrava logika
	 * 
	 */
	public AppLabel(boolean blackListed, JComponent panel, int ... layers) // Konstruktor
	{
		super(layers, blackListed);
		label = createGuiComponent(new TextLabel(panel));
	}
	/*
	 * Ostatne metody su settery.
	 */
	
	public void setPosition(int x, int y)
	{
		label.setRelativePos(x, y);
		notifyOnMove();
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
