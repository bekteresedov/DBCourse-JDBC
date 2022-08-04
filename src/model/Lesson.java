package model;

import java.util.Date;

public class Lesson  extends Super{
	private String lesson_name;
	private Date created_date;
	private int  active;
	
	public Lesson() {
	}

	public Lesson(String lesson_name, Date created_date, int active) {
	
		this.lesson_name = lesson_name;
		this.created_date = created_date;
		this.active = active;
	}

	public String getLesson_name() {
		return lesson_name;
	}

	public void setLesson_name(String lesson_name) {
		this.lesson_name = lesson_name;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Lesson [lesson_name=" + lesson_name + ", created_date=" + created_date + ", active=" + active + "]";
	}
	

}
