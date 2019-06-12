package org.gege.pattern.prototype.entity;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author gege
 * @Description
 * @date 2019/3/20 13:55
 */
public class OrderTest {

    @Test
    public void cloneable() {
        Order order = new Order();
        order.setId("1");
        order.setCreateTime(new Date());
        List<String> iteminfo = new ArrayList();
        iteminfo.add("demo");
        order.setItemsInfo(iteminfo);
        order.setOrderInfo(new Object());
        System.out.println(order);

        //clone
        Order  cloneOrder = (Order) order.cloneable();
        System.out.println(cloneOrder);
        System.out.println("克隆对象中的引用类型地址值：" + order.getItemsInfo());
        System.out.println("原对象中的引用类型地址值：" +cloneOrder.getItemsInfo());
        System.out.println("对象地址比较："+(order.getOrderInfo() ==cloneOrder.getOrderInfo()));
    }
}