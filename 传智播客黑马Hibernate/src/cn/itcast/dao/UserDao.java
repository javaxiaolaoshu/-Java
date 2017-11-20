package cn.itcast.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import cn.itcast.hibernate.User;
import cn.itcast.utils.HibernateUtils;

public class UserDao {
	/**
	 * 保存
	 * 
	 * @param user
	 */
	public void save(User user) {
		Session session = HibernateUtils.openSession(); // 创建Session对象
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); // 开启事物
			session.save(user); // 保存事物
			tx.commit(); // 提交事物
		} catch (HibernateException e) {
			tx.rollback(); // 失去回滚
			e.printStackTrace();
		} finally {
			session.close(); // 关闭Session
		}
	}

	/**
	 * 更新
	 * 
	 * @param user
	 */
	public void update(User user) {
		Session session = HibernateUtils.openSession(); // 创建Session对象
		//Transaction tx = null;
		try {
			Transaction tx = session.beginTransaction();
			session.update(user);
			tx.commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();//getTransaction()方法下的回滚
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void delete(int id) {
		Session session = HibernateUtils.openSession(); // 创建Session对象
		Transaction tx = null;
		try {
			Object user = session.get(User.class, id);// 先获取到对象
			tx = session.beginTransaction();
			session.delete(user); // 删除的是实体类型
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/**
	 * 根据id查询一个数据
	 * 
	 * @param id
	 * @return
	 */
	public User getById(int id) {
		Session session = HibernateUtils.openSession(); // 创建Session对象
		Transaction tx = null;
		try {
			User user = (User) session.get(User.class, id);
			return user;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		Session session = HibernateUtils.openSession(); // 创建Session对象
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
/**
* 惟一值查询：session.createQuery("HQL")
* .uniqueResult()
* 集合查询：
* .list()
* @author asus
*/
			  //方式一：使用HQL查询 
			  List<User> list = session.createQuery("from User")// 
					  .list();
			  //以sql相似，查询的是对象、对象中的属性
			 
			/*
			 * // 方式二：使用Criteria查询
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("id", 5));
			criteria.addOrder(Order.asc("id"));
			List<User> list = criteria.list();
			*/

			tx.commit();
			return list;
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	/**
	 * 分页的查询数据列表
	 * 
	 * @param firstResult
	 *            从结果列表的那个数据开始取数据
	 * @param maxResults
	 *            最多取多少条数据
	 * @return 一页的数据列表+总记录数
	 */
	@SuppressWarnings("unchecked")
	public QueryList findAll(int firstResult, int maxResults) {
		Session session = HibernateUtils.openSession(); // 创建Session对象
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// 查询一页的数据列表
			/*
			 * Query query=session.createQuery("from User");
			 * query.setFirstResult(firstResult); query.setMaxResults(maxResults);
			 */
			// 方法链
			List<User> list = session.createQuery(//
					"from User")//
					.setFirstResult(firstResult)//
					.setMaxResults(maxResults)//
					.list();
			// 查询总记录数
			/*
			 * session.createQuery("select count(*) from User").list().get(0);
			 */
			Long count = (Long) session.createQuery(//
					"select count(*) from User")//
					.uniqueResult();
			tx.commit();
			// 返回结果
			return new QueryList(count.intValue(), list);
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}
}
