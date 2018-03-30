package backend.core;

import java.util.ArrayList;
import java.util.Hashtable;

import users.User;
import users.UserFactory;

public class UserDatabase
{
	Hashtable<String, Hashtable<String, ArrayList<String>>> Database;
	
	public static User currentUser;
	
	UserDatabase()
	{
		Database = new Hashtable<String, Hashtable<String, ArrayList<String>>>();
	}
	
	public void AddSubDatabase(String databaseKey, Hashtable<String, ArrayList<String>> subDatabase)
	{
		Database.put(databaseKey, subDatabase);
	}
	
	public Hashtable<String, ArrayList<String>> getSubDatabase(String databaseKey)
	{
		return Database.get(databaseKey);
	}
	
	public void RemoveSubDatabase(Hashtable<String, ArrayList<String>> subDatabase)
	{
		Database.remove((Object)subDatabase);
	}
	public void RemoveSubDatabase(String databaseKey)
	{
		Database.remove(databaseKey);
	}
	
	public ArrayList<String> findByUsername(String subDatabase, String username)
	{
		return Database.get(subDatabase).get(username);
	}
	
	public <T> User createUserInstance(String username, User user)
	{
		user.loadProperties(this, username);
		return user;
	}
	
	public <T> Hashtable<String, ? extends User> instanciateSubDatabase(String subDatabase, String type)
	{
		Hashtable<String, T>userInstanceDatabase = new Hashtable<String, T>();
		UserFactory userFactory = new UserFactory();
		
		for(String username : Database.get(subDatabase).keySet())
		{
			userInstanceDatabase.put(username, (T) createUserInstance(username, userFactory.getUser(type) ));
		}
		return (Hashtable<String, ? extends User>) userInstanceDatabase;

	}
	
}
