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
	private ArrayList<Float> testPercentage;
	
	
	public Student()
	{
		super(null, null);
		testPercentage = new ArrayList<Float>();
	}
	
	public Student(String userName, String password)
	{
		super(userName, password);
		testPercentage = new ArrayList<Float>();
		
	}
	public float getTestPercentage(int index)
	{
		return testPercentage.get(index);
	}
	@Override
	public String csvSerialize()
	{
		serializableProperties.append(getUserName());
		serializableProperties.append(",");
		serializableProperties.append(getPassword());
		serializableProperties.append("\n");
		return serializableProperties.toString();
	}
	@Override
	public void loadProperties(UserDatabase database, String username)
	{
		this.username = username;
		this.password = database.getSubDatabase("Students").get(username).get(1);
	}
}
