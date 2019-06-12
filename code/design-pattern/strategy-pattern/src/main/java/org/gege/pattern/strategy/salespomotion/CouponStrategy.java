package org.gege.pattern.strategy.salespomotion;

/**
 * @Description: 优惠券活动
 * @Author: gege
 * @CreateDate: 2019/3/22$ 9:17$
 */
public class CouponStrategy implements ISalesPomotionStrategy {

    public void salesPomotion() {
        System.out.println("优惠券活动促销");
    }
}
