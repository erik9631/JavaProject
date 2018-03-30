package backend.menu;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;

import backend.core.AppButton;
import backend.core.BaseItem;
import backend.events.LoadLayerHandler;
import frontend.AppPanel;
import frontend.ComponentResponsibilityManager;
import frontend.ResponsiveComponent;

public class TopMenuBar extends BaseItem implements ResponsiveComponent
{
	/*
	 * Make everything responsible to screen width and size
	 * 
	 */
	
	private int spaceSize = 50;
	private int centerY = 0;
	
	private int originWidth = 800;
	private int originHeight = 30;
	AppPanel panel;
	
	private ComponentResponsibilityManager componentManager;
	
	private int fontSize = 18;
	public TopMenuBar(int x, int y, int ... layers)
	{
		super(layers, true);
		componentManager = new ComponentResponsibilityManager(this);
		componentManager.canSetRelativeWidth = true;
		panel = createGuiComponent(new AppPanel(originWidth, originHeight, Color.gray, this));
		
		//panel = new AppPanel(800, 30, Color.gray, this);
		LoadLayerHandler.subscribe(this);
		AppButton curiculum = new AppButton("Curiculums", true, panel ,0);
		AppButton tests = new AppButton("Tests", true, panel ,0);
		AppButton grades = new AppButton("Grades", true, panel, 0);
		AppButton course = new AppButton("Course Feedback", true, panel, 0);
		AppButton forums = new AppButton("Forums", true, panel, 0);
		
		//Defines
		panel.setBorder(BorderFactory.createEtchedBorder());
		panel.setBounds(0, 0, 780, 30);
		spaceSize = panel.getWidth()/(800/spaceSize);
		centerY = fontSize/2 - panel.getHeight()/2;
		
		curiculum.setPos(25, -5);
		curiculum.setFontSize(fontSize);
		
		tests.setPos(curiculum.getPosX() + spaceSize + curiculum.getWidth(), centerY);
		tests.setFontSize(fontSize);
		tests.getActions().setOnClickAction(() ->
		{
			LoadLayerHandler.loadLayer(2);
		});
		
		grades.setPos(tests.getPosX() + spaceSize + tests.getWidth(), centerY);
		grades.setFontSize(fontSize);
		
		course.setPos(grades.getPosX() + spaceSize + grades.getWidth(), centerY);
		course.setFontSize(fontSize);
		
		forums.setPos(course.getPosX() + spaceSize + course.getWidth(), centerY);
		forums.setFontSize(fontSize);		
	}
	@Override
	public String getFontText()
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setForeground(Color fg)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setText(String text)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getFontSize()
	{
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getHtmlText()
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setSize(int width, int height)
	{
		panel.setBounds(0, 0, width - 20, height);
		
	}
	@Override
	public int getPosX()
	{
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getPosY()
	{
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setLocation(int x, int y)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public Dimension getOriginSize()
	{
		// TODO Auto-generated method stub
		return new Dimension(originWidth, originHeight);
	}
	
	/*
	 * TODO
	 * Move responsive component to frontEnd
	 */
}
