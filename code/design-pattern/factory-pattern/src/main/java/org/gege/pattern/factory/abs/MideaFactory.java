package org.gege.pattern.factory.abs;

/**
 * @author gege
 * @Description 美的产品的接口
 * @date 2019/3/15 10:05
 */
public class MideaFactory implements ProductAbstractFactory {
    public IAirConditioner madeAirConditioner() {
        return new MideaAirConditioner();
    }

    public IRefrigerator madeRefrigerator() {
        return new MideaRefrigerator();
    }
}
