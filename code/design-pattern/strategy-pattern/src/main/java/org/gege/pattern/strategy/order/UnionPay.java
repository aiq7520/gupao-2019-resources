package org.gege.pattern.strategy.order;

/**
 * @Description: 银联支付
 * @Author: gege
 * @CreateDate: 2019/3/22 11:44
 */
public class UnionPay extends   Payment{
    public String getName() {
        return "银联支付";
    }

    public double getBalance(String uid) {
        return 100;
    }
}