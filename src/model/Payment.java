package model;

import java.util.Date;

public class Payment extends Super {
	private int student_Id;
	private int lesson_Id;
	private int teacher_id;
	private Student student;
	private Lesson lesson;
	private Teacher teacher;
	private double amount;
	private Date created_date;
	private Date update_date;
	private int active;

	public Payment() {

	}

	public Payment(Student student, Lesson lesson, Teacher teacher, double amount, Date created_date, Date update_date,
			int active) {
		this.student = student;
		this.lesson = lesson;
		this.teacher = teacher;
		this.amount = amount;
		this.created_date = created_date;
		this.update_date = update_date;
		this.active = active;
	}

	public int getStudent_Id() {
		return student_Id;
	}

	public void setStudent_Id(int student_Id) {
		this.student_Id = student_Id;
	}

	public int getLesson_Id() {
		return lesson_Id;
	}

	public void setLesson_Id(int lesson_Id) {
		this.lesson_Id = lesson_Id;
	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Payment [student=" + student + ", lesson=" + lesson + ", teacher=" + teacher + ", amount=" + amount
				+ ", created_date=" + created_date + ", update_date=" + update_date + ", active=" + active + "]";
	}

}
