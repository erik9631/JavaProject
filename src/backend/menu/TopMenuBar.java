package backend.menu;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;

import backend.core.AppButton;
import backend.core.AppController;
import backend.core.MenuInformer;
import backend.core.Resizable;
import backend.events.LoadLayerEvent;
import backend.events.LoadLayerHandler;
import frontend.AppPanel;

public class TopMenuBar extends MenuInformer implements LoadLayerEvent
{
	/*
	 * Make everything responsible to screen width and size
	 * 
	 */
	
	private int spaceSize = 50;
	private int centerY = 0;
	AppPanel panel;
	
	private int fontSize = 18;
	public TopMenuBar(int x, int y, int ... layers)
	{
		addToLayerList(layers);
		panel = new AppPanel(800, 30, Color.gray, this);
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
		
		grades.setPos(tests.getPosX() + spaceSize + tests.getWidth(), centerY);
		grades.setFontSize(fontSize);
		
		course.setPos(grades.getPosX() + spaceSize + grades.getWidth(), centerY);
		course.setFontSize(fontSize);
		
		forums.setPos(course.getPosX() + spaceSize + course.getWidth(), centerY);
		forums.setFontSize(fontSize);		
	}

	
	@Override
	public void loadLayer()
	{
		panel.setVisible(true);
	}
	@Override
	public void unloadLayer()
	{
		panel.setVisible(false);
	}
	
	@Override
	public ArrayList<Integer> getLayers()
	{
		return layers;
	}
	
	@Override
	public boolean isBlackList()
	{
		return blacklisted;
	}
	
	@Override
	public void onResize()
	{
		
	}
}
