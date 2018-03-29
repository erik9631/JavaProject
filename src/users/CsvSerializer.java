package users;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CsvSerializer<T extends User>
{
	private void checkForUsername(String filename, String username) throws IOException
	{
		FileReader reader = new FileReader(filename);
		reader.read();
	}
	
	private void saveStudent(T user) throws IOException
	{	
		Student student = (Student)user;
		FileWriter writer = new FileWriter("Students.csv");
		writer.append(student.getUserName());
		writer.append(',');
		writer.append(student.getPassword());
		writer.append("\n");
		
	}
	
	public void saveToCsv(String fileName, T user)
	{
		if(user instanceof Student)
		{
			try
			{
				saveStudent(user);
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
