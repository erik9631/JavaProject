package frontend;

import java.awt.Color;

import javax.swing.ActionMap;
import javax.swing.JPanel;

import sun.java2d.pipe.AAShapePipe;

public class AppPanel extends JPanel
{
	MainFrame frame;
	public AppPanel(int width, int height, Color color)
	{
		AppControler.panel = this;
		setSize(width, height);
		setLayout(null);
		setVisible(true);
		setBackground(color);
	}
}
