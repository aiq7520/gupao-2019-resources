package org.gege.pattern.strategy.order;

/**
 * @Description: 京东支付
 * @Author: gege
 * @CreateDate: 2019/3/22 11:42
 */
public class JDPay extends   Payment{
    public String getName() {
        return "京东支付";
    }

    public double getBalance(String uid) {
        return 500;
    }
}
