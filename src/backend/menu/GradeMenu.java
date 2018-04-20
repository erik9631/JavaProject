package backend.menu;

import java.util.ArrayList;

import backend.core.BaseItem;
import backend.core.Database;
import backend.core.MessageBox;
import backend.events.ApplicationEvent;
import backend.events.ApplicationEventHandler;
import courses.Course;
import courses.Courses;
import users.Instructor;
import users.Student;
import users.User;

public class GradeMenu implements ApplicationEvent
{
	MessageBox messagebox;
	ArrayList<String>grades;
	Database database;
	public GradeMenu(boolean blackListed, Database database, int... layers)
	{
		grades = new ArrayList<String>();
		messagebox = new MessageBox(false, layers);
		messagebox.setPosition(50, 30);
		messagebox.setMessageSource(grades);
		this.database = database;
		ApplicationEventHandler.subscribe(this);
	}
	
	private void generateStudentGrades(Student student, String name)
	{
		for(int i = 0; i < student.getTests().size(); i++)
		{
			String grade = "<span style=\"color: green\">"+ name + "</span> " + "<span style=\"color: blue\">" + student.getTests().get(i).getTestName() + ":</span> " + student.getTests().get(i).getTestPercentage()+"%";
			grades.add(grade);
		}
		messagebox.updateMessages();
	}
	
	private void generateInstructorGrades()
	{
		Instructor instructor = (Instructor)Database.currentUser;
		Course course;
		try
		{
			course = Courses.getCourseByName(instructor.getAssignedCourse());
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
				
		for(String username : database.getUsernames())
		{
			User user = null;
			try
			{
				user = database.getUser(username);
			} catch (ClassNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(user instanceof Student)
			{
				generateStudentGrades((Student)user, user.getUsername());
			}
			
		}
		
		messagebox.updateMessages();
	}
	
	private void updateGrades()
	{
		grades.clear();
		if(Database.currentUser instanceof Student)
			generateStudentGrades((Student)Database.currentUser, "");
		else
			generateInstructorGrades();

	}
	
	@Override
	public void onLogOn()
	{
		updateGrades();
	}
	@Override
	public void onClose()
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onReassign()
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onTestCompleted()
	{
		updateGrades();
	}
}
