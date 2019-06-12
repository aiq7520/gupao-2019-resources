package org.gege.pattern.strategy.salespomotion;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/22$ 9:19$
 */
public class DiscountStrategy implements ISalesPomotionStrategy {
    public void salesPomotion() {
        System.out.println("现场八折优惠活动");
    }
}
