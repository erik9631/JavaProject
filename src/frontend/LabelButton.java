package frontend;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import backend.core.Clickable;


@SuppressWarnings("serial")
public class LabelButton extends JLabel implements MouseListener
{
	private String text = "crap";
	
	//Font properties
	private String display = text;
	private boolean entered = false;
	private int size = 12;
	private Clickable clickable;
	
	public LabelButton(Clickable obj)
	{
		this.clickable = obj;
		text = obj.getText();
		setVisible(true);
		addMouseListener(this);
		AppController.getAppPanel().add(this);
		setLocation(100, 100);
		setSize(100, 100);
		setFontStyle(Color.BLUE, 2);
		setFontSize(30);
	}
	
	public void setFontSize(int size)
	{
		setSize((int) ( (size * text.length()) * 0.6 ), 100);
		this.size = size;
		setFontSize();
	}
	
	public void setDisplay(String display)
	{
		this.display = display;
		setText(display);
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
		setFontStyle(Color.white, 2);
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		entered = false;
		setFontStyle(Color.blue, 2);
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		clickable.onPress();
		setFontStyle(new Color(100, 0, 100), 2);
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		clickable.onRelease();
		if(entered == false)
			setFontStyle(Color.blue, 2);
		else
			setFontStyle(Color.white, 2);
	}
	
	public void setFontStyle(Color color, int style)
	{
		setForeground(color);
		switch(style)
		{
			case -1:
				setDisplay(text);
			case 0:
				setDisplay("<html><b style=\"font-size: " + Integer.toString(size) + "\">" + text + "</b></html>");
			case 1:
				setDisplay("<html><i style=\"font-size: " + Integer.toString(size) + "\">" + text + "</i></html>");
			case 2:
				setDisplay("<html><u style=\"font-size: " + Integer.toString(size) + "\">" + text + "</u></html>");
		}
	}
	
	private void setFontSize()
	{
		//Sets html font size using string builder and updates the display
		StringBuilder builder = new StringBuilder();
		builder.append(display);
		int first = builder.indexOf("font-size: ") + ("font-size: ").length();
		int last = builder.indexOf("\"", first);
		builder.replace(first, last, Integer.toString(size));
		setDisplay(builder.toString());
	}
	
}
