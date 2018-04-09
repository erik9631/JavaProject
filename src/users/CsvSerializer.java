package users;

import java.io.EOFException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.management.openmbean.ArrayType;

public class CsvSerializer<T extends User>
{
	/*
	 * Serializes properties defined in the csvSerializable interface 
	 * 
	 */
	
	/*
	 * CSV Serializer. Umoznuje zapis a citanie objektov do csv suboru.
	 */
	
	private String readColumRow(int colum, int row, String filename) throws IOException // Citanie riadkov a stlpcov
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
	
	public int findInRow(String filename, String value, int row) // Najdenie vlastnosti v danom riadku
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
	
	public int findInColum(String filename, String value, int colum) // Najdenie vlastnosti v danom stplci
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
	
	
	private void saveProperties(T user, String filename) throws IOException // Ulozenie vlastnosti do csv
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
	
	/*
	 * 
	 * TODO
	 * Make key modifiable
	 * 
	 */
	
	
	/*
	 * 
	 * Make own CSV serializer using reflection
	 */
	
	public Hashtable<String, ArrayList<String>> loadDatabase(String filename) // Nacitanie suboru a vratenie v tvare hasovacej tabulky
	{
		//Load usernames
		Hashtable<String, ArrayList<String>> Database = new Hashtable<String, ArrayList<String>>();
		
		
		for(int row = 0; true; row++)
		{
			String content;
			try
			{
				content = readColumRow(0, row, filename);
				Database.put(content, new ArrayList<String>());
			} 
			catch (IOException e)
			{
				System.out.println(e.getMessage());
				break;
			}
			
			for(int colum = 0; true; colum++)
			{
				try
				{
					Database.get(content).add(readColumRow(colum, row, filename));
				} 
				catch (IOException e)
				{
					System.out.println(e.getMessage());
					break;
				}				
			}

		}
		
		return Database;
		
	}
	
	public int findMatchingProperties(int[] colums, String[] properties, String filename) // Najdi shodujuce sa vlastnoti v danom stlpci
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
