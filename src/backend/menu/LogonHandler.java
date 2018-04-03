package backend.menu;

import java.util.ArrayList;

public class LogonHandler
{
	static ArrayList<LogonEvent>subscribers = new ArrayList<LogonEvent>();
	
	public static void subscribe(LogonEvent subscriber)
	{
		subscribers.add(subscriber);
	}
	
	public static void notifySubscribers()
	{
		for(LogonEvent i : subscribers)
			i.onLogon();
	}
}
