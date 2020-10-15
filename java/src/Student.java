package studentregister;

import java.io.Serializable;
import java.util.Arrays;

class Student  implements Serializable{
	
	

	private static final long serialVersionUID = 1L;
private String studentName=null;
private Integer  studentId=0;
private String[] studentSubjects=null;
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public Integer getStudentId() {
	return studentId;
}
public void setStudentId(Integer studentId) {
	this.studentId = studentId;
}
public String[] getStudentSubjects() {
	return studentSubjects;
}
public void setStudentSubjects(String[] studentSubjects) {
	this.studentSubjects = studentSubjects;
}

public Student()
{}
public Student(String studentName, Integer studentId, String[] studentSubjects )
{
super();
this.studentName=studentName;
this.studentId=studentId;
this.studentSubjects=studentSubjects;
}
@Override
public String toString() {
	return "Student [studentName=" + studentName + ", studentId=" + studentId + ", studentSubjects="
			+ Arrays.toString(studentSubjects) + "]";
}


}
