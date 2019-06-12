package org.gege.pattern.prototype.entity;

import org.gege.pattern.prototype.Prototype;

import java.util.Date;
import java.util.List;

/**
 * @author gege
 * @Description  实体类
 * @date 2019/3/19 14:09
 */
public class Order implements Prototype {
    private Object orderInfo;
    private Date createTime;
    private String id;
    private List<String> itemsInfo;

    public Object getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Object orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getItemsInfo() {
        return itemsInfo;
    }

    public void setItemsInfo(List<String> itemsInfo) {
        this.itemsInfo = itemsInfo;
    }



    public Prototype cloneable() {
        Order order = new Order();
        order.setCreateTime(this.createTime);
        order.setId(this.id);
        order.setItemsInfo(this.itemsInfo);
        order.setOrderInfo(this.orderInfo);
        return order;
    }
}
