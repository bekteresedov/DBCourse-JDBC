package service;

import java.util.List;

import model.Teacher;

public interface TeacherService {
	public List<Teacher> teacherList() throws Exception;

	public boolean addTeacher(Teacher teacher) throws Exception;

	Teacher getTeacherBy(int id) throws Exception;

	public boolean editTeacher(Teacher teacher, int id) throws Exception;

	public boolean deleteTeacher(int id) throws Exception;

	public List<Teacher> getSearchTeacher(String keyword) throws Exception;
}
