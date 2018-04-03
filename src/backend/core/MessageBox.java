package backend.core;

import java.awt.Color;
import java.util.ArrayList;

import backend.menu.LogonEvent;
import backend.menu.LogonHandler;
import frontend.ScrollAppPanel;

public class MessageBox extends BaseItem implements LogonEvent
{
	ScrollAppPanel panel;

	public MessageBox(boolean blackListed, int ... layers)
	{
		super(layers, blackListed);
		panel = createGuiComponent(new ScrollAppPanel(600, 400, Color.white, this));
		LogonHandler.subscribe(this);
	}
	
	public void loadMessages()
	{
		int[] layers = new int[getLayers().size()];
		int counter = 0;
		for(Integer j : getLayers())
		{
			layers[counter] = j;
			counter++;
		}	
		
		counter = 0;
		
		for(String i : UserDatabase.currentUser.getMessages())
		{					
			AppLabel label = new AppLabel(blackListed, panel, layers);
			label.setText(i, 0);
			label.setSize(12);
			label.setPosition(0, counter * 12);
			counter++;
		}
		panel.updateComponents();
	}
	
	public void setPosition(int x, int y)
	{
		panel.setLocation(x, y);
	}

	@Override
	public void onLogon()
	{
		loadMessages();
	}

	@Override
	public void onLogout()
	{
		// TODO Auto-generated method stub
		
	}

}
