package backend.core;

import java.util.ArrayList;

public abstract class DefinedBehavior
{
	public ArrayList<String>tags;
	public static DefinedBehavior last;
	public DefinedBehavior()
	{
		tags = new ArrayList<String>();
		AppController.addToScene(this);
		last = this;
	}
	
	public static <T> T getLast()
	{
		return (T)last;
	}
}
