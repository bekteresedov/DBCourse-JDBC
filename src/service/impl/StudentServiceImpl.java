package service.impl;

import java.util.List;


import dao.StudentDao;
import model.Student;
import service.StudentService;

public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao;

	public StudentServiceImpl(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public List<Student> studentList() throws Exception {
		// TODO Auto-generated method stub
		return studentDao.studentList();
	}

	@Override
	public boolean addStudent(Student student) throws Exception {
		// TODO Auto-generated method stub
		return studentDao.addStudent(student);
	}

	@Override
	public Student getStudentById(int id) throws Exception {
		// TODO Auto-generated method stub
		return studentDao.getStudentById(id);
	}

	@Override
	public boolean editStudent(Student student, int id) throws Exception {
		// TODO Auto-generated method stub
		return studentDao.editStudent(student, id);
	}

	@Override
	public boolean deleteStudent(int id) throws Exception {
		// TODO Auto-generated method stub
		return studentDao.deleteStudent(id);
	}

	@Override
	public List<Student> getSearchStudent(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return studentDao.getSearchStudent(keyword);
	}

}
