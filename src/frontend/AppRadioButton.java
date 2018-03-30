package frontend;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class AppRadioButton extends JRadioButton implements ResponsiveComponent
{
	int relativeX, relativeY;
	String text = "A";
	int size = 12;
	ComponentResponsibilityManager manager;
	
	public AppRadioButton(JPanel owner)
	{
		owner.add(this);
		setVisible(true);
		setSize(300, 20);
		manager = new ComponentResponsibilityManager(this);
		manager.setSizeMultiplier(0.75f);
	}
	
	@Override
	public String getFontText()
	{
		// TODO Auto-generated method stub
		return text;
	}

	@Override
	public int getFontSize()
	{
		return size;
	}

	@Override
	public String getHtmlText()
	{
		return getText();
	}

	@Override
	public int getPosX()
	{
		return relativeX;
	}

	@Override
	public int getPosY()
	{
		// TODO Auto-generated method stub
		return relativeY;
	}
	
	public void setButtonText(String text)
	{
		//this.text = text;
		manager.setFontStyle(Color.BLACK, -1);
		size = 12;
		manager.setFontSize(12);
	}

	@Override
	public Dimension getOriginSize()
	{
		return null;
	}
	
	public void setRelativePos(int x, int y)
	{
		relativeX = x;
		relativeY = y;
		manager.setRelativePos();
	}
	/*
	 * TODO
	 * Fix responsibility issues
	 */
}
