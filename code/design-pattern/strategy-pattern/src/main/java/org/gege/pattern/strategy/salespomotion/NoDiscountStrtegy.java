package org.gege.pattern.strategy.salespomotion;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/22$ 9:24$
 */
public class NoDiscountStrtegy implements ISalesPomotionStrategy{
    public void salesPomotion() {
        System.out.println("无任何优惠");
    }
}
