package backend.menu;

import java.awt.Color;
import java.awt.TextField;

import javax.swing.JTextField;

import backend.core.AppButton;
import backend.core.AppController;
import backend.core.BaseItem;
import backend.core.Database;
import backend.events.LoadLayerHandler;
import courses.Course;
import courses.Courses;
import frontend.AppPanel;

public class FeedbackMenu extends BaseItem
{

	public FeedbackMenu(boolean blackListed, int... layers)
	{
		super(layers, blackListed);
		AppPanel panel = createGuiComponent(new AppPanel(800, 600, Color.gray, AppController.getAppPanel()));
		panel.setLocation(0, 30);
		generateComponents();
	}
	private void generateComponents()
	{
		WriteField field = new WriteField(true, getGuiComponent());
		field.setPos(50, 0);
		field.setSize(400, 100);
		
		AppButton button = new AppButton("Send", true, getGuiComponent());
		button.setPos(50, 150);
		button.setFontSize(14);
		button.getActions().setOnReleaseAction(()->
		{
			try
			{
				Course course = Courses.getCourseByName(Database.currentUser.getAssignedCourse());
				course.getInstructor().sendMessage(field.getText());
				((JTextField)(field.getGuiComponent())).setText("");
				LoadLayerHandler.loadLayer(1);
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		AppButton backButton = new AppButton("Back", true, getGuiComponent());
		backButton.setFontSize(14);
		backButton.setPos(50, button.getPosY() + button.getHeight());
		backButton.getActions().setOnReleaseAction(()->
		{
			LoadLayerHandler.loadLayer(1);
		});
		
	}
	
	
}
