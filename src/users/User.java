package users;

import java.io.FileWriter;
import java.util.HashMap;

import backend.core.UserDatabase;

public abstract class User implements CsvSerializable
{
	protected String username;
	protected String password;
	protected StringBuilder serializableProperties;
	
	protected User(String userName, String password)
	{
		this.username = userName;
		this.password = password;
	}
	
	public String getUserName()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	/*
	 * TODO
	 * Try to remove static later
	 */
	
}
