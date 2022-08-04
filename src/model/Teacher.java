package model;

import java.util.Date;

public class Teacher extends Super {
	private String name;
	private String surname;
	private String profession;
	private String contact;
	private Date createdDate;
	private Date uptadeDate;
	private int active;

	public Teacher() {
	}

	public Teacher(String name, String surname, String profession, String contact, Date createdDate, Date uptadeDate,
			int active) {
		super();
		this.name = name;
		this.surname = surname;
		this.profession = profession;
		this.contact = contact;
		this.createdDate = createdDate;
		this.uptadeDate = uptadeDate;
		this.active = active;
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

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUptadeDate() {
		return uptadeDate;
	}

	public void setUptadeDate(Date uptadeDate) {
		this.uptadeDate = uptadeDate;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Teacher [name=" + name + ", surname=" + surname + ", profession=" + profession + ", contact=" + contact
				+ ", createdDate=" + createdDate + ", uptadeDate=" + uptadeDate + ", active=" + active + "]";
	}

}
