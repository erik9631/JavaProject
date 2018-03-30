package users;

import backend.core.UserDatabase;

public class Administrator extends User
{
	public Administrator()
	{
		super(null, null);
	}
	
	public Administrator(String userName, String password)
	{
		super(userName, password);
	}
	@Override
	public String csvSerialize()
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void loadProperties(UserDatabase database, String username)
	{
		// TODO Auto-generated method stub
		
	}

}
