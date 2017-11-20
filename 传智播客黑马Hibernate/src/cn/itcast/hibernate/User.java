package cn.itcast.hibernate;

import java.util.Date;

public class User {
	private int id;
	private String name;
	private int age;
	private Date birthday;
	private String desc;
	private byte[] photo;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

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
		return "[id=" + id + ", name=" + name + ", age=" + age + ", birthday=" + birthday + "]";
	}
	
}
