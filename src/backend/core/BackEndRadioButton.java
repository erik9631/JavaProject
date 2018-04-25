package backend.core;

import javax.swing.ButtonGroup;


import frontend.AppPanel;
import frontend.AppRadioButton;
import frontend.TextLabel;

public class BackEndRadioButton extends BaseItem
{
	TextLabel label;
	AppRadioButton radioButton;
	/*
	 * Back end reprezentacia radioButtonu. Tu sa odohrava logika
	 */

	public BackEndRadioButton(boolean blackListed, AppPanel panel ,ButtonGroup group,int ... layers) // Konstuktor
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
		radioButton.setRelativePos(x, y); // Nastavenie relativnej pozicie pomocou componentManazeru
		notifyOnMove();
	}
	
	public String getText()
	{
		return radioButton.getText();
	}
	
	public void setText(String text)
	{
		radioButton.setText(text);
		setSize(475, radioButton.getHeight());
	}
	
	public void setSize(int width, int height)
	{
		radioButton.setSize(width, height);
	}
	
	/*
	 * TODO
	 * Fix Responsibility issues
	 */
	
}
