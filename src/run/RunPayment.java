package run;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import dao.PaymentDao;
import dao.impl.PaymentDaoImpl;
import dao.impl.TeacherDaoImpl;
import model.Lesson;
import model.Payment;
import model.Student;
import model.Teacher;
import service.PaymentService;
import service.TeacherService;
import service.impl.PaymentServiceImpl;
import util.PaymentMethod;


public class RunPayment {

	public static void runPayment() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date toDate, froDate;
		Scanner sc = new Scanner(System.in);
		PaymentDao paymentDao = new PaymentDaoImpl();
		PaymentService paymentService = new PaymentServiceImpl(paymentDao);
		System.out.println("1-List\n2-Add\n3-Edit\n4-Delete\n5-Search");
		String select = sc.nextLine();
		switch (select) {
		case "1":
			try {
				PaymentMethod.getPayment();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "2":
			Payment payment = new Payment();
			System.out.println("Enter the Student.Id:");
			int sId = sc.nextInt();
			Student student = new Student();
			student.setId(sId);
			payment.setStudent(student);
			System.out.println("Enter the Lesson.Id:");
			int lid = sc.nextInt();
			Lesson lesson = new Lesson();
			lesson.setId(lid);
			payment.setLesson(lesson);
			System.out.println("Enter the Teacher.Id:");
			int tId = sc.nextInt();
			Teacher teacher = new Teacher();
			teacher.setId(tId);
			payment.setTeacher(teacher);
			System.out.println("Enter the Amount:");
			double amount = sc.nextDouble();
			payment.setAmount(amount);
			System.out.println("Enter the CreatedDate:");
			String date = sc.nextLine();
//			Date currentdate;
//			currentdate = sdf.parse(date);
//			payment.setCreated_date(currentdate);


			try {
				boolean result = paymentService.addPayment(payment);
				if (result)
					System.out.println("Succesfuly adding");
				else
					System.out.println("Not Success");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "3":
			PaymentMethod.getPayment();

			System.out.println("Enter the Id:");
			int id = sc.nextInt();
			Payment p = paymentService.getPaymentById(id);
			System.out.println("<-----Old----->\n\nSudentName:" + p.getStudent().getName() + "\nStudentSurname:" + p.getStudent().getSurname() + "\nLessonName:"
					+ p.getLesson().getLesson_name() + "\nTeacherName:" + p.getTeacher().getName() + "\nTeacherSurname:"
					+ p.getTeacher().getSurname() + "\nAmount" + p.getAmount() + "\nCreatedDate:" + p.getCreated_date() + "\nUpdateDate:"
					+ p.getUpdate_date());
			Payment paymentU = new Payment();
			System.out.println();
			System.out.println("Enter the New Student.Id:");
			int idStudentU = sc.nextInt();
			System.out.println("Enter the New Lesson.Id:");
			int idLessonU = sc.nextInt();
			System.out.println("Enter the New Teacher.Id:");
			int idTeacherU = sc.nextInt();
			System.out.println("Enter the Amount:");
			int amountU = sc.nextInt();
//			sc.nextLine();
//			System.out.println("Enter the New CreatedDate:");
//			String cDate=sc.nextLine();
//			System.out.println("Enter the New UpdateDAte:");
//			String uDate=sc.nextLine();
			paymentU.setStudent_Id(idStudentU);
			paymentU.setLesson_Id(idLessonU);
			paymentU.setTeacher_id(idTeacherU);
			paymentU.setAmount(amountU);
//			toDate = sdf.parse(cDate);
//			froDate = sdf.parse(uDate);
//			paymentU.setCreated_date(toDate);
//			paymentU.setCreated_date(froDate);
			boolean edit = paymentService.editPayment(paymentU, id);
			if (edit)
				System.out.println("Successfuly editing");
			else
				System.out.println("Not Success");
			break;
		case "4":
			PaymentMethod.getPayment();
			System.out.println("Enter the id:");
			int idDelete = sc.nextInt();
			boolean delete = paymentService.deletePayment(idDelete);
			if (delete) {
				System.out.println("Successfly deleting");
			} else {
				System.out.println("Not Success");
			}
			break;
		case "5":
			System.out.println("Enter the  keyword:");
			String keyword = sc.nextLine();
			try {
				List<Payment> list = paymentService.getSearchPayment(keyword);
				if (!list.isEmpty()) {
					for (Payment i : list) {
						System.out.println("\n<-----Serach Result----->\nId:"+i.getId() + "\nStudentName:" + i.getStudent().getName() + "\nStudentSurname:"
								+ i.getStudent().getSurname() + "\nLessonName:" + i.getLesson().getLesson_name() + "\nTeacherName:"
								+ i.getTeacher().getName() + "\nTeacherName:" + i.getTeacher().getSurname() + "\nAmount: " + i.getAmount()
								+ "\nCreatedDate" + i.getCreated_date()+"\nUpdateDate:"+i.getUpdate_date());
					}
				} else {
					System.err.println("Data Not Found");
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
