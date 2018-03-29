package frontend;

import java.awt.Dimension;
import javax.swing.JTextField;

import backend.core.AppController;

public class AppTextField extends JTextField implements ResponsiveComponent
{
	int relativeX, relativeY;
	ComponentResponsibilityManager manager;
	public AppTextField()
	{
		manager = new ComponentResponsibilityManager(this);
		AppController.getAppPanel().add(this);
	}
	
	public void setRelativePos(int x, int y)
	{
		relativeX = x;
		relativeY = y;
		manager.setRelativePos();
	}
	@Override
	public String getFontText()
	{
		return null;
	}

	@Override
	public int getFontSize()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getHtmlText()
	{
		// TODO Auto-generated method stub
		return null;
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
		return null;
	}

}
