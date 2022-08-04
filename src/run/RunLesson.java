package run;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dao.LessonDao;
import dao.impl.LessonDaoImpl;
import model.Lesson;
import service.LessonService;
import service.impl.LessonServiceImpl;
import util.LessonMethod;

public class RunLesson {

	public static void runLesson() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Scanner sc = new Scanner(System.in);
		LessonDao lessonDao = new LessonDaoImpl();
		LessonService lessonService = new LessonServiceImpl(lessonDao);
		System.out.println("1-List\n2-Add\n3-Edit\n4-Delete\n5-Search");
		String select = sc.nextLine();
		switch (select) {
		case "1":
			try {
				LessonMethod.getLesson();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "2":
			Lesson lesson = new Lesson();
			System.out.println("Enter the Name:");
			String lessonname = sc.nextLine();
			System.out.println("Enter the CreatedDate:");
			String createddate = sc.nextLine();
			lesson.setLesson_name(lessonname);
			Date currentdate;
			currentdate = sdf.parse(createddate);
			lesson.setCreated_date(currentdate);
			try {
				boolean result = lessonService.addLesson(lesson);
				if (result)
					System.out.println("Succesfuly adding");
				else
					System.out.println("not success");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "3":
			LessonMethod.getLesson();
			System.out.println("Enter keyword:");
			int keyword = sc.nextInt();
			Lesson lessons = lessonService.getLessonById(keyword);
			System.out.println("<-----Old----->\n\nName:" + lessons.getLesson_name() + "\nCreatedDate: "
					+ lessons.getCreated_date());
			sc.nextLine();
			Lesson l = new Lesson();
			System.out.println("Enter New Lesson_name:");
			String lName = sc.nextLine();
			System.out.println("Enter New Created_Date:");
			String lDate = sc.nextLine();
			l.setLesson_name(lName);
			Date LD = sdf.parse(lDate);
			l.setCreated_date(LD);
			try {
				boolean result = lessonService.editLesson(l, keyword);
				if (result)
					System.out.println("Successfuly editing");
				else
					System.out.println("not success");
			} catch (Exception e) {
				e.printStackTrace();
			}

			break;
		case "4":
			LessonMethod.getLesson();
			System.out.println("Enter the Id:");
			int dId = sc.nextInt();
			boolean delete = lessonService.deleteLesson(dId);
			if (delete) {
				System.out.println("Successfly deleting");
			} else {
				System.out.println("not success");
			}
		case "5":
			System.out.println("Enter the keyword:");
			String k = sc.nextLine();
			List<Lesson> list = lessonService.getSerachLessson(k);
			if(!list.isEmpty()) {
				for(Lesson i:list) {
					System.out.println("\n<-----Serach Result----->\nId:"+i.getId()+"\nName:"+i.getLesson_name()+"\nCreatedDate:"+i.getCreated_date());
				}
			}else {
				System.err.println("Data not found");
			}
			break;

		default:
			System.err.println("Data not found");
			break;
		}

	}

}
