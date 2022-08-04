package util;

import java.util.List;

import dao.PaymentDao;
import dao.impl.PaymentDaoImpl;
import model.Payment;
import service.PaymentService;
import service.impl.PaymentServiceImpl;

public class PaymentMethod {
	public static void getPayment() throws Exception {
		PaymentDao paymentDao = new PaymentDaoImpl();
		PaymentService paymentService = new PaymentServiceImpl(paymentDao);
		List<Payment> list = paymentService.paymentList();
		list.stream().forEach(PaymentMethod::printPayment);

	}

	public static void printPayment(Payment p) {
		System.out.println("Id:"+p.getId() + "\nStudentName:" + p.getStudent().getName() + "\nStudentSurname:" + p.getStudent().getSurname() + "\nLessonName:"
				+ p.getLesson().getLesson_name() + "\nTeacherName:" + p.getTeacher().getName() + "\nTeacherSurname:" + p.getTeacher().getSurname()
				+ "\nAmount:" + p.getAmount() +"\nCreatedDate:"+ p.getCreated_date()+"\n");
	}
}
