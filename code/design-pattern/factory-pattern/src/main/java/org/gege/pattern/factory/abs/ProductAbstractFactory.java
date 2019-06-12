package org.gege.pattern.factory.abs;

/**
 * @author gege
 * @Description  抽象的产品接口  创建产品
 * @date 2019/3/15 10:01
 */
public interface ProductAbstractFactory {
    /**
     *
     * @return
     */
    IAirConditioner madeAirConditioner();

    /**
     *
     * @return
     */
    IRefrigerator madeRefrigerator();
}
