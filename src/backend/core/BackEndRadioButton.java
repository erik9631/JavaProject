package backend.core;

import javax.swing.ButtonGroup;


import frontend.AppPanel;
import frontend.AppRadioButton;
import frontend.TextLabel;

public class BackEndRadioButton extends BaseItem
{
	TextLabel label;
	AppRadioButton radioButton;

	public BackEndRadioButton(boolean blackListed, AppPanel panel ,ButtonGroup group,int ... layers)
	{
		super(layers, blackListed);
		radioButton = createGuiComponent(new AppRadioButton(panel));
		group.add(radioButton);
	}
	
	public boolean isSelected()
	{
		return radioButton.isSelected();
	}
	
	public void setPosition(int x, int y)
	{
		radioButton.setRelativePos(x, y);
		notifyOnMove();
	}
	
	public String getText()
	{
		return radioButton.getText();
	}
	
	public void setText(String text)
	{
		radioButton.setText(text);
	}
	
	/*
	 * TODO
	 * Fix Responsibility issues
	 */
	
}
