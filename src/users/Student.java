package users;

import java.awt.Toolkit;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import backend.core.AppController;
import backend.core.UserDatabase;
import tests.Test;

public class Student extends User
{
	//Course assignedCourse;
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	public class testData implements Serializable
	{
		private String testName;
		private int testId;
		private float testPercentage;
		testData(String testName, int testId, float testPercentage)
		{
			this.testName = testName;
			this.testId = testId;
			this.testPercentage = testPercentage;
		}
		
		public String getTestName()
		{
			return testName;
		}
		public int getTestId()
		{
			return testId;
		}
		public float getTestPercentage()
		{
			return testPercentage;
		}
	}
	
	private ArrayList<testData> testPercentage;
	public Student(String username, String password)
	{
		super(username, password);
		testPercentage = new ArrayList<testData>();
		
	}
	
	public ArrayList<testData> getTests()
	{
		return testPercentage;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public testData getTestbyId(int id)
	{
		for(testData i : testPercentage)
			if(i.testId == id)
				return i;
		return null;
	}
	
	public testData getTestbyName(String name)
	{
		for(testData i : testPercentage)
			if(i.testName.equals(name))
				return i;
		return null;
	}
	
	public void addGrade(String testName, int testId, float testPercentage)
	{
		testData test = getTestbyId(testId);
		if(test == null)
			this.testPercentage.add(new testData(testName, testId, testPercentage));
		else
			test.testPercentage = testPercentage;
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
