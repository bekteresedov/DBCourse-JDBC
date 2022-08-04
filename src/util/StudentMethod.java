package util;

import java.util.List;

import dao.StudentDao;
import dao.impl.StudentDaoimpl;
import model.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

public class StudentMethod {
	public static void getStudent() {
		StudentDao studentDao = new StudentDaoimpl();
		StudentService studentService = new StudentServiceImpl(studentDao);
		try {
			List<Student> list = studentService.studentList();
			list.forEach(StudentMethod::printStudent);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void printStudent(Student s) {
		System.out.println("Id:"+s.getId() + "\nName:" + s.getName() + "\nSurname:" + s.getSurname() + "\nAddress:" + s.getAddress() + "\nContact:"
				+ s.getContact() + "\n"+"Group:"+s.getGroup().getGroup_name()+"\nToDate:" + s.getTo_date() +"\n");
	}
}
