package users;

import java.io.EOFException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CsvSerializer<T extends User>
{
	
	private String readColumRow(int colum, int row, String filename) throws IOException
	{
		colum++;
		FileReader reader = new FileReader(filename);
		String content = "";
		int n = '0';
		
		int columCounter = 0;
		int rowCounter = 0;
		//Find row
		
		if(rowCounter != row)
			while((n = reader.read()) != -1)
			{
				if(n == '\n')
					rowCounter++;
				
				if(rowCounter == row)
					break;
			}
		
		if(n == -1)
			throw new IOException("End of file!");
		
		while((n = reader.read()) != -1)
		{
			if(n == ',' || n == '\n' || n == '\r')
			{
				columCounter++;
				if(colum == columCounter)
					break;
				else
				{
					if(n == '\n' || n == '\r')
						throw new IOException("End of Line!");
					content = "";
					continue;
				}
			}
			
			content += Character.toString((char)n);
				
		}
		
		if(n == -1)
			throw new IOException("End of file!");
		reader.close();
		return content;

	}
	
	public int findInRow(String filename, String value, int row)
	{
		String content = "";
		try
		{
			for(int colum = 0; true; colum++)
			{
				content = readColumRow(colum, row, filename);	
				if(content.equals(value))
					return colum;
			}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			return -1;
		}
	}
	
	public int findInColum(String filename, String value, int colum)
	{

		String content = "";
		try
		{
			for(int row = 0; true; row++)
			{
				content = readColumRow(colum, row, filename);	
				if(content.equals(value))
					return row;
			}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			return -1;
		}
	}
	
	
	private void saveProperties(T user, String filename) throws IOException
	{	
		if(findInColum(filename, user.getUserName(), 1) != -1)
		{
			throw new IOException("Error Username exists!");
		}
		FileWriter writer = new FileWriter(filename, true);
		
		writer.append(user.csvSerialize());
		writer.close();
		System.out.println("Saved to file");
		
	}
	
	public int findMatchingProperties(int[] colums, String[] properties, String filename)
	{
		int row = -1;
		for(int i : colums)
			if((row = findInColum(filename, properties[i], i)) != -1)
				for(int j = 0; j < properties.length; j++)
					if(findInRow(filename, properties[j], row) == -1)
						return -1;
		
		
		return row;
	}
	
	public void saveToCsv(String fileName, T user)
	{
		if(user instanceof Student)
		{
			try
			{
				saveProperties(user, fileName);
			} catch (IOException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
}
