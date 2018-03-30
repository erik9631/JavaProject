package backend.core;

import javax.swing.ButtonGroup;

import org.omg.PortableServer.ServantRetentionPolicyOperations;

import frontend.AppPanel;
import frontend.AppRadioButton;
import frontend.LabelButton;
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
	
	public void setPosition(int x, int y)
	{
		radioButton.setRelativePos(x, y);
	}
	
	public void isVisible()
	{
		System.out.println(guiComponent.isVisible());
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
