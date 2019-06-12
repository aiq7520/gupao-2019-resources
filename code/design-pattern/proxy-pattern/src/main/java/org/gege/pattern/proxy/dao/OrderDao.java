package org.gege.pattern.proxy.dao;

import org.gege.pattern.proxy.entity.Order;

/**
 * @author gege
 * @Description
 * @date 2019/3/19 14:15
 */
public class OrderDao {

    public int save(Order order){
        System.out.println("Dao : 保存订单！！！！");
        System.out.println(order.toString());
        return 1;
    }

}
