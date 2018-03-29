package users;

import backend.core.UserDatabase;

public class User
{
	private String userName;
	private String password;
	private static UserDatabase database = new UserDatabase();
	
	protected User(String userName, String password)
	{
		this.userName = userName;
		this.password = password;
		database.addToDatabase(this);
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public String getPassword()
	{
		return password;
	}
	
}
