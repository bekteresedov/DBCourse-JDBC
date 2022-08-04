package util;

import java.util.List;

import dao.LessonDao;
import dao.impl.LessonDaoImpl;
import model.Lesson;
import service.LessonService;
import service.impl.LessonServiceImpl;

public class LessonMethod {

	public static void getLesson() throws Exception {
	  LessonDao lessonDao=new LessonDaoImpl();
	  LessonService lessonService=new LessonServiceImpl(lessonDao);
	  List<Lesson>list=lessonService.lessonList();
	  list.forEach(LessonMethod::printLesson);
	}
   public static void printLesson(Lesson lesson) {
	   System.out.println("Id:"+lesson.getId()+"\nName:"+lesson.getLesson_name()+"\nCreatedDate:"+lesson.getCreated_date());
   }
}
