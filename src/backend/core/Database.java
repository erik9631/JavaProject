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
import java.util.Set;

import backend.events.ApplicationEvent;
import backend.events.ApplicationEventHandler;
import users.User;

public class Database implements ApplicationEvent
{
	Hashtable<String, User> userDatabase;
	public static User currentUser;
	public Database()
	{
		loadDatabase();
		ApplicationEventHandler.subscribe(this);
	}
	
	public User getUser(String key) throws ClassNotFoundException
	{
		User user = userDatabase.get(key);
		if(user == null)
			throw new ClassNotFoundException("Error username not found");
		else
			return user;
	}
	
	public Set<String> getUsernames()
	{
		System.out.println(userDatabase);
		return userDatabase.keySet();
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
			System.out.println("saved");
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
		
	}

	@Override
	public void onClose()
	{
		saveDatabase();
	}

	@Override
	public void onReassign()
	{
		// TODO Auto-generated method stub
		
	}
	
}
