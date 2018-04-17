package backend.events;

import java.util.ArrayList;
/*
 * Vsetky user eventy su handlovane tu. Prihlasovanie, ohdlasovanie, spustanie testov, kontrola znamok a podobne.
 */
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
	
	public static void notifyOnExit()
	{
		for(UserEvent i : subscribers)
		{
			i.onClose();
		}
	}
}
	