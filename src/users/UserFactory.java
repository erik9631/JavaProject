package users;

public class UserFactory
{
	public User getUser(String type)
	{
		switch (type)
		{
			case "STUDENT":
			{
				return new Student();
			}
			case "ADMINISTRATOR":
			{
				return new Administrator();
			}
		}
		throw new RuntimeException("Error, not found");
	}
}
