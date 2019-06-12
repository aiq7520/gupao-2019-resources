package org.gege.pattern.strategy.salespomotion;

/**
 * @Description: 促销活动
 * @Author: gege
 * @CreateDate: 2019/3/22 9:23
 */
public class PomotionActivite {

    //优惠策略
    private ISalesPomotionStrategy iSalesPomotionStrategy =new NoDiscountStrtegy();

    public PomotionActivite(ISalesPomotionStrategy iSalesPomotionStrategy) {
        this.iSalesPomotionStrategy = iSalesPomotionStrategy;
    }

    public PomotionActivite() {
    }

    //执行优惠方案
    public void executeStrategy(){
        this.iSalesPomotionStrategy.salesPomotion();
    }
}
