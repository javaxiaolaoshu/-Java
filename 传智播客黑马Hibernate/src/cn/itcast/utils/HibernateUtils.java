package cn.itcast.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	// 全局只需要有一个就行了
	private static SessionFactory sessionFactory;
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
//		Configuration cfg=new Configuration();
//		cfg.setProperty(key, value);
//		cfg.setProperty(key, value);
//		.
//		.
	}

	/**
	 * configure()默认配置文件 
	 * configure(String resource)指定的配置文件
	 * @return 获取全局唯一的SessionFactory工厂
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * 从全局SessionFactory中打开一个session
	 * @return
	 */
	public static Session openSession() {
		return sessionFactory.openSession();
	}
}
