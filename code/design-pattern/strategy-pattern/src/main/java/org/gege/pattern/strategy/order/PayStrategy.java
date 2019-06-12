package org.gege.pattern.strategy.order;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/22 15:05
 */
public class PayStrategy {
    public static final String JD_PAY = "JdPay";
    public static final String UNION_PAY = "UnionPay";
    public static final String WECHAT_PAY = "WechatPay";
    public static final String DEFAULT_PAY = JD_PAY;
    private static Map<String,Payment> payStrategy = new HashMap<String,Payment>();
    static {
        payStrategy.put(WECHAT_PAY,new WechatPay());
        payStrategy.put(UNION_PAY,new UnionPay());
        payStrategy.put(JD_PAY,new JDPay());
    }
    public static Payment get(String payKey){
        if(!payStrategy.containsKey(payKey)){
            return payStrategy.get(DEFAULT_PAY);
        }
        return payStrategy.get(payKey);
    }

}
