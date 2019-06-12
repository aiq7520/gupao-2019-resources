package org.gege.pattern.strategy.order;

/**
 * @Description: 微信支付
 * @Author: gege
 * @CreateDate: 2019/3/22 11:45
 */
public class WechatPay extends   Payment{
    public String getName() {
        return "微信支付";
    }

    public double getBalance(String uid) {
        return 1000;
    }
}