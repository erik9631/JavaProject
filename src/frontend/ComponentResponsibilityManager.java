package frontend;

import java.awt.Color;

import backend.core.AppController;
public class ComponentResponsibilityManager implements ComponentInformer
{
	//private String stylishText;
	ResponsiveComponent component;
	public boolean canSetRelativeHeight = false;
	public boolean canSetRelativeWidth = false;
	private float sizeMultiplier = 0.70f;
	
	/*
	 * Manazer ktory riesi responsibilitu grafickych prvkov aplikacie
	 */
	
	public ComponentResponsibilityManager(ResponsiveComponent component)
	{
		MainFrame.subscribe(this); // Je visitorom hlavneho okna a reaguje na zmenu
		component.getFontText();
		this.component = component;
	}
	
	public void setSizeMultiplier(float multiplier)
	{
		sizeMultiplier = multiplier; // Percentualna tolerancia na zmenu vo velkosti (Sluzi na jemne ladenie)
	}
	
	public void setFontStyle(Color color, int style) // Nastavenie stylu fontu cez html a css
	{
		component.setForeground(color);
		switch(style)
		{
			case -1:
				component.setText("<html><font style=\"font-size: " + Integer.toString(component.getFontSize()) + "\">" + component.getFontText() + "</font></html>");
				break;
			case 0:
				component.setText("<html><b style=\"font-size: " + Integer.toString(component.getFontSize()) + "\">" + component.getFontText() + "</b></html>");
				break;
			case 1:
				component.setText("<html><i style=\"font-size: " + Integer.toString(component.getFontSize()) + "\">" + component.getFontText() + "</i></html>");
				break;
			case 2:
				component.setText("<html><u style=\"font-size: " + Integer.toString(component.getFontSize()) + "\">" + component.getFontText() + "</u></html>");
				break;

		}
	}
	
	public void setFontSize(int size) // nastavenie velkosti fontu. Cez stringbuilder upravujeme html
	{
		//Sets html font size using string builder and updates the display
		component.setSize((int) ( (component.getFontSize() * component.getFontText().length()) * sizeMultiplier ), component.getFontSize() * 2);
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
	
	public void setRelativePos() // Nastavenie relativnej pozicie zavisiac od originalnej
	{
		float frameHeight = AppController.getMainFrame().getHeight();
		float frameWidth = AppController.getMainFrame().getWidth();
		component.setLocation((int) ( (frameWidth/800) * component.getPosX() ), (int)( (frameHeight/600) * component.getPosY() ) );
	}
	
	public void setRelativeWidth() // Nastavenie relativnej sirky zavisiac od originalnej
	{
		float frameWidth = AppController.getMainFrame().getWidth();
		
		component.setSize( (int) ((frameWidth/800) * component.getOriginSize().width), component.getOriginSize().height);
	}
	
	public void setRelativeHeight() // Nastavenie relativnej vysky zavisiac od originalnej
	{
		float frameHeight = AppController.getMainFrame().getHeight();
		
		component.setSize( component.getOriginSize().width, (int) ((frameHeight/600) * component.getOriginSize().height));
	}
	
	
}
