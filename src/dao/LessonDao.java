package dao;

import java.util.List;

import model.Lesson;

public interface LessonDao {
	public List<Lesson> lessonList() throws Exception;

	public boolean addLesson(Lesson lesson) throws Exception;

	public Lesson getLessonById(int id) throws Exception;

	public boolean editLesson(Lesson lesson, int id) throws Exception;

	public boolean deleteLesson(int id) throws Exception;

	public List<Lesson> getSerachLessson(String keyword) throws Exception;

}
