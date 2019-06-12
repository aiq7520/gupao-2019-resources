package org.gege.pattern.proxy.dynamicproxy.jdk;

import org.gege.pattern.proxy.entity.Order;
import org.gege.pattern.proxy.service.IOrderService;
import org.gege.pattern.proxy.service.OrderService;
import org.gege.pattern.proxy.staticproxy.LoggerProxy;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author gege
 * @Description
 * @date 2019/3/19 15:22
 */
public class ServiceInvocationHandlerTest {

    @Test
    public void invokeProxy() {

        Order order = new Order();
        order.setId("1");
        order.setCreateTime(new Date());
        order.setOrderInfo(new Object());


        OrderService orderService = new OrderService();

        ServiceInvocationHandler serviceInvocationHandler = new ServiceInvocationHandler(orderService);
        IOrderService proxy = (IOrderService) serviceInvocationHandler.newInstance();
        proxy.save(order);
    }

    @Test
    public void invokeProxyClass() {

        Order order = new Order();
        order.setId("1");
        order.setCreateTime(new Date());
        order.setOrderInfo(new Object());


        OrderService orderService = new OrderService();

        ServiceInvocationHandler serviceInvocationHandler = new ServiceInvocationHandler(orderService);
        IOrderService proxy = (IOrderService) serviceInvocationHandler.newInstance();
        System.out.println(proxy.getClass());//class com.sun.proxy.$Proxy4

        //我们来研究生成的代理类
        try {
            //通过反编译工具可以查看源代码
            byte [] bytes = ProxyGenerator.generateProxyClass("$Proxy4",new Class[]{OrderService.class});
            FileOutputStream os = new FileOutputStream("$Proxy4.class");
            os.write(bytes);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}