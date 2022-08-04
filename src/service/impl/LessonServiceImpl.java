package service.impl;

import java.util.List;

import dao.LessonDao;
import model.Lesson;
import service.LessonService;

public class LessonServiceImpl implements LessonService {
	private LessonDao lessondao;

	public LessonServiceImpl(LessonDao lessondao) {
		this.lessondao = lessondao;
	}

	@Override
	public List<Lesson> lessonList() throws Exception {
		// TODO Auto-generated method stub
		return lessondao.lessonList();
	}

	@Override
	public boolean addLesson(Lesson lesson) throws Exception {
		// TODO Auto-generated method stub
		return lessondao.addLesson(lesson);
	}

	@Override
	public Lesson getLessonById(int id) throws Exception {
		// TODO Auto-generated method stub
		return lessondao.getLessonById(id);
	}

	@Override
	public boolean editLesson(Lesson lesson, int id) throws Exception {
		// TODO Auto-generated method stub
		return lessondao.editLesson(lesson, id);
	}

	@Override
	public boolean deleteLesson(int id) throws Exception {
		// TODO Auto-generated method stub
		return lessondao.deleteLesson(id);
	}

	@Override
	public List<Lesson> getSerachLessson(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return lessondao.getSerachLessson(keyword);
	}
	

}
