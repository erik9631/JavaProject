package backend.menu;

import java.awt.Color;
import java.util.ArrayList;

import backend.core.AppButton;
import backend.core.AppController;
import backend.core.BaseItem;
import frontend.AppPanel;

public class CuriculMenu extends BaseItem
{
	
	private ArrayList<AppButton> buttons = new ArrayList<AppButton>();

	public CuriculMenu(boolean blackListed, int... layers)
	{
		super(layers, blackListed);
		AppPanel panel = createGuiComponent(new AppPanel(800, 600, Color.gray, AppController.getAppPanel()));
		panel.setLocation(0, 30);
		generateButtons();
		
	}
	
	private void generateButtons()
	{
		AppButton button = new AppButton("Chapter 1", true, getGuiComponent(), 0);
		button.setFontSize(16);
		buttons.add(button);
		
		button = new AppButton("1.1", true, getGuiComponent(), 0);
		button.setFontSize(14);
		buttons.add(button);
		
		button = new AppButton("1.1.1", true, getGuiComponent(), 0);
		button.setFontSize(12);
		buttons.add(button);
		
		button = new AppButton("Chapter 2", true, getGuiComponent(), 0);
		button.setFontSize(16);
		buttons.add(button);
		
		button = new AppButton("2.1", true, getGuiComponent(), 0);
		button.setFontSize(14);
		buttons.add(button);
		
		button = new AppButton("2.2", true, getGuiComponent(), 0);
		button.setFontSize(14);
		buttons.add(button);
		
		button = new AppButton("2.3", true, getGuiComponent(), 0);
		button.setFontSize(14);
		buttons.add(button);
		
		button = new AppButton("2.3.1", true, getGuiComponent(), 0);
		button.setFontSize(12);
		buttons.add(button);
		
		
		alignButtons();

	}
	
	private void alignButtons()
	{
		for(int i = 0; i < buttons.size(); i++)
		{
			int dotCount = countChars(buttons.get(i).getText(), '.');
			if(i == 0)
				buttons.get(i).setPos((20 * dotCount) + 15, i * buttons.get(i).getHeight());
			else
				buttons.get(i).setPos((20 * dotCount) + 15, buttons.get(i-1).getPosY() + buttons.get(i).getHeight());

		}
	}
	
	private int countChars(String val, char c)
	{
		int counter = 0;
		for(int i = 0; i < val.length(); i++)
			if(val.charAt(i) == c)
				counter++;
		return counter;
	}
	
}
