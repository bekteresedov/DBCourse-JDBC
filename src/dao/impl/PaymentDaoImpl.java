package dao.impl;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PaymentDao;
import model.Lesson;
import model.Payment;
import model.Student;
import model.Teacher;
import util.DBHelper;
import util.Util;

public class PaymentDaoImpl implements PaymentDao {

	@Override
	public List<Payment> paymentList() throws Exception {
		List<Payment> payments = new ArrayList<Payment>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select p.id,s.name,s.surname,l.lesson_name,t.name,t.surname,p.amount,p.created_date,p.update_date from payment p\r\n"
				+ "inner join student s on p.student_id=s.id\r\n" + "inner join lesson l on p.lesson_id=l.id\r\n"
				+ "inner join teacher t on p.teacher_id=t.id\r\n" + "where p.active=1";
		try {
			c = DBHelper.connection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Student student = new Student();
					student.setName(rs.getString("s.name"));
					student.setSurname(rs.getString("s.surname"));
					Lesson lesson = new Lesson();
					lesson.setLesson_name(rs.getString("l.lesson_name"));
					Teacher teacher = new Teacher();
					teacher.setName(rs.getNString("t.name"));
					teacher.setSurname(rs.getString("t.surname"));
					Payment payment = new Payment();
					payment.setId(rs.getInt("p.id"));
					payment.setAmount(rs.getDouble("p.amount"));
					payment.setCreated_date(rs.getDate("p.created_date"));
					payment.setUpdate_date(rs.getDate("p.update_date"));
					payment.setStudent(student);
					payment.setLesson(lesson);
					payment.setTeacher(teacher);
					payments.add(payment);

				}
			} else {
				System.out.println("Connection is null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(c, ps, rs);
		}
		return payments;
	}

	@Override
	public boolean addPayment(Payment p) throws IOException {
		Connection con = null;
		PreparedStatement ps = null;
		boolean result = false;
		String sql = "insert into payment(student_id,lesson_id,teacher_id,amount)\r\n"
				+ "Values(?,?,?,?)";
		con = DBHelper.connection();

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, p.getStudent().getId());
			ps.setInt(2, p.getLesson().getId());
			ps.setInt(3, p.getTeacher().getId());
			ps.setDouble(4, p.getAmount());
//			ps.setDate(5, new java.sql.Date(p.getCreated_date().getTime()));
			ps.execute();
			result = true;

			if ((con != null)) {

			} else {
				System.out.println("Connection is null!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(con, ps);
		}

		return result;
	}

	@Override
	public Payment getPaymentById(int id) throws Exception {
		Payment payment = new Payment();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select p.id,s.name,s.surname,l.lesson_name,t.name,t.surname,p.amount,p.created_date,p.update_date from payment p\r\n"
				+ "inner join student s on p.student_id=s.id\r\n" + "inner join lesson l on p.lesson_id=l.id\r\n"
				+ "inner join teacher t on p.teacher_id=t.id\r\n" + "where p.id=?";
		try {
			con = DBHelper.connection();
			if (con != null) {
				ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				if (rs.next()) {
					Student student = new Student();
					student.setName(rs.getString("s.name"));
					student.setSurname(rs.getString("s.surname"));
					Lesson lesson = new Lesson();
					lesson.setLesson_name(rs.getString("l.lesson_name"));
					Teacher teacher = new Teacher();
					teacher.setName(rs.getNString("t.name"));
					teacher.setSurname(rs.getString("t.surname"));
					payment.setId(rs.getInt("p.id"));
					payment.setAmount(rs.getDouble("p.amount"));
					payment.setCreated_date(rs.getDate("p.created_date"));
					payment.setUpdate_date(rs.getDate("p.update_date"));
					payment.setStudent(student);
					payment.setLesson(lesson);
					payment.setTeacher(teacher);

				} else {
					payment = null;
				}
			} else {
				System.out.println("connection is null");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			Util.close(con, ps, rs);
		}
		return payment;
	}

	@Override
	public boolean editPayment(Payment p, int id) throws Exception {
		boolean result = false;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update payment set student_id=?,lesson_id=?,teacher_id=?,amount=?\r\n"
				+ "where id=?";
		try {
			con = DBHelper.connection();
			if (con != null) {
				ps = con.prepareStatement(sql);
				ps.setInt(1, p.getStudent_Id());
				ps.setInt(2, p.getLesson_Id());
				ps.setInt(3, p.getTeacher_id());
				ps.setDouble(4, p.getAmount());
//				ps.setDate(5, new java.sql.Date(p.getCreated_date().getTime()));
//				ps.setDate(6, new java.sql.Date(p.getUpdate_date().getTime()));		
				ps.setInt(5, id);
				ps.execute();
				result = true;
			} else {
				System.out.println("Connection is null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(con, ps);
		}
		return result;
	}

	@Override
	public boolean deletePayment(int id) throws Exception {
		boolean result = false;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "Update payment set active = 0 where id= ?";
		try {
			con = DBHelper.connection();
			if (con != null) {
				ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ps.execute();
				result = true;
			} else {
				System.out.println("connection is null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(con, ps);
		}
		return result;
	}

	@Override
	public List<Payment> getSearchPayment(String keyword) throws Exception {
		List<Payment> payments = new ArrayList<Payment>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select p.id,s.name,s.surname,l.lesson_name,t.name,t.surname,p.amount,p.created_date,p.update_date from payment p\r\n"
				+ "				inner join student s on p.student_id=s.id\r\n"
				+ "				inner join lesson l on p.lesson_id=l.id\r\n"
				+ "				inner join teacher t on p.teacher_id=t.id\r\n"
				+ "				where p.active=1 and s.name like(?)or s.surname like(?)or t.name like(?) or t.surname like(?) \r\n"
				+ "				or l.lesson_name like(?)";
		try {
			con = DBHelper.connection();
			if (con != null) {
				ps = con.prepareStatement(sql);
				ps.setString(1, "%" + keyword + "%");
				ps.setString(2, "%" + keyword + "%");
				ps.setString(3, "%" + keyword + "%");
				ps.setString(4, "%" + keyword + "%");
				ps.setString(5, "%" + keyword + "%");
				rs = ps.executeQuery();
				while (rs.next()) {
					Payment payment = new Payment();
					Student student = new Student();
					student.setName(rs.getString("s.name"));
					student.setSurname(rs.getString("s.surname"));
					payment.setStudent(student);
					Lesson lesson = new Lesson();
					lesson.setLesson_name(rs.getString("l.lesson_name"));
					payment.setLesson(lesson);
					Teacher teacher = new Teacher();
					teacher.setName(rs.getString("t.name"));
					teacher.setSurname(rs.getString("t.surname"));
					payment.setTeacher(teacher);
					payment.setId(rs.getInt("p.id"));
					payment.setAmount(rs.getDouble("p.amount"));
					payment.setCreated_date(rs.getDate("p.created_date"));
					payment.setUpdate_date(rs.getDate("p.update_date"));
					payments.add(payment);
				}
			} else {
				System.out.println("Connection is null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(con, ps, rs);
		}

		return payments;
	}

}
