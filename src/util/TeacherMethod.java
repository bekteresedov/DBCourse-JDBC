package util;

import java.util.List;

import dao.TeacherDao;
import dao.impl.TeacherDaoImpl;
import model.Student;
import model.Teacher;
import service.TeacherService;
import service.impl.TeacherServiceImpl;

public class TeacherMethod {
	public static void getTeacher() {
		TeacherDao teacherDao = new TeacherDaoImpl();
		TeacherService teacherService = new TeacherServiceImpl(teacherDao);
		try {
			List<Teacher> list = teacherService.teacherList();
			list.forEach(TeacherMethod::printTeacher);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void printTeacher(Teacher t) {
		System.out.println("Id:"+t.getId() + "\nName:" + t.getName() + "\nSurname:" + t.getSurname() + "\nProfession:" + t.getProfession() + "\nContact:"
				+ t.getContact() + "\nCreatedDate:" + t.getCreatedDate()+"\n");
	}
}
