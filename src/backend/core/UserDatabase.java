package backend.core;

import java.util.ArrayList;

import users.User;

public class UserDatabase
{
	ArrayList<User>GlobalDatabase;
	
	public UserDatabase()
	{
		GlobalDatabase = new ArrayList<User>();
	}
	
	public void removeFromDatabase(User user)
	{
		GlobalDatabase.remove(user);
	}
	
	public void addToDatabase(User user)
	{
		GlobalDatabase.add(user);
	}
	
	public void getUserFromDatabase(int index)
	{
		GlobalDatabase.get(index);
	}
	
	public void getUserFromDatabase(User user)
	{
		GlobalDatabase.get(GlobalDatabase.indexOf(user));
	}
}
