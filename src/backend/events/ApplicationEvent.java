package backend.events;

public interface ApplicationEvent
{
	public void onTestCompleted();
	public void onLogOn();
	public void onClose();
	public void onReassign();
}
