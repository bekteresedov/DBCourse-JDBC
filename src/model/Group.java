package model;

public class Group {
	private int id;
	private String group_name;

	public Group() {
	}

	public Group(int id, String group_name) {

		this.id = id;
		this.group_name = group_name;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	@Override
	public String toString() {
		return "Group [id=" + id + ", group_name=" + group_name + "]";
	}

	
}
