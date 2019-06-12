package org.gege.pattern.strategy.salespomotion;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/22 9:58
 */
public class StrategyFactory  {
    private StrategyFactory(){}
    private static Map<Strategy,ISalesPomotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<Strategy, ISalesPomotionStrategy>();
    static {
        PROMOTION_STRATEGY_MAP.put(Strategy.COUPONSTRATEGY,new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put(Strategy.DISCOUNTSTRATEGY,new DiscountStrategy());
        PROMOTION_STRATEGY_MAP.put(Strategy.NODISCOUNTSTRTEGY,new NoDiscountStrtegy());
    }
    public static ISalesPomotionStrategy getStrtategy(Strategy strategy){
        return PROMOTION_STRATEGY_MAP.get(strategy);
    }
    enum Strategy{
        COUPONSTRATEGY,
        DISCOUNTSTRATEGY,
        NODISCOUNTSTRTEGY
    }
}
