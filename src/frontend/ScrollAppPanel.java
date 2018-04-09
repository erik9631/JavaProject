package frontend;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.Scrollable;

import backend.core.AppController;

public class ScrollAppPanel extends JScrollPane implements MouseWheelListener, ComponentListener
{
	/*
	 * Panel ktory umoznuje posuvanie pomocou kurzora. 
	 * Scrollbal sme implementovali sami
	 */
	Object owner;
	JScrollBar scrollbar;
	int[] originalY; // Originalna pozicia pridanych componentov
	public ScrollAppPanel(int width, int height, Color color, Object owner)
	{

		this.owner = owner;
		AppController.getAppPanel().add(this);
		setSize(width, height);
		setLayout(null);
		setVisible(true);
		setSize(width, height);
		setBackground(color);
		setPreferredSize(new Dimension(width, height));
		
		scrollbar = new JScrollBar();
		scrollbar.setSize(20, height);
		scrollbar.setVisible(true);
		scrollbar.setLocation(width - scrollbar.getWidth(), 0);
		scrollbar.setUnitIncrement(1);
		scrollbar.setVisibleAmount(1);
		add(scrollbar);
		addMouseWheelListener(this);
	}
	
	private int findMaxY() // Najdenie najnizsieho komponentu. Podla neho urcujeme spodny limit skrolovania
	{
		int largest = 0;
		for(int i = 0; i < originalY.length; i++)
		{
			if(i != 0)
			{
				if(originalY[i] > originalY[largest])
					largest = i;
			}
			else
				largest = i;
		}
		return largest;
			
	}
	
	
	public void updateComponents() // Pridanie alebo odobranie komponentov a nastavenie ich originalnej pozicie
	{
		originalY = new int[getComponents().length];
		for(int i = 0; i < getComponents().length; i++)
		{
			originalY[i] = getComponents()[i].getY();
			//System.out.println("Y: " + originalY[i]);
		}
		int maxY = findMaxY();
		setPreferredSize(new Dimension(getWidth(), originalY[maxY] + getComponents()[maxY].getWidth()));
	}
	
	private void updateScrollbar(int updateVal) // Posun komponentov pri skrolovani
	{
		
		Component[] components = getComponents();	
		
		if(originalY == null)
			updateComponents(); // Tato funckia bude zmazana v dalsej verzii programu a nahdradena observer/visitor
		
		for(int i = 0; i < components.length; i++)
		{
			if(components[i] instanceof JScrollBar)
				continue;
			components[i].setLocation(components[i].getX(), originalY[i] - updateVal);
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) // Komponenty posuvane ak pohneme rollerom na mysi
	{
		float percent;
		scrollbar.setValue(scrollbar.getValue() + e.getWheelRotation());
		percent = scrollbar.getValue() + scrollbar.getModel().getExtent();
		
		percent = (int) (getPreferredSize().getHeight() * (percent / 100));
		updateScrollbar((int)percent);
	}

	@Override
	public void componentHidden(ComponentEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0)
	{
		updateComponents(); // Komponenty obnovime ak nastane zmena v pozicii
	}

	@Override
	public void componentResized(ComponentEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

}
