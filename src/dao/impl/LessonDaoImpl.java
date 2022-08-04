package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.LessonDao;
import model.Lesson;
import util.DBHelper;
import util.Util;

public class LessonDaoImpl implements LessonDao {

	@Override
	public List<Lesson> lessonList() throws Exception {
		List<Lesson> lessons = new ArrayList<Lesson>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select id,lesson_name,created_date from lesson\r\n" + "where active=1";
		try {
			c = DBHelper.connection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Lesson lesson = new Lesson();
					lesson.setId(rs.getInt("id"));
					lesson.setLesson_name(rs.getString("lesson_name"));
					lesson.setCreated_date(rs.getDate("created_date"));
					lessons.add(lesson);
				}
			} else {
				System.out.println("Connection is null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(c, ps, rs);
		}
		return lessons;
	}

	@Override
	public boolean addLesson(Lesson lesson) throws Exception {
		boolean result = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "insert into lesson(lesson_name,created_date)\r\n" + "values(?,?)";
		try {
			c = DBHelper.connection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setString(1, lesson.getLesson_name());
				ps.setDate(2, new java.sql.Date(lesson.getCreated_date().getTime()));
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
	public Lesson getLessonById(int id) throws Exception {
		Lesson lesson = new Lesson();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="select id,lesson_name,created_date from lesson\r\n"
				+ "where id=?";
		try {
			c=DBHelper.connection();
			if(c!=null) {
				ps=c.prepareStatement(sql);
				ps.setInt(1, id);
				rs=ps.executeQuery();
				if(rs.next()) {
				lesson.setId(rs.getInt("id"));
				lesson.setLesson_name(rs.getString("lesson_name"));
				lesson.setCreated_date(rs.getDate("created_date"));
				}else {
					lesson=null;
				}
			}else {
				System.out.println("Connection is null");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Util.close(c, ps,rs);
		}

		return lesson;
	}

	@Override
	public boolean editLesson(Lesson lesson, int id) throws Exception {
		boolean result=false;
		Connection c=null;
		PreparedStatement ps=null;
		String sql="UPDATE lesson set lesson_name=?,created_date=?\r\n"
				+ "where id=?";
		try {
			c=DBHelper.connection();
			if(c!=null) {
				ps=c.prepareStatement(sql);
				ps.setString(1, lesson.getLesson_name());
				ps.setDate(2, new java.sql.Date(lesson.getCreated_date().getTime()));
				ps.setInt(3, id);
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
	public boolean deleteLesson(int id) throws Exception {
		boolean result=false;
		Connection c=null;
		PreparedStatement ps=null;
		String sql="Update lesson set active = 0 where id= ?";
		try {
			c=DBHelper.connection();
			if(c!=null) {
				ps=c.prepareStatement(sql);
				ps.setInt(1, id);
				ps.execute();
				result=true;
			}else {
				System.out.println("connection is null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Util.close(c, ps);
		}
		return result;
	}

	@Override
	public List<Lesson> getSerachLessson(String keyword) throws Exception {
		List<Lesson> lessons=new ArrayList<Lesson>();
		Connection c=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select  id,lesson_name,created_date from lesson\r\n"
				+ "where active=1 and lesson_name like(?)";
		try {
			c=DBHelper.connection();
			if(c!=null) {
				ps=c.prepareStatement(sql);
				ps.setString(1, "%" + keyword + "%");
				rs=ps.executeQuery();
				while(rs.next()) {
					Lesson lesson=new Lesson();
					lesson.setId(rs.getInt("id"));
					lesson.setLesson_name(rs.getString("lesson_name"));
					lesson.setCreated_date(rs.getDate("created_date"));
					lessons.add(lesson);
					
				}
			}else {
				System.out.println("Connection is null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Util.close(c, ps);
		}
		
		return lessons;
	}

}
