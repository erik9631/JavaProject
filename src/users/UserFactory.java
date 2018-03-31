package users;

public class UserFactory
{
	public User getUser(String type, String username)
	{
		switch (type)
		{
			case "STUDENT":
			{
				return new Student(username, null);
			}
			case "ADMINISTRATOR":
			{
				return new Administrator(username, null);
			}
		}
		throw new RuntimeException("Error, not found");
	}
}
