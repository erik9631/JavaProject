package frontend;

import java.awt.Color;

import backend.core.AppController;
public class ComponentResponsibilityManager implements ComponentInformer
{
	//private String stylishText;
	ResponsiveComponent component;
	public boolean canSetRelativeHeight = false;
	public boolean canSetRelativeWidth = false;
	
	public ComponentResponsibilityManager(ResponsiveComponent component)
	{
		MainFrame.subscribe(this);
		component.getFontText();
		this.component = component;
	}
	
	public void setFontStyle(Color color, int style)
	{
		component.setForeground(color);
		switch(style)
		{
			case -1:
				component.setText(component.getFontText());
			case 0:
				component.setText("<html><b style=\"font-size: " + Integer.toString(component.getFontSize()) + "\">" + component.getFontText() + "</b></html>");
			case 1:
				component.setText("<html><i style=\"font-size: " + Integer.toString(component.getFontSize()) + "\">" + component.getFontText() + "</i></html>");
			case 2:
				component.setText("<html><u style=\"font-size: " + Integer.toString(component.getFontSize()) + "\">" + component.getFontText() + "</u></html>");
		}
	}
	
	public void setFontSize(int size)
	{
		//Sets html font size using string builder and updates the display
		component.setSize((int) ( (size * component.getFontText().length()) * 0.65 ), size * 2);
		StringBuilder builder = new StringBuilder();
		builder.append(component.getHtmlText());
		int first = builder.indexOf("font-size: ") + ("font-size: ").length();
		int last = builder.indexOf("\"", first);
		builder.replace(first, last, Integer.toString(component.getFontSize()));
		component.setText(builder.toString());
	}

	@Override
	public void mainFrameResized()
	{
		setRelativePos();
		if(canSetRelativeHeight == true)
			setRelativeHeight();
		if(canSetRelativeWidth == true)
			setRelativeWidth();
	}
	
	public void setRelativePos()
	{
		float frameHeight = AppController.getMainFrame().getHeight();
		float frameWidth = AppController.getMainFrame().getWidth();
		component.setLocation((int) ( (frameWidth/800) * component.getPosX() ), (int)( (frameHeight/600) * component.getPosY() ) );
	}
	
	public void setRelativeWidth()
	{
		float frameWidth = AppController.getMainFrame().getWidth();
		
		component.setSize( (int) ((frameWidth/800) * component.getOriginSize().width), component.getOriginSize().height);
	}
	
	public void setRelativeHeight()
	{
		float frameHeight = AppController.getMainFrame().getHeight();
		
		component.setSize( component.getOriginSize().width, (int) ((frameHeight/600) * component.getOriginSize().height));
	}
	
	
}