package org.gege.pattern.strategy.salespomotion;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/22$ 9:31$
 */
public class PomotionActiviteTest {

    @Test
    public void executeStrategy() {
        PomotionActivite p1 = new PomotionActivite();
        p1.executeStrategy();

        PomotionActivite p2 = new PomotionActivite(new DiscountStrategy());
        p2.executeStrategy();
    }
}