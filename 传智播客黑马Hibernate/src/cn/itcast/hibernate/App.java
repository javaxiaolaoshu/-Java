package cn.itcast.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {
	    //初始化
	private static SessionFactory sessionFactory;
	static {
	    //读取指定的主配置文件
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
		sessionFactory=cfg.buildSessionFactory();//根据配置生成session工产
		
	}
	@Test
	public void testSave() {
		User user=new User();
		user.setName("张三");
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();//开启事物
		session.save(user);
		tx.commit();//提交事物
		session.close();
	}
	@Test
	public void testGet() {
		Session session=sessionFactory.openSession();
		User user=(User) session.get(User.class, 1);
		System.out.println(user.getName());
		session.close();
	}
}
