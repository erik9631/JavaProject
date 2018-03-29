package users;

import java.io.FileWriter;
import java.io.IOException;
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
	@Override
	public String csvSerialize()
	{
		serializableProperties.append(getUserName());
		serializableProperties.append(",");
		serializableProperties.append(getPassword());
		serializableProperties.append("\n");
		return serializableProperties.toString();
	}
}
