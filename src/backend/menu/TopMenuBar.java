package backend.menu;

import java.awt.Color;

import javax.swing.BorderFactory;

import backend.core.AppButton;
import backend.core.DefinedBehavior;
import frontend.AppPanel;

public class TopMenuBar extends DefinedBehavior
{
	private int spaceSize = 50;
	private int centerY = 0;
	
	private int fontSize = 18;
	public TopMenuBar(int x, int y)
	{
		AppPanel topBar = new AppPanel(800, 30, Color.gray);
		AppButton curiculum = new AppButton("Curiculums", true, topBar ,0);
		AppButton tests = new AppButton("Tests", true, topBar ,0);
		AppButton grades = new AppButton("Grades", true, topBar, 0);
		AppButton course = new AppButton("Course Feedback", true, topBar, 0);
		AppButton forums = new AppButton("Forums", true, topBar, 0);
		
		//Defines
		topBar.setBorder(BorderFactory.createEtchedBorder());
		topBar.setBounds(0, 0, 780, 30);
		spaceSize = topBar.getWidth()/(800/spaceSize);
		centerY = fontSize/2 - topBar.getHeight()/2;
		
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
}
