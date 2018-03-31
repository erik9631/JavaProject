package users;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public abstract class User implements CsvSerializable
{
	protected String username;
	protected String password;
	protected StringBuilder serializableProperties;
	protected ArrayList<String>messages;
	
	protected User(String username, String password)
	{
		this.username = username;
		this.password = password;
		try
		{
			loadMessages();
			System.out.println("messages loaded for:" + this.username);
		} catch (FileNotFoundException e)
		{
			messages = new ArrayList<String>();
			System.out.println("messages not loaded for:" + this.username);
		}

	}
	
	@SuppressWarnings("unchecked")
	protected void loadMessages() throws FileNotFoundException
	{
		FileInputStream inputStream = new FileInputStream(username + ".xml");
		XMLDecoder decoder = new XMLDecoder(inputStream);
		messages = (ArrayList<String>) decoder.readObject();



		decoder.close();
		try
		{
			inputStream.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	protected void saveMessages() throws IOException
	{
		FileOutputStream fos = new FileOutputStream(username + ".xml");
		XMLEncoder encoder = new XMLEncoder(fos);
		encoder.writeObject(messages);
		encoder.close();
	}
	
	public void sendMessage(String string)
	{
		messages.add(string);
		try
		{
			saveMessages();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
