package dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.StudentDao;
import model.Group;
import model.Student;
import util.DBHelper;
import util.Util;

public class StudentDaoimpl implements StudentDao {

	@Override
	public List<Student> studentList() throws Exception {
		List<Student> studentList = new ArrayList<Student>();
		Connection c = null;
		PreparedStatement ps = null; // sql-i runa hazirlasdirir.
		ResultSet rs = null; // sql den gelen neticeni ozunde saxliyir.
		String sql = "Select s.id,s.name,s.surname,s.contact,s.address,s.to_date,s.from_date,s.active,g.group_name from student s\r\n"
				+ "inner join group_class g on s.group_id=g.id\r\n" + "where s.active=1";
		try {
			c = DBHelper.connection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Student student = new Student();
					Group group = new Group();
					student.setId(rs.getInt("id"));
					student.setName(rs.getString("name"));
					student.setSurname(rs.getString("surname"));
					student.setContact(rs.getString("contact"));
					student.setAddress(rs.getString("address"));
					student.setTo_date(rs.getDate("to_date"));
					student.setFrom_date(rs.getDate("from_date"));
					group.setGroup_name(rs.getString("group_name"));
					student.setGroup(group);
					studentList.add(student);
				}

			} else {
				System.out.println("Connnection is null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(c, ps, rs);

		}
		return studentList;
	}

	@Override
	public boolean addStudent(Student student) throws Exception {
		boolean result = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO student(name,surname,contact,address,to_date)\r\n" + "values(?,?,?,?,?)";
		try {
			c = DBHelper.connection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setString(1, student.getName());
				ps.setString(2, student.getSurname());
				ps.setString(3, student.getContact());
				ps.setString(4, student.getAddress());
				ps.setDate(5, new java.sql.Date(student.getTo_date().getTime()));
				ps.execute();
				result = true;

			} else {
				System.out.println("Connection is null");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			Util.close(c, ps);
		}
		return result;
	}

	@Override
	public Student getStudentById(int id) throws Exception {
		Student student = new Student();
		Connection c = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = "Select id,name,surname,contact,address,to_date,from_date from student\r\n" + "where id=?";
		try {
			c = DBHelper.connection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				if (rs.next()) {
					student.setId(rs.getInt("id"));
					student.setName(rs.getString("name"));
					student.setSurname(rs.getString("surname"));
					student.setContact(rs.getString("contact"));
					student.setAddress(rs.getString("address"));
					student.setTo_date(rs.getDate("to_date"));
					student.setFrom_date(rs.getDate("from_date"));

				} else {
					student = null;
				}

			} else {
				System.out.println("Connection is null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(c, ps, rs);
		}

		return student;
	}

	@Override
	public boolean editStudent(Student student, int id) throws Exception {
		Connection c = null;
		PreparedStatement ps = null;
		boolean result = false;
		String sql = "Update student set name=?,surname=?,contact=?,address=?,to_date=?,from_date=?\r\n" + "where id=?";
		try {
			c = DBHelper.connection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setString(1, student.getName());
				ps.setString(2, student.getSurname());
				ps.setString(3, student.getContact());
				ps.setString(4, student.getAddress());
				ps.setDate(5, new java.sql.Date(student.getTo_date().getTime()));
				ps.setDate(6, new java.sql.Date(student.getFrom_date().getTime()));
				ps.setInt(7, id);
				ps.execute();
				result = true;

			} else {
				System.out.println("Connection is null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(c, ps);
		}

		return result;
	}

	@Override
	public boolean deleteStudent(int id) throws Exception {
		Connection c = null;
		PreparedStatement ps = null;
		boolean result = false;
		String sql = "Update student set active = 0 where id= ?";
		try {
			c = DBHelper.connection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setInt(1, id);
				ps.execute();
				result = true;
			} else {
				System.out.println("Connection is null");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(c, ps);
		}
		return result;
	}

	@Override
	public List<Student> getSearchStudent(String keyword) throws Exception {
		List<Student> students = new ArrayList<Student>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select id,name,surname,contact,address,to_date,from_date from student\r\n"
				+ "where active=1 and name like(?)or surname like(?)";
		try {
			c = DBHelper.connection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setString(1, "%" + keyword + "%");
				ps.setString(2, "%" + keyword + "%");
				rs = ps.executeQuery();
				while (rs.next()) {
					Student student = new Student();
					student.setId(rs.getInt("id"));
					student.setName(rs.getNString("name"));
					student.setSurname(rs.getNString("surname"));
					student.setContact(rs.getNString("contact"));
					student.setAddress(rs.getNString("address"));
					student.setTo_date(rs.getDate("to_date"));
					student.setFrom_date(rs.getDate("from_date"));
					students.add(student);

				}
			} else {
				System.out.println("Connection is null");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(c, ps, rs);
		}
		return students;
	}

}
