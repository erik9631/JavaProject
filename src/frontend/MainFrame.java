package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import backend.core.AppController;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ComponentListener
{
	private int width, height;
	private static ArrayList<ComponentInformer>subscribers = new ArrayList<>();
	
	public static void subscribe(ComponentInformer subscriber)
	{
		subscribers.add(subscriber);
	}
	
	public MainFrame(int width, int height)
	{
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.width = width;
		this.height = height;
		setVisible(true);
		setTitle("Cisco Project");
		setSize(this.width, this.height);
		setMinimumSize(new Dimension(this.width, this.height));
		AppPanel panel = new AppPanel(width, height, Color.gray);
		add(panel);
		addComponentListener(this);
		new AppController(this, panel);
	}
	@Override
	public void componentHidden(ComponentEvent e)
	{
		
	}
	@Override
	public void componentMoved(ComponentEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentResized(ComponentEvent e)
	{
		for(ComponentInformer i : subscribers)
			i.mainFrameResized();
	}
	@Override
	public void componentShown(ComponentEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}