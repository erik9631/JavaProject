package tests;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Panel;
import java.util.ArrayList;

import javax.print.attribute.standard.Finishings;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JScrollBar;

import backend.core.AppButton;
import backend.core.AppController;
import backend.core.BaseItem;
import backend.core.Database;
import backend.core.DefinedBehavior;
import backend.core.MessageBox;
import backend.core.UserDatabase;
import backend.events.LoadLayerEvent;
import backend.events.LoadLayerHandler;
import backend.events.ApplicationEventHandler;
import frontend.AppPanel;
import frontend.LabelButton;
import frontend.ScrollAppPanel;
import users.Student;

public class Test extends BaseItem
{
	private ArrayList<QuestionPanel> questions = new ArrayList<QuestionPanel>();
	private int spaceSize = 20;
	private ScrollAppPanel panel;
	private AppButton evaluateButton;
	private AppButton backButton;
	private Runnable onExitAction;
	private float correct;
	private String name;

	/*
	 * Samotny test obsahujuci otazky
	 */
	
	
	
	
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
			LoadLayerHandler.loadLayer(1);
		});

	}
	
	public void setOnExitAction(Runnable action)
	{
		onExitAction = action;
	}
	
	public void addQuestion(QuestionPanel question) // Pridanie novej otazky
	{
		question.setParent(panel);
		
		for(Component i : question.getGuiComponent().getComponents())
		{
			i.addComponentListener(panel);
		}
		questions.add(question);
		updatePositions();
		
	}
	
	private void updatePositions() // Nastavenie pozicii otazok. Riesene dynamicky podla poctu otazok
	{
		int counter = 0;
		for(QuestionPanel i : questions)
		{
			i.setPosition(20, ((i.getHeight() + spaceSize) * counter) + 5);
			counter++;
		}
		evaluateButton.setPos(20, ( (questions.size()) * questions.get(0).getHeight() ) + (spaceSize * questions.size()));
		backButton.setPos(evaluateButton.getPosX(), evaluateButton.getPosY() + spaceSize);
	}
	
	private void evaluate() // Vyhodnotenie testu
	{
		for(QuestionPanel i : questions)
			if(i.isCorrect() == true)
				correct++;
		if((Database.currentUser instanceof Student) == false)
			System.out.println("Only students can do tests!");
		Student user = (Student)Database.currentUser;
		
		user.sendMessage("Uspesnost testu: " + getName() + ": <span style=\"color: blue \">" + ( correct / (float)questions.size()) * 100 + "%</span>");
		System.out.println(correct / (float)questions.size() * 100);
		user.addGrade(name, layers.get(0), correct / (float)questions.size() * 100);
		ApplicationEventHandler.notifyTestComplete();
		correct = 0;
		//UserDatabase.currentUser.s
	}
	
	public String getName()
	{
		return name;
	}
	
	
	public void setName(String name)
	{
		this.name = name;
	}
	
}
