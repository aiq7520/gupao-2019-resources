package org.gege.pattern.proxy.entity;

import java.util.Date;

/**
 * @author gege
 * @Description  实体类
 * @date 2019/3/19 14:09
 */
public class Order {
    private Object orderInfo;
    private Date createTime;
    private String id;

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

    @Override
    public String toString() {
        return "Order{" +
                "orderInfo=" + orderInfo +
                ", createTime=" + createTime +
                ", id='" + id + '\'' +
                '}';
    }
}
