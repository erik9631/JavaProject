package tests;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.util.ArrayList;

import javax.print.attribute.standard.Finishings;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JScrollBar;

import backend.core.AppButton;
import backend.core.AppController;
import backend.core.BaseItem;
import backend.core.DefinedBehavior;
import backend.events.LoadLayerEvent;
import backend.events.LoadLayerHandler;
import frontend.AppPanel;
import frontend.LabelButton;
import frontend.ScrollAppPanel;

public class Test extends BaseItem
{
	private ArrayList<QuestionPanel> questions = new ArrayList<QuestionPanel>();
	private int spaceSize = 20;
	private ScrollAppPanel panel;
	private AppButton evaluateButton;
	private AppButton backButton;
	private int correct;

	private Runnable onExitAction;
	
	
	
	
	public Test(boolean blackListed, int ... layers)
	{
		
		super(layers, blackListed);
		panel = createGuiComponent(new ScrollAppPanel(600, 400, new Color(119,136,153), this));
		panel.setBorder(BorderFactory.createSoftBevelBorder(0));
		evaluateButton = new AppButton("Evaluate", blackListed, panel, layers);
		backButton = new AppButton("Back", blackListed, panel, layers);

		backButton.setFontSize(12);
		evaluateButton.setFontSize(12);
		
		evaluateButton.setPos(20, 20 + spaceSize);
		backButton.setPos(evaluateButton.getPosX(), evaluateButton.getPosY() + evaluateButton.getHeight());
		
		evaluateButton.getActions().setOnClickAction(this::evaluate);
		backButton.getActions().setOnClickAction(()->
		{
			LoadLayerHandler.loadLayer(0);
		});

	}
	
	public void setOnExitAction(Runnable action)
	{
		onExitAction = action;
	}
	
	public void addQuestion(QuestionPanel question)
	{
		question.setParent(panel);
		questions.add(question);
		updatePositions();
		panel.updateComponents();
		
	}
	
	private void updatePositions()
	{
		int counter = 0;
		for(QuestionPanel i : questions)
		{
			i.setPosition(20, ((i.getHeight() + spaceSize) * counter) + 5);
			counter++;
		}
		evaluateButton.setPos(20, ( (questions.size()) * questions.get(0).getHeight() ) + (spaceSize * 2));
		backButton.setPos(evaluateButton.getPosX(), evaluateButton.getPosY() + spaceSize);
		System.out.println(panel.getPreferredSize());
	}
	
	private void evaluate()
	{
		for(QuestionPanel i : questions)
			if(i.getSelection().equals(i.getCorrectAnswer()))
				correct++;
		System.out.println("Correct answers:" + correct);
		correct = 0;
	}
	
}
