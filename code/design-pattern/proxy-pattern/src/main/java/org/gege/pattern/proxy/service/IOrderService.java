package org.gege.pattern.proxy.service;

import org.gege.pattern.proxy.dao.OrderDao;
import org.gege.pattern.proxy.entity.Order;

/**
 * @author gege
 * @Description
 * @date 2019/3/19 14:11
 */
public interface IOrderService {
    public int save(Order order);
}
