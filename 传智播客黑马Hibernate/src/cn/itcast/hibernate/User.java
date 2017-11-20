package cn.itcast.hibernate;

public class User {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "[id="+id+" name="+name+"]";
	}
}
