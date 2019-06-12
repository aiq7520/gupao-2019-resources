package org.gege.pattern.proxy.staticproxy;

import org.gege.pattern.proxy.entity.Order;
import org.gege.pattern.proxy.service.IOrderService;
import org.gege.pattern.proxy.service.OrderService;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author gege
 * @Description
 * @date 2019/3/19 14:22
 */
public class LoggerProxyTest {

    @Test
    public void save() {

        Order order = new Order();
        order.setId("1");
        order.setCreateTime(new Date());
        order.setOrderInfo(new Object());


        IOrderService orderService = new OrderService();

        //将被代理的对象传入到代理对象中
        LoggerProxy loggerProxy = new LoggerProxy(orderService);
        loggerProxy.save(order);

    }
}