package frontend;

import java.awt.Color;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame
{
	private int width, height;
	public MainFrame(int width, int height)
	{
		this.width = width;
		this.height = height;
		setVisible(true);
		setTitle("Cisco Project");
		setSize(this.width, this.height);
		AppPanel panel = new AppPanel(width, height, Color.gray);
		add(panel);
		new AppController(this, panel);
	}
}