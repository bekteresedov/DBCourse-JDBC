package service.impl;

import java.util.List;

import dao.TeacherDao;
import model.Teacher;
import service.TeacherService;

public class TeacherServiceImpl implements TeacherService {
	private TeacherDao teacherService;
	 public TeacherServiceImpl(TeacherDao teacherDao) {
		this.teacherService=teacherDao;
	}



	@Override
	public List<Teacher> teacherList() throws Exception {
		// TODO Auto-generated method stub
		return teacherService.teacherList();
	}



	@Override
	public boolean addTeacher(Teacher teacher) throws Exception {
		return teacherService.addTeacher(teacher);
	}



	@Override
	public Teacher getTeacherBy(int id) throws Exception {
		// TODO Auto-generated method stub
		return teacherService.getTeacherBy(id);
	}



	@Override
	public boolean editTeacher(Teacher teacher, int id) throws Exception {
		// TODO Auto-generated method stub
		return teacherService.editTeacher(teacher, id);
	}



	@Override
	public boolean deleteTeacher(int id) throws Exception {
		// TODO Auto-generated method stub
		return teacherService.deleteTeacher(id);
	}



	@Override
	public List<Teacher> getSearchTeacher(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return teacherService.getSearchTeacher(keyword);
	}

}
