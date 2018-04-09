package backend.core;

import java.util.ArrayList;
import java.util.Hashtable;

import users.User;
import users.UserFactory;

public class UserDatabase
{
	/*
	 * Uzivatelska databaza ktora reprezentuje raw data preparsovane z CSV suboru.
	 */
	Hashtable<String, Hashtable<String, ArrayList<String>>> Database;
	
	public static User currentUser;
	
	UserDatabase()
	{
		Database = new Hashtable<String, Hashtable<String, ArrayList<String>>>();
	}
	
	public void AddSubDatabase(String databaseKey, Hashtable<String, ArrayList<String>> subDatabase) // Vytvorenie noveho harku
	{
		Database.put(databaseKey, subDatabase);
	}
	
	public Hashtable<String, ArrayList<String>> getSubDatabase(String databaseKey) // Ziskanie harku
	{
		return Database.get(databaseKey);
	}
	
	public void RemoveSubDatabase(Hashtable<String, ArrayList<String>> subDatabase) // Zmazanie harku podla referencie
	{
		Database.remove((Object)subDatabase);
	}
	public void RemoveSubDatabase(String databaseKey) // Zmazanie harku podla klucu
	{
		Database.remove(databaseKey);
	}
	
	public ArrayList<String> findByUsername(String subDatabase, String username) //Najdenie dat v danom harku pre daneho uzivatela
	{
		return Database.get(subDatabase).get(username);
	}
	
	public <T> User createUserInstance(User user) // Instanciovanie uzivatela. Musi byt minimalne specifikovany username
	{
		user.loadProperties(this);
		return user;
	}
	
	public <T> Hashtable<String, ? extends User> instanciateSubDatabase(String subDatabase, String type) // Instanciovanie celeho harku
	{
		Hashtable<String, T>userInstanceDatabase = new Hashtable<String, T>();
		UserFactory userFactory = new UserFactory();
		
		for(String username : Database.get(subDatabase).keySet()) 
		{
			userInstanceDatabase.put(username, (T) createUserInstance(userFactory.getUser(type, username)));
		}
		return (Hashtable<String, ? extends User>) userInstanceDatabase;

	}
	
}
