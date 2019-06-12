package org.gege.pattern.strategy.salespomotion;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/22 10:47
 */
public class StrategyFactoryTest {

    @Test
    public void getStrtategy() {
        ISalesPomotionStrategy strategy = StrategyFactory.getStrtategy(StrategyFactory.Strategy.COUPONSTRATEGY);
        strategy.salesPomotion();
    }
}