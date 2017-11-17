package cn.itcast.aoptest;

import org.junit.jupiter.api.Test;
import cn.itcast.aop.JDKProxyFactory;
import cn.itcast.service.PersonService;
import cn.itcast.service.impl.PersonServiceBean;

public class Aoptest {
	@Test    //客户端程序
	public void proxyTest() {
		JDKProxyFactory factory=new JDKProxyFactory();
		PersonService service=(PersonService) factory.creatProxyInstance(new PersonServiceBean("xxx"));
		service.update("w", 20);
	}
}