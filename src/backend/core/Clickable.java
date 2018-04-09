package backend.core;

public interface Clickable
{
	/*
	 * Tento interface implementuju vsetky back end triedy na ktore sa da kliknut
	 */
	public void onPress();
	public void onRelease();
	public void onClick();
	public String getText();
}
