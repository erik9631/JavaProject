package frontend;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TextLabel extends JLabel implements ResponsiveComponent
{
	ComponentResponsibilityManager manager;
	int relativeX, relativeY;
	int width, height;
	int fontSize;
	String text = "asdasdasd";
	
	public TextLabel(JPanel panel)
	{
		panel.add(this);
		manager = new ComponentResponsibilityManager(this);
		manager.setRelativePos();
	}
	@Override
	public String getFontText()
	{
		return text;
	}
	@Override
	public int getFontSize()
	{
		return fontSize;
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
	@Override
	public Dimension getOriginSize()
	{
		// TODO Auto-generated method stub
		return new Dimension(width, height);
	}
	
	public void setRelativePos(int x, int y)
	{
		relativeX = x;
		relativeY = y;
		manager.setRelativePos();
	}
	
	public void setFontSize(int size)
	{
		fontSize = size;
		manager.setFontSize(size);
	}
	
	public void setLabelText(String text, int style)
	{
		this.text = text;
		manager.setFontStyle(Color.black, style);
	}
}
