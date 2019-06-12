package org.gege.pattern.proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author gege
 * @Description cglib实现动态代理
 * @date 2019/3/19 16:18
 */
public class CglibProxy implements MethodInterceptor {

    private Class clazz;

    public CglibProxy(Class clazz) {
        this.clazz = clazz;
    }

    //实现MethodInterceptor接口，定义方法的拦截器
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before:" + method);
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("After:" + method);
        return object;
    }

    public Object getProxyInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }
}
