package cn.itcast.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.itcast.hibernate.User;
public class UserDaoTest {
	private UserDao userDao = new UserDao();

	@SuppressWarnings("deprecation")
	@Test
	public void testSave() throws IOException {
		User user = new User();
		InputStream in=new FileInputStream("d:/test.png");
		byte[] photo=new byte[in.available()];
		in.read(photo);
		in.close();
		
		user.setAge(20);
		user.setBirthday(new Date());
		user.setDesc("一大段文字，此处省略5000字......");
		user.setName("李剑");
		user.setPhoto(photo);
		userDao.save(user);
	}

	@Test
	public void testGetById() throws IOException {
		User user = userDao.getById(1);
		System.out.println(user.toString());
		
		OutputStream out=new FileOutputStream("d:/copy.png");
		out.write(user.getPhoto());
		out.close();
	}

	@Test
	public void testUpdate() {
		// 从数据库获取一条存在的数据
		User user = userDao.getById(2);
		user.setName("田冰清");
		// 更新
		userDao.update(user);
	}

	@Test
	public void testDelete() {
		userDao.delete(3);
	}

	@Test
	public void testFindAll() {
		List<User> user = (List<User>) userDao.findAll();
		for (User u : user) {
			System.out.println(u.getName());
		}
	}

	@Test
	public void testSave_25() {
		for (int i = 1; i <= 25; i++) {
			User user = new User();
			user.setName("李剑" + i);
			userDao.save(user);
		}
	}

	@Test
	public void testDelete_25() {
		for (int i = 4; i <= 29; i++) {
			userDao.delete(i);
		}
	}

	@Test
	public void testFindAllIntInt() {

		// 查询
		// QueryList list=userDao.findAll(0, 10);//第1页，每页10条
		// QueryList list=userDao.findAll(10, 10);//第2页，每页10条
		   QueryList list = userDao.findAll(20, 10);// 第3页，每页10条

		// 显示结果
		System.out.println("总记录数：" + list.getCount());
		for (Object u : list.getList()) {
			System.out.println(u);
		}
	}
}
