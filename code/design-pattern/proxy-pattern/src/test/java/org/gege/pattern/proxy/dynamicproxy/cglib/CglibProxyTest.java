package org.gege.pattern.proxy.dynamicproxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import org.gege.pattern.proxy.dao.OrderDao;
import org.gege.pattern.proxy.entity.Order;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author gege
 * @Description
 * @date 2019/3/19 16:52
 */
public class CglibProxyTest {

    @Test
    public void getProxyInstance() {
        CglibProxy cglibProxy = new CglibProxy(OrderDao.class);
        OrderDao orderDao= (OrderDao)cglibProxy.getProxyInstance();
        Order order = new Order();
        order.setId("1");
        order.setCreateTime(new Date());
        order.setOrderInfo(new Object());
        orderDao.save(order);
    }
    @Test
    public void write() {
        try {
//利用 cglib 的代理类可以将内存中的 class 文件写入本地磁盘
            System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
                    "F:\\github\\gupao-2019-resources\\code\\design-pattern\\proxy-pattern\\cglibclass");
            CglibProxy cglibProxy = new CglibProxy(OrderDao.class);
            OrderDao orderDao= (OrderDao)cglibProxy.getProxyInstance();
            Order order = new Order();
            order.setId("1");
            order.setCreateTime(new Date());
            order.setOrderInfo(new Object());
            orderDao.save(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}