package dao;

import java.util.List;

import model.Student;

public interface StudentDao {
	public List<Student>studentList() throws Exception;
	public boolean addStudent(Student student) throws Exception;
	public Student getStudentById(int id)throws Exception;
	public boolean editStudent(Student student,int id)throws Exception;
	boolean deleteStudent(int id)throws Exception;
	public List<Student>getSearchStudent(String keyword)throws Exception;

}
