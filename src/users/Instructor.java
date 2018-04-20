package users;

import backend.core.UserDatabase;

public class Instructor extends User
{
	public Instructor(String username, String password)
	{
		super(username, password);
	}

	@Override
	public String csvSerialize()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadProperties(UserDatabase database)
	{
		// TODO Auto-generated method stub
		
	}

}
