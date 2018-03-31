package frontend;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.Scrollable;

import backend.core.AppController;

public class ScrollAppPanel extends JScrollPane implements MouseWheelListener
{
	Object owner;
	JScrollBar scrollbar;
	int[] originalY;
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
	
	private int findMaxY()
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
	
	private void updateScrollbar(int updateVal)
	{
		if(originalY == null)
		{
			originalY = new int[getComponents().length];
			for(int i = 0; i < getComponents().length; i++)
				originalY[i] = getComponents()[i].getY();
			int maxY = findMaxY();
			setPreferredSize(new Dimension(getWidth(), originalY[maxY] + getComponents()[maxY].getWidth()));

		}
		

		
		Component[] components = getComponents();
		
		for(int i = 0; i < components.length; i++)
		{
			if(components[i] instanceof JScrollBar)
				continue;
			components[i].setLocation(components[i].getX(), originalY[i] - updateVal);
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e)
	{
		float percent;
		scrollbar.setValue(scrollbar.getValue() + e.getWheelRotation());
		percent = scrollbar.getValue() + scrollbar.getModel().getExtent();
		
		percent = (int) (getPreferredSize().getHeight() * (percent / 100));
		updateScrollbar((int)percent);
	}
	
	/*
	 * TODO
	 * Add scrollbar when possible
	 */

}
