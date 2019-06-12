package org.gege.pattern.strategy.order;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/22 14:39
 */
public abstract class Payment {
    //获取支付名称
    public abstract String getName();

    //获取支付余额
    public abstract double getBalance(String uid);

    //扣款支付
    public  PayState pay(String uid,double amount) {
        if(getBalance(uid)<amount)
            return new PayState(500,"支付余额不足",amount);
        return new PayState(200,"支付成功",amount);
    }
}
