package backend.core;

import java.util.ArrayList;
public class DefinedBehavior
{
	/*
	 * Super trieda celeho programu. Kazdy instanciovatelny prvok z neho musi dedit
	 * Tu riesime tagovanie a pridavanie do hlavnej sceny
	 */
	public static ArrayList<String> tags = new ArrayList<String>();;
	public static DefinedBehavior last;
	public DefinedBehavior()
	{
		AppController.addToScene(this);
		last = this;
	}
	
	public static void addTag(String tag)
	{
		tags.add(tag);
	}
	
	public static boolean hasTag(String tag)
	{
		for(String i : tags)
			if(i == tag)
				return true;
		return false;
	}
	
	public static <T> T getLast()
	{
		return (T)last;
	}
}
