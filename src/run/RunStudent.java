package run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.StudentDao;
import dao.impl.StudentDaoimpl;
import model.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;
import util.StudentMethod;

public class RunStudent {

	public static void runStudent() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date toDate, froDate;
		Scanner sc = new Scanner(System.in);
		StudentDao studentDao = new StudentDaoimpl();
		StudentService studentService = new StudentServiceImpl(studentDao);
		System.out.println("1-List\n2-Add\n3-Edit\n4-Delete\n5-Search");
		String select = sc.nextLine();
		switch (select) {
		case "1":
			util.StudentMethod.getStudent();
			break;
		case "2":
			Student student = new Student();
			System.out.println("Enter the Name:");
			String name = sc.nextLine();
			System.out.println("Enter the Suname:");
			String surname = sc.nextLine();
			System.out.println("Enter the Address:");
			String address = sc.nextLine();
			System.out.println("Enter the Contact:");
			String contact = sc.nextLine();
			System.out.println("Enter the ToDate:");
			String to_date = sc.nextLine();
			student.setName(name);
			student.setSurname(surname);
			student.setAddress(address);
			student.setContact(contact);
			Date currentdate;
			currentdate = sdf.parse(to_date);
			student.setTo_date(currentdate);
			try {
				boolean result = studentService.addStudent(student);
				if (result)
					System.out.println("Succesfuly adding");
				else
					System.out.println("Not success");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "3":
			util.StudentMethod.getStudent();
			System.out.println("Enter the Id:");
			int id = sc.nextInt();
			Student s = studentService.getStudentById(id);
			System.out.println("<-----Old----->\n\nName:" + s.getName() + "\nSurname:" + s.getSurname() + "\nContact:" + ""
					+ s.getContact() + "\nAddress:" + s.getAddress() + "\nToDate:" + s.getTo_date() + ""
					+ "\nFromDate:" + s.getFrom_date());
			sc.nextLine();
			System.out.println("Enter new Name:");
			String nameu = sc.nextLine();
			System.out.println("Enter new Surname:");
			String surnameu = sc.nextLine();
			System.out.println("Enter new Contact:");
			String contactu = sc.nextLine();
			System.out.println("Enter new Address:");
			String addressu = sc.nextLine();
			System.out.println("Enter new ToDate:");
			String to_Dateu = sc.nextLine();
			System.out.println("Enter new FromDate:");
			String from_Dateu = sc.nextLine();
			Student studentu = new Student();
			studentu.setName(nameu);
			studentu.setSurname(surnameu);
			studentu.setContact(contactu);
			studentu.setAddress(addressu);
			toDate = sdf.parse(to_Dateu);
			froDate = sdf.parse(from_Dateu);
			studentu.setTo_date(toDate);
			studentu.setFrom_date(froDate);
			try {
				boolean result = studentService.editStudent(studentu, id);
				if (result)
					System.out.println("Successfuly editing");
				else
					System.out.println("not success");
			} catch (Exception e) {
				e.printStackTrace();
			}

			break;
		case "4":
			StudentMethod.getStudent();
			System.out.print("Enter the Id");
			int idd = sc.nextInt();
			boolean delete = studentService.deleteStudent(idd);
			if (delete) {
				System.out.println("Successfly deleting");
			} else {
				System.out.println("not success");
			}
			break;
		case "5":
			System.out.println("Enter the keyword");
			String keyword = sc.nextLine();
			try {
				List<Student> list = studentService.getSearchStudent(keyword);
				if (!list.isEmpty()) {
					for (Student i : list) {
						System.out.println("\n<-----Serach Result----->\n" + "Id:"+i.getId() + "\nName:" + i.getName() + "\nSurname:" + i.getSurname()
								+ "\nContact:" + i.getContact() + "\nAddress:" + i.getAddress() + "\nToDate:" + i.getTo_date() + "\nFromDate:"
								+ i.getFrom_date());
					}
				} else {
					System.err.println("Data not found");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			break;

		default:
			System.err.println("Data not found");
			break;
		}

	}

}
