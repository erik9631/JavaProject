package users;

import java.awt.Toolkit;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import backend.core.AppController;
import backend.core.UserDatabase;

public class Student extends User
{
	//Course assignedCourse;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Float> testPercentage;
	public Student(String username, String password)
	{
		super(username, password);
		testPercentage = new ArrayList<Float>();
		
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public float getTestPercentage(int index)
	{
		return testPercentage.get(index);
	}
	@Override
	public String csvSerialize()
	{
		serializableProperties.append(getUsername());
		serializableProperties.append(",");
		serializableProperties.append(getPassword());
		serializableProperties.append("\n");
		return serializableProperties.toString();
	}
	@Override
	public void loadProperties(UserDatabase database)
	{
		this.password = database.getSubDatabase("Students").get(username).get(1);
	}
}
