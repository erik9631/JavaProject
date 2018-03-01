package frontend;

import java.awt.Color;

import javax.swing.ActionMap;
import javax.swing.JPanel;

import sun.java2d.pipe.AAShapePipe;

@SuppressWarnings("serial")
public class AppPanel extends JPanel
{
	public AppPanel(int width, int height, Color color)
	{
		setSize(width, height);
		setLayout(null);
		setVisible(true);
		setBackground(color);
	}
}
