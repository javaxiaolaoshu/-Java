package cn.itcast.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.itcast.service.impl.PersonServiceBean;
public class JDKProxyFactory implements InvocationHandler {
	private Object targetObject;
	//创建代理-Proxy.newProxyInstance
	public Object creatProxyInstance(Object targetObject) {
		this.targetObject = targetObject;
		return Proxy.newProxyInstance(this.targetObject.getClass().getClassLoader(),this.targetObject.getClass().getInterfaces(), this);
	}
	//实现接口方法
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		PersonServiceBean bean = (PersonServiceBean) this.targetObject;
		if (bean.getUser() != null) {//简单的权限控制
			result = method.invoke(targetObject, args);
		}
		return result;
	}
}
