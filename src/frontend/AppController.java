package frontend;

public class AppController
{	
	private static MainFrame frame;
	private static AppPanel panel;
	
	public AppController(MainFrame frame, AppPanel panel)
	{
		AppController.frame = frame;
		AppController.panel = panel;
	}
	
	public static MainFrame getMainFrame()
	{
		return frame;
	}
	
	public static AppPanel getAppPanel()
	{
		return panel;
	}
	
}
