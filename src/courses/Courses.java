package courses;

import java.util.ArrayList;

import backend.core.Database;
import tests.CPlusTest;
import tests.JavaTest;
import tests.JavaTest2;
import tests.NetworkingTest;
import users.Instructor;

public class Courses
{
	private static ArrayList<Course> courses = new ArrayList<Course>();
	Database database;
	public Courses(Database database)
	{
		this.database = database;
		try
		{
			Course javaCourse = new Course((Instructor)(database.getUser("Brandon")), "OOP Course");
			database.getUser("Brandon").assignToCourse(javaCourse);
			//javaCourse.addUser(database.getUser("erik"));
			javaCourse.addTest(new JavaTest());
			javaCourse.addTest(new JavaTest2());
			courses.add(javaCourse);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			Course networkCourse = new Course((Instructor)database.getUser("Miko"), "Networking Course");
			database.getUser("Miko").assignToCourse(networkCourse);
			networkCourse.addTest(new NetworkingTest());
			courses.add(networkCourse);

		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			Course cplusCourse = new Course((Instructor)database.getUser("Peterson"), "C++ course");
			database.getUser("Peterson").assignToCourse(cplusCourse);
			cplusCourse.addTest(new CPlusTest());
			courses.add(cplusCourse);

		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			Course essentials = new Course((Instructor)database.getUser("Hudson"), "IT Essentials course");
			database.getUser("Peterson").assignToCourse(essentials);
			courses.add(essentials);

		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static Course getCourseByName(String courseName) throws ClassNotFoundException
	{
		
		for(Course i : courses)
		{
			if(i.getCourseName().equals(courseName))
				return i;
		}
		throw new ClassNotFoundException("Course does not exist!");
	}
	
	public static ArrayList<Course> getCourses()
	{
		return courses;
	}
}
