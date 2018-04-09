package courses;

import java.util.ArrayList;

import tests.Test;
import users.User;

public class Course
{
	/*
	 * Kurz obsahujuci instruktora, studentov, testy a kurikula
	 * Vyuzitie agregacie.
	 */
	private ArrayList<User> users;
	private ArrayList<Test> tests;
	
	private User instructor;
	
	public Course(User instructor)
	{
		users = new ArrayList<User>();
		tests = new ArrayList<Test>();
	}
	
	public void addUsers(ArrayList<User> users)
	{
		users.addAll(users);
	}
	
	public void addUser(User user)
	{
		users.add(user);
	}
	
	public void setInstructor(User instructor)
	{
		this.instructor = instructor;
	}
	
	public void addTest(Test test)
	{
		tests.add(test);
	}
}
