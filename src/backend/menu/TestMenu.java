package backend.menu;

import java.awt.Color;
import java.util.ArrayList;

import backend.core.AppButton;
import backend.core.AppController;
import backend.core.BaseItem;
import backend.core.Database;
import backend.events.LoadLayerHandler;
import backend.events.ApplicationEvent;
import backend.events.ApplicationEventHandler;
import courses.Course;
import courses.Courses;
import frontend.AppPanel;
import tests.ITest;

public class TestMenu extends BaseItem implements ApplicationEvent
{
	
	private ArrayList<AppButton> buttons;
	
	public TestMenu(boolean blackListed, int... layers)
	{
		super(layers, blackListed);
		AppPanel panel = createGuiComponent(new AppPanel(800, 600, Color.gray, AppController.getAppPanel()));
		panel.setLocation(0, 30);
		buttons = new ArrayList<AppButton>();
		ApplicationEventHandler.subscribe(this);
	}
	
	private void generateTestButtons()
	{
		getGuiComponent().removeAll();
		buttons.clear();
		Course course;
		try
		{
			course = Courses.getCourseByName(Database.currentUser.getAssignedCourse());
			// Test Buttons
			for(ITest i : course.getTests())
			{
				AppButton button = new AppButton(i.getTest().getName(), false, getGuiComponent());
				button.getActions().setOnReleaseAction( ()->
				{
					LoadLayerHandler.loadLayer(i.getTestId());
				});
				button.setFontSize(16);
				buttons.add(button);
			}
		} 
		catch (ClassNotFoundException e)
		{
			
		}
		
		AppButton button = new AppButton("Back", false, getGuiComponent());
		button.setFontSize(18);
		button.getActions().setOnReleaseAction(()->
		{
			LoadLayerHandler.loadLayer(1);
		});
		buttons.add(button);
		alignButtons();
			
	}
	
	private void alignButtons()
	{
		for(int i = 0; i < buttons.size(); i++)
		{
			buttons.get(i).setPos(50, i * buttons.get(i).getHeight());
		}
	}

	@Override
	public void onTestCompleted()
	{
		
	}

	@Override
	public void onLogOn()
	{
		generateTestButtons();
	}

	@Override
	public void onClose()
	{
		
	}

	@Override
	public void onReassign()
	{
		generateTestButtons();
	}
	
}
