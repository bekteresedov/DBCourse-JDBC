package model;

import java.util.Date;

public class Student extends Super {

	private String name;
	private String surname;
	private String address;
	private String contact;
	private Date to_date;
	private Date from_date;
	private int active;
	private Group group;

	public Student(String name, String surname, String address, String contact, Date to_date, Date from_date,
			int active, Group group) {
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.contact = contact;
		this.to_date = to_date;
		this.from_date = from_date;
		this.active = active;
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Student() {

	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Date getTo_date() {
		return to_date;
	}

	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}

	public Date getFrom_date() {
		return from_date;
	}

	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Student [  name=" + name + ", surname=" + surname + ", address=" + address + ", contact=" + contact
				+ ", to_date=" + to_date + ", from_date=" + from_date + ", active=" + active + ", group=" + group + "]";
	}

}
