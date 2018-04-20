package backend.menu;

import java.awt.Color;
import java.security.acl.Owner;
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
import frontend.LabelButton;
import tests.ITest;

public class CourseMenu extends BaseItem
{
	ArrayList<AppButton> buttons;
	public CourseMenu(boolean blackListed, int... layers)
	{
		super(layers, blackListed);
		AppPanel panel = createGuiComponent(new AppPanel(800, 600, Color.gray, AppController.getAppPanel()));
		panel.setLocation(0, 30);
		buttons = new ArrayList<AppButton>();
		generateCourseButtons();
	}
	
	private void generateCourseButtons()
	{
		for(Course i : Courses.getCourses())
		{
			AppButton button = new AppButton(i.getCourseName(), true, getGuiComponent());
			button.setFontSize(14);
			buttons.add(button);
			button.getActions().setOnReleaseAction( () -> 
			{
				Database.currentUser.assignToCourse(i);
				ApplicationEventHandler.notifyOnReassign();
				i.getInstructor().sendMessage("User " + Database.currentUser.getUsername() + " has been added to your course");
			});
		}
		// Set position
		for(int i = 0; i < buttons.size(); i++)
			buttons.get(i).setPos(50, i * buttons.get(i).getHeight());
		
		AppButton button = new AppButton("Back", true, getGuiComponent());
		button.setFontSize(16);
		button.setPos(50, buttons.size() * button.getHeight());
		button.getActions().setOnReleaseAction( ()->
		{
			LoadLayerHandler.loadLayer(1);
			ApplicationEventHandler.notifyOnReassign();
		});
		
		
	}
}
