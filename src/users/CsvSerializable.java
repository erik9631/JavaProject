package users;

import java.io.FileWriter;

import backend.core.UserDatabase;

public interface CsvSerializable
{
	// Implementuju vsetky triedy ktore su serializovatelne do csv
	public String csvSerialize();
	public void loadProperties(UserDatabase database);
}
