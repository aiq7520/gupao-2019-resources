package org.gege.pattern.factory.abs;

import org.junit.Test;

/**
 * @author gege
 * @Description
 * @date 2019/3/15 10:14
 */
public class AbstractFactoryTest {

    @Test
    public void testAbstractFactory(){

        MideaFactory mideaFactory = new MideaFactory();

        IAirConditioner mideaAirConditioner = mideaFactory.madeAirConditioner();
        mideaAirConditioner.describeAirConditioner();

        IRefrigerator  mideaRefrigerator = mideaFactory.madeRefrigerator();
        mideaRefrigerator.describeRefrigerator();


        GreeFactory greeFactory = new GreeFactory();
        IAirConditioner greeAirConditioner =  greeFactory.madeAirConditioner();

        greeAirConditioner.describeAirConditioner();
        IRefrigerator greeRefrigerator = greeFactory.madeRefrigerator();
        greeRefrigerator.describeRefrigerator();

    }

}
