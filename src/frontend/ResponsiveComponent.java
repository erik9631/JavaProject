package frontend;

import java.awt.Color;
import java.awt.Dimension;

public interface ResponsiveComponent
{
	public String getFontText();
	public void setForeground(Color fg);
	public void setText(String text);
	public int getFontSize();
	public String getHtmlText();
	public void setSize(int width, int height);
	public int getPosX();
	public int getPosY();
	public void setLocation(int x, int y);
	public Dimension getOriginSize();
	
}
