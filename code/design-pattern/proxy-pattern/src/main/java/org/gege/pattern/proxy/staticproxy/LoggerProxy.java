package org.gege.pattern.proxy.staticproxy;

import org.gege.pattern.proxy.entity.Order;
import org.gege.pattern.proxy.service.IOrderService;
import org.gege.pattern.proxy.service.OrderService;

/**
 * @author gege
 * @Description 代理类
 * @date 2019/3/19 14:17
 */
public class LoggerProxy {

    //被代理对象
    private IOrderService orderService ;

    public LoggerProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    public  int save(Order order){
        System.out.println("保存开始");
        int i = orderService.save(order);
        System.out.println("保存结束");
        return i;
    }
}
