package cn.itcast.aop;

import java.lang.reflect.Method;

import cn.itcast.service.impl.PersonServiceBean;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
//cglib可以生产目标类的子类，并重写父类非final修饰符的方法
public class CGlibProxyFactory implements MethodInterceptor{
	private Object targetObject;  //代理的目标对象
	public Object creatProxyInstance(Object targetObject) {
		this.targetObject = targetObject;
		Enhancer enhancer=new Enhancer();//该类用于生成代理对象
		enhancer.setSuperclass(targetObject.getClass());//产生目标对象的子类
		enhancer.setCallback(this);//设置回调对象本身
		return enhancer.create();
	}
	@Override   //代理的目标对象，回调方法，方法参数，代理方法
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		Object result = null;
		PersonServiceBean bean = (PersonServiceBean) this.targetObject;
		if (bean.getUser() != null) {
			result = method.invoke(targetObject, args);
		}
		return result;
	}
}
