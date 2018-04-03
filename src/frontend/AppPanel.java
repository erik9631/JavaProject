package frontend;

import java.awt.Color;
import javax.management.RuntimeErrorException;
import javax.swing.JComponent;
import javax.swing.JPanel;

import backend.core.AppController;
import backend.core.Resizable;

@SuppressWarnings("serial")
public class AppPanel extends JPanel implements ComponentInformer
{
	Object owner;
	public AppPanel(int width, int height, Color color)
	{
		if(AppController.getAppPanel() != null)
			throw new RuntimeErrorException(new Error("Can not have two main panels"));
		init(width, height, color);
	}
	
	private void init(int width, int height, Color color)
	{
		MainFrame.subscribe(this);
		setSize(width, height);
		setLayout(null);
		setBackground(color);
	}
	
	public AppPanel(int width, int height, Color color, Object owner)
	{
		this.owner = owner;
		AppController.getAppPanel().add(this);
		init(width, height, color);
	}
	
	public void setParent(JComponent panel)
	{
		AppController.getAppPanel().remove(this);
		panel.add(this);
	}


	@Override
	public void mainFrameResized()
	{
		if(owner instanceof Resizable)
			((Resizable)owner).onResize();
	}
}
