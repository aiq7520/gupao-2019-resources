package org.gege.pattern.proxy.dynamicproxy.jdk;

import org.gege.pattern.proxy.service.OrderService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author gege
 * @Description
 * @date 2019/3/19 15:15
 */
public class ServiceInvocationHandler implements InvocationHandler {

    //定义被代理对象
    private OrderService orderService;

    public ServiceInvocationHandler(OrderService orderService) {
        this.orderService = orderService;
    }

    //获取代理类
    public Object newInstance(){
        Class clazz = orderService.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    //代理业务方法增强
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //proxy  jdk生成的代理类
        System.out.println("jdk实现动态代理：保存开始");
        Object obj = method.invoke(orderService,args);
        System.out.println("保存结束");
        return obj;
    }
}
