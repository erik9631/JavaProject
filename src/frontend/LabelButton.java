package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import backend.core.AppController;
import backend.core.Clickable;


@SuppressWarnings("serial")
public class LabelButton extends JLabel implements MouseListener, ResponsiveComponent
{
	private String text;
	
	private ComponentResponsibilityManager componentManager; 
	private boolean entered = false;
	private int size;
	private Clickable clickable;
	int relativeX, relativeY;
	/*
	 * Front end reprezentacia textoveho tlacidla
	 */
	public LabelButton(Clickable obj)
	{
		componentManager = new ComponentResponsibilityManager(this);
		text = obj.getText();
		this.clickable = obj;
		AppController.getAppPanel().add(this);
		initLabelButton();
	}
	
	/*
	 * TODO
	 * Remove duplicate code from constructor
	 */
	
	public void setRelativePos(int x, int y)
	{
		this.relativeX = x;
		this.relativeY = y;
		componentManager.setRelativePos();
	}
	
	private final void initLabelButton()
	{ 
		clickable.getText();
		setVisible(true);
		addMouseListener(this);
		setLocation(100, 100);
		componentManager.setFontStyle(Color.BLUE, 2);;
		componentManager.setFontSize(30);
	}
	
	public LabelButton(Clickable obj, JComponent panel)
	{
		componentManager = new ComponentResponsibilityManager(this);
		text = obj.getText();
		this.clickable = obj;
		panel.add(this);
		initLabelButton();
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		clickable.onClick();
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		entered = true;
		componentManager.setFontStyle(Color.white, 2);
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		entered = false;
		componentManager.setFontStyle(Color.blue, 2);
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		clickable.onPress();
		componentManager.setFontStyle(new Color(100, 0, 100), 2);
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		clickable.onRelease();
		if(entered == false)
			componentManager.setFontStyle(Color.blue, 2);
		else
			componentManager.setFontStyle(Color.white, 2);
	}
	
	public void setFontSize(int size)
	{
		this.size = size;
		componentManager.setFontSize(size);
	}

	@Override
	public String getFontText()
	{
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

	@Override
	public Dimension getOriginSize()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
