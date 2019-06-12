package org.gege.pattern.proxy.service;

import org.gege.pattern.proxy.dao.OrderDao;
import org.gege.pattern.proxy.entity.Order;

/**
 * @author gege
 * @Description
 * @date 2019/3/19 14:11
 */
public class OrderService implements  IOrderService{

    private OrderDao orderDao= new OrderDao();

    public int save(Order order){
        return orderDao.save(order);
    }
}
