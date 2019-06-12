package org.gege.pattern.factory.abs;

/**
 * @author gege
 * @Description 格力品牌 工厂实现类
 * @date 2019/3/15 10:10
 */
public class GreeFactory implements ProductAbstractFactory {
    public IAirConditioner madeAirConditioner() {
        return new GreeAirConditioner();
    }

    public IRefrigerator madeRefrigerator() {
        return new GreeRefrigerator();
    }
}
