package dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.TeacherDao;
import model.Teacher;
import util.DBHelper;
import util.Util;

public class TeacherDaoImpl implements TeacherDao {

	@Override
	public List<Teacher> teacherList() throws Exception {
		List<Teacher> teachers = new ArrayList<Teacher>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select id,name,surname,profession,contact,created_date,uptade_date from teacher\r\n"
				+ "where active=1";
		try {
			c = DBHelper.connection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Teacher teacher = new Teacher();
					teacher.setId(rs.getInt("id"));
					teacher.setName(rs.getString("name"));
					teacher.setSurname(rs.getString("surname"));
					teacher.setProfession(rs.getString("profession"));
					teacher.setContact(rs.getString("contact"));
					teacher.setCreatedDate(rs.getDate("created_date"));
					teacher.setUptadeDate(rs.getDate("uptade_date"));
					teachers.add(teacher);
				}
			} else {
				System.out.println("Connection is null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(c, ps, rs);
		}
		return teachers;
	}

	@Override
	public boolean addTeacher(Teacher teacher) throws Exception {
		Connection c = null;
		PreparedStatement ps = null;
		boolean result = false;
		String sql = "insert into teacher (name,surname,profession,contact,created_date)\r\n"
				+ "values(?,?,?,?,?)";
		try {
			c=DBHelper.connection();
			if(c!=null) {
				ps=c.prepareStatement(sql);
				ps.setString(1, teacher.getName());
				ps.setString(2, teacher.getSurname());
				ps.setString(3, teacher.getProfession());
				ps.setString(4, teacher.getContact());
				ps.setDate(5, new java.sql.Date(teacher.getCreatedDate().getTime()));
				ps.execute();
				result = true;

				
			}else {
				System.out.println("Connection is null");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Util.close(c, ps);
		}
		return result;
	}

	@Override
	public Teacher getTeacherBy(int id) throws Exception {
		Teacher teacher=new Teacher();
		Connection c=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select id,name,surname,profession,contact,created_date,uptade_date from teacher where id=?";
		try {
			c=DBHelper.connection();
		
			if(c!=null) {
				ps=c.prepareStatement(sql);
				ps.setInt(1, id);
				rs=ps.executeQuery();
				if(rs.next()) {
					teacher.setId(rs.getInt("id"));
					teacher.setName(rs.getString("name"));
					teacher.setSurname(rs.getString("surname"));
					teacher.setProfession(rs.getString("profession"));
					teacher.setContact(rs.getString("contact"));
					teacher.setCreatedDate(rs.getDate("created_date"));
					teacher.setUptadeDate(rs.getDate("uptade_date"));
				}else{
					teacher=null;
				}
			}else {
				System.out.println("connection is null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Util.close(c, ps,rs);
		}
		return teacher;
	}

	@Override
	public boolean editTeacher(Teacher teacher, int id) throws Exception {
		Connection c=null;
		PreparedStatement ps=null;
		boolean result=false;
		String sql="Update teacher set name=?,surname=?,profession=?,contact=?,created_date=?,uptade_date=?\r\n"
				+ "where id=?";
		try {
			c=DBHelper.connection();
			if(c!=null) {
				ps=c.prepareStatement(sql);
				ps = c.prepareStatement(sql);
				ps.setString(1, teacher.getName());
				ps.setString(2, teacher.getSurname());
				ps.setString(3, teacher.getProfession());
				ps.setString(4, teacher.getContact());
				ps.setDate(5, new java.sql.Date(teacher.getCreatedDate().getTime()));
				ps.setDate(6, new java.sql.Date(teacher.getUptadeDate().getTime()));
				ps.setInt(7, id);
				ps.execute();
				result=true;
			}else {
				System.out.println("Connection is null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Util.close(c, ps);
		}
		return result;
	}

	@Override
	public boolean deleteTeacher(int id) throws Exception {
		boolean result=false;
		Connection c=null;
		PreparedStatement ps=null;
		String Sql="Update teacher set active=0\r\n"
				+ "where id=?";
		try {
			c=DBHelper.connection();
			if(c!=null) {
				ps=c.prepareStatement(Sql);
				ps.setInt(1, id);
				ps.execute();
				result=true;
			}else {
				System.err.println("Connection is null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Util.close(c, ps);
		}
		return result;
	}

	@Override
	public List<Teacher> getSearchTeacher(String keyword) throws Exception {
		List<Teacher>teachers=new ArrayList<Teacher>();
		Connection c=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select id,name,surname,profession,contact,created_date,uptade_date from teacher\r\n"
				+ "where active=1 and name  like(?) or surname like(?)";
		try {
			c=DBHelper.connection();
			if(c!=null) {
				ps=c.prepareStatement(sql);
				ps.setString(1, "%" + keyword + "%");
				ps.setString(2, "%" + keyword + "%");
				rs = ps.executeQuery();
				while(rs.next()) {
					Teacher teacher=new Teacher();
					teacher.setId(rs.getInt("id"));
					teacher.setName(rs.getString("name"));
					teacher.setSurname(rs.getString("surname"));
					teacher.setProfession(rs.getString("profession"));
					teacher.setContact(rs.getString("contact"));
					teacher.setCreatedDate(rs.getDate("created_date"));
					teacher.setUptadeDate(rs.getDate("uptade_date"));
					teachers.add(teacher);
				}
			}else {
				System.out.println("Connection is null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Util.close(c, ps);
		}
	
		return teachers;
	}

}
