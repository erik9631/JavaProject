package backend.events;

import java.util.ArrayList;

public class UserEventHandler
{
	static private ArrayList<UserEvent> subscribers = new ArrayList<UserEvent>();
	
	public static void subscribe(UserEvent subscriber)
	{
		subscribers.add(subscriber);
	}
	
	public static void notifyLogon()
	{
		for(UserEvent i : subscribers)
			i.onLogOn();
	}
	
	public static void notifyTestComplete()
	{
		for(UserEvent i : subscribers)
		{
			i.onTestCompleted();
		}
	}
}
	