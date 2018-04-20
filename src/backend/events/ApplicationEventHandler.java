package backend.events;

import java.util.ArrayList;
/*
 * Vsetky user eventy su handlovane tu. Prihlasovanie, ohdlasovanie, spustanie testov, kontrola znamok a podobne.
 */
public class ApplicationEventHandler
{
	static private ArrayList<ApplicationEvent> subscribers = new ArrayList<ApplicationEvent>();
	
	public static void subscribe(ApplicationEvent subscriber)
	{
		subscribers.add(subscriber);
	}
	
	public static void notifyLogon()
	{
		for(ApplicationEvent i : subscribers)
			i.onLogOn();
	}
	
	public static void notifyTestComplete()
	{
		for(ApplicationEvent i : subscribers)
		{
			i.onTestCompleted();
		}
	}
	
	public static void notifyOnExit()
	{
		for(ApplicationEvent i : subscribers)
		{
			i.onClose();
		}
	}
	
	public static void notifyOnReassign()
	{
		for(ApplicationEvent i : subscribers)
		{
			i.onReassign();
		}
	}
}
	