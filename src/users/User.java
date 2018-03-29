package users;

import java.io.FileWriter;
import java.util.HashMap;

import backend.core.UserDatabase;

public abstract class User implements CsvSerializable
{
	private String userName;
	private String password;
	private static UserDatabase database = new UserDatabase();
	protected StringBuilder serializableProperties;
	
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
	
	public static UserDatabase getUserDatabase()
	{
		return database;
	}

	public abstract String csvSerialize();
	
	/*
	 * TODO
	 * Try to remove static later
	 */
	
}
