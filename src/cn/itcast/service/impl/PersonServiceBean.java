package cn.itcast.service.impl;

import cn.itcast.service.PersonService;

public class PersonServiceBean implements PersonService {
	private String user = null;
	public String getUser() {
		return user;
	}

	public PersonServiceBean() {
	}

	public PersonServiceBean(String user) {
		this.user = user;
	}

	@Override
	public void save(String name) {
		System.out.println("我是save()方法"+name);
	}

	@Override
	public void update(String name, Integer personid) {
		System.out.println("我是update()方法"+name+" "+personid);
	}

	@Override
	public String getPersonName(Integer personid) {
		System.out.println("我是getPersonName()方法"+personid);
		return Integer.toString(personid);
	}
}
