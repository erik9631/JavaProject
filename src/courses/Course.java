package courses;

import java.util.ArrayList;

import tests.ITest;
import users.Instructor;
import users.User;

public class Course
{
	/*
	 * Kurz obsahujuci instruktora, studentov, testy a kurikula
	 * Vyuzitie agregacie.
	 */
	private ArrayList<User> users;
	private ArrayList<ITest> tests;
	
	private String courseName;
	private Instructor instructor;
	
	public Course(Instructor instructor, String courseName)
	{
		users = new ArrayList<User>();
		tests = new ArrayList<ITest>();
		this.courseName = courseName;
		this.instructor = instructor;
	}
	
	public String getCourseName()
	{
		return courseName;
	}
	
	public void addUser(User user)
	{
		users.add(user);
		user.assignToCourse(this);
	}
	
	public void setInstructor(Instructor instructor)
	{
		this.instructor = instructor;
	}
	
	public Instructor getInstructor()
	{
		return instructor;
	}
	
	public void addTest(ITest test)
	{
		tests.add(test);
	}
	
	public ArrayList<ITest> getTests()
	{
		return tests;
	}
}
