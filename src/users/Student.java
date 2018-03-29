package users;

import java.util.ArrayList;

public class Student extends User
{
	//Course assignedCourse;
	private ArrayList<Float> testPercentage;
	
	
	public Student(String userName, String password)
	{
		super(userName, password);
		testPercentage = new ArrayList<Float>();
		
	}
	public float getTestPercentage(int index)
	{
		return testPercentage.get(index);
	}
}
