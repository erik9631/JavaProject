package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import backend.core.AppController;
import backend.events.UserEventHandler;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ComponentListener, WindowListener
{
	private int width, height;
	private static ArrayList<ComponentInformer>subscribers = new ArrayList<>();
	/*
	 * Hlavne okno aplikacie.
	 * Zaroven je aj observer kedze notifikuje objekty o zmene sirky a vysky
	 */
	
	public static void subscribe(ComponentInformer subscriber)
	{
		subscribers.add(subscriber);
	}
	
	public MainFrame(int width, int height)
	{
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Defaultna operacia po zruseni okna
		addWindowListener(this);
		this.width = width;
		this.height = height;
		setVisible(true);
		setTitle("Cisco Project");
		setSize(this.width, this.height);
		setMinimumSize(new Dimension(this.width, this.height));
		AppPanel panel = new AppPanel(width, height, Color.gray); // Hlavny panel aplikacie
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

	@Override
	public void windowActivated(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		UserEventHandler.notifyOnExit();
	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}