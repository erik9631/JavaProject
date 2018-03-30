package tests;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.JPanel;

import backend.core.AppLabel;
import backend.core.BackEndRadioButton;
import backend.core.BaseItem;
import frontend.AppPanel;

public class QuestionPanel extends BaseItem
{
	private AppPanel testPanel;
	private AppLabel label;
	private ButtonGroup group;
	private int correctAnswer;
	
	BackEndRadioButton[] radioButtons;
	

	
	public QuestionPanel(boolean blackListed, int ... layers)
	{
		super(layers, blackListed);
		radioButtons = new BackEndRadioButton[4];
		testPanel = createGuiComponent(new AppPanel(500, 150, Color.DARK_GRAY, this));
		testPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		
		
		label = new AppLabel(blackListed, testPanel, layers);
		label.setPosition(10, 10);
		label.setText("This is the first test question", -1);
		label.setSize(12);
		
		
		group = new ButtonGroup();
		
		radioButtons[0] = new BackEndRadioButton(blackListed, testPanel, group, layers);
		radioButtons[1] = new BackEndRadioButton(blackListed, testPanel, group, layers);
		radioButtons[2] = new BackEndRadioButton(blackListed, testPanel, group, layers);
		radioButtons[3] = new BackEndRadioButton(blackListed, testPanel, group, layers);
		
		radioButtons[0].setPosition(50,50);
		radioButtons[1].setPosition(50,70);
		radioButtons[2].setPosition(50,90);
		radioButtons[3].setPosition(50,110);
	}
	
	public ButtonModel getSelection()
	{
		return group.getSelection();
	}
	
	public ArrayList<AbstractButton> getButtons()
	{
		ArrayList<AbstractButton> buttons = Collections.list(group.getElements());
		return buttons;
	}
	
	public void setParent(JComponent panel)
	{
		testPanel.setParent(panel);
	}
	
	public void setQuestion(String text)
	{
		label.setText(text, -1);
	}
	
	public void setAnswers(String ... text)
	{
		for(int i = 0; i < 4; i++)
			radioButtons[i].setText(text[i]);
	}
	
	public void setCorrectAnswer(int correctAnswer)
	{
		this.correctAnswer = correctAnswer;
	}
	
	public ButtonModel getCorrectAnswer()
	{
		ArrayList<AbstractButton> buttons = Collections.list(group.getElements());
		return buttons.get(correctAnswer).getModel();
	}
	
	public void setPosition(int x, int y)
	{
		testPanel.setBounds(x, y, 500, 150);
	}
	
	public int getHeight()
	{
		return testPanel.getHeight();
	}
	
	public int getWidth()
	{
		return testPanel.getWidth();
	}
	

}
