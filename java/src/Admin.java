package studentregister;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.bson.Document;

import com.google.gson.Gson;

class Admin {
	HashMap<Integer, Student> studentRegister = new HashMap<Integer,Student>();
	Scanner ob=new Scanner(System.in);
	Gson gson=new Gson();
	DBManager dbmanager=new DBManager();
	
// add
	public void add(Integer Id, String name, String[] marks)
	{
		Student tempStudent = new Student(name,Id,marks);
		studentRegister.put(Id, tempStudent);
		
	}
	//edit
	public void edit(Integer Id)
	{
		Student tempStudent= studentRegister.get(Id);
		if(tempStudent == null)
		{
			System.out.println("No id present");
		}
		else
		{
			System.out.println(tempStudent.toString());
			System.out.println("what yo want to edit? \n 1. Name  \n 2. Subjects");
	        int choice=Integer.parseInt(ob.next());
	        switch(choice)
	        {
	        case 1:
	        	System.out.println("Enter the name");
	        	String newName=ob.next();
	        	tempStudent.setStudentName(newName);
	        	studentRegister.put(Id, tempStudent);
	        	break;
	        	
	        case 2:
	        	String[] subjectTemp=tempStudent.getStudentSubjects();
	        	for (int i = 0; i < subjectTemp.length; i++) {
					System.out.println(i +". "+ subjectTemp[i]);
				}
	        	System.out.println("Enter the subjects that you want to change");
	        	int change=Integer.parseInt(ob.next());
	        	System.out.println("Enter the subjetcs");
	        	String subject=ob.next();
	        	subjectTemp[change]=subject;
	        	tempStudent.setStudentSubjects(subjectTemp);
	        	studentRegister.put(Id,tempStudent);
	        	break;
	        	
	        	default:
	        		break;
	        	
	        }
		}
	}
	// delete
	public void delete(Integer Id)
	{
		Student tempStudent=studentRegister.remove(Id);
		if(tempStudent == null)
		{
			System.out.println("No id present");
		}
		else
		{
			System.out.println(tempStudent.toString()+" was deleted");
		}
	}
	
	//save
	
	public void save()
	{
		ArrayList<Document> documents=new ArrayList<Document>();
		for( Student student : studentRegister.values()) {
documents.add(Document.parse(gson.toJson(student)))	;		
		}
		dbmanager.saveHashMap(documents);
		
	}
	
	
public void load()
{
	ArrayList<Student> students =dbmanager.loadHashMap();
	if(students!=null)
	{
		studentRegister =new HashMap<Integer,Student>();
		for (Student student : students) {
			studentRegister.put(student.getStudentId(), student);
		}
	}
}

public void view()
{
	if(studentRegister.isEmpty())
	{
		System.out.println("no values inserted");
	}
	else
	{
		for (Student student :studentRegister.values()) {
			System.out.println(student.toString());
			
		}
	}
}
}
