package users;

import java.io.FileWriter;

import backend.core.UserDatabase;

public interface CsvSerializable
{
	public String csvSerialize();
	public void loadProperties(UserDatabase database, String username);
}
