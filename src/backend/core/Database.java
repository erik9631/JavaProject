package backend.core;

import java.beans.EventHandler;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

import backend.events.UserEvent;
import backend.events.UserEventHandler;
import users.User;

public class Database implements UserEvent
{
	Hashtable<String, User> userDatabase;
	public Database()
	{
		loadDatabase();
		UserEventHandler.subscribe(this);
	}
	
	public User getUser(String key) throws ClassNotFoundException
	{
		User user = userDatabase.get(key);
		if(user == null)
			throw new ClassNotFoundException("Error username not found");
		else
			return user;
	}
	
	public void loadDatabase()
	{
		try
		{
			FileInputStream input = new FileInputStream("Database.dat");
			ObjectInputStream objInput = new ObjectInputStream(input);
			//XMLDecoder decoder = new XMLDecoder(input);
			userDatabase = (Hashtable<String, User>) objInput.readObject();
			objInput.close();
			input.close();
			//System.out.println(userDatabase.get("erik").getPassword());
		}
		catch(IOException | ClassNotFoundException e)
		{
			userDatabase = new Hashtable<String, User>();
		}
		
	}
	
	public void addUser(User user)
	{
		userDatabase.put(user.getUsername(), user);
		saveDatabase();
	}
	
	private String getCredentials()
	{
		String credentials = "";
		for(String i : userDatabase.keySet())
			credentials += i + "," + userDatabase.get(i).getPassword() +"\n";
		return credentials;
	}
	
	private void saveCredentialsToCsv() throws IOException
	{
		FileWriter writer = new FileWriter("credentials.csv", false);
		BufferedWriter output = new BufferedWriter(writer);
		writer.write(getCredentials());
		writer.close();
		output.close();
		
	}
	
	public void saveDatabase()
	{
		try
		{
			FileOutputStream output = new FileOutputStream("Database.dat");
			//XMLEncoder encoder = new XMLEncoder(output);
			ObjectOutputStream obj = new ObjectOutputStream(output);
			//System.out.println(userDatabase);
			obj.writeObject(userDatabase);
			obj.close();
			output.close();
			saveCredentialsToCsv();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onTestCompleted()
	{
		saveDatabase();
	}

	@Override
	public void onLogOn()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClose()
	{
		saveDatabase();
	}
	
}
