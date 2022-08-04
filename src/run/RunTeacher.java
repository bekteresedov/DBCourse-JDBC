package run;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.TeacherDao;
import dao.impl.TeacherDaoImpl;
import model.Teacher;
import service.TeacherService;
import service.impl.TeacherServiceImpl;
import util.TeacherMethod;

public class RunTeacher {

	public static void runTeacher() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Scanner sc = new Scanner(System.in);
		TeacherDao teacherDao = new TeacherDaoImpl();
		TeacherService teacherService = new TeacherServiceImpl(teacherDao);
		System.out.println("1-List\n2-Add\n3-Edit\n4-Delete\n5-Search");
		String select = sc.nextLine();
		switch (select) {
		case "1":
			util.TeacherMethod.getTeacher();
			break;
		case "2":
			Teacher teacher = new Teacher();
			System.out.println("Enter the Name:");
			String name = sc.nextLine();
			System.out.println("Enter the Surname:");
			String surname = sc.nextLine();
			System.out.println("Enter the Profession:");
			String profession = sc.nextLine();
			System.out.println("Enter the Contact:");
			String contact = sc.nextLine();
			System.out.println("Enter the CreatedDate:");
			String createddate = sc.nextLine();
			teacher.setName(name);
			teacher.setSurname(surname);
			teacher.setProfession(profession);
			teacher.setContact(contact);
			Date currentdate;
			currentdate = sdf.parse(createddate);
			teacher.setCreatedDate(currentdate);
			try {
				boolean result = teacherService.addTeacher(teacher);
				if (result)
					System.out.println("Succesfuly adding");
				else
					System.out.println("Not success");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "3":
			TeacherMethod.getTeacher();
			System.out.println("Enter the id");
			int id = sc.nextInt();
			Teacher t = teacherService.getTeacherBy(id);
			System.out.println("<-----Old----->\n\nName:" + t.getName() + "\nSurname:" + t.getSurname() + "\nProfesion:"
					+ t.getProfession() + "\nContact:" + t.getContact() + "\nCreatedDate:" + t.getCreatedDate()
					);
			sc.nextLine();
			System.out.println("Enter new Name:");
			String nameu = sc.nextLine();
			System.out.println("Enter new Surname:");
			String surnameu = sc.nextLine();
			System.out.println("Enter new Proffesion:");
			String professionu = sc.nextLine();
			System.out.println("Enter new Contact:");
			String contactu = sc.nextLine();
			System.out.println("Enter new CreatedDate:");
			String createddateu = sc.nextLine();
			System.out.println("Enter new Uptade:");
			String updatedateu = sc.nextLine();
			Teacher teacheru = new Teacher();
			teacheru.setName(nameu);
			teacheru.setSurname(surnameu);
			teacheru.setProfession(professionu);
			teacheru.setContact(contactu);
			Date createdu = sdf.parse(createddateu);
			Date uptadeu = sdf.parse(updatedateu);
			teacheru.setCreatedDate(createdu);
			teacheru.setUptadeDate(uptadeu);
			try {
				boolean result = teacherService.editTeacher(teacheru, id);
				if (result)
					System.out.println("Successfuly editing");
				else
					System.out.println("not success");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "4":
			TeacherMethod.getTeacher();
			System.out.println("Enter the Id:");
			int idd = sc.nextInt();
			boolean delete = teacherService.deleteTeacher(idd);
			if (delete) {
				System.out.println("Successfly deleting");
			} else {
				System.out.println("not success");
			}
			break;
		case "5":
			System.out.println("Enter the keyword");
			String k = sc.nextLine();
			List<Teacher> list = teacherService.getSearchTeacher(k);
			if (!list.isEmpty()) {
				for (Teacher ts : list) {
					System.out.println("\n<-----Serach Result----->\nId:" + ts.getId() + "\nName:" + ts.getName() + "\nSurname:" + ts.getSurname()
							+ "\nProfession:" + ts.getProfession() + "\nContact:" + ts.getContact() + "\nCreatedDate:" + ts.getCreatedDate()
							+ "\nUpdateDate:" + ts.getUptadeDate());
				}
			} else {
				System.err.println("Data not found");
			}
			break;
		default:
			System.err.println("Data not found");
			break;
		}
	}

}
