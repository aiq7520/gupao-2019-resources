package org.gege.pattern.factory.method;

import org.gege.pattern.factory.Apple;
import org.gege.pattern.factory.Furits;

/**
 * @author gege
 * @Description  实现工厂接口规范  专人干专事  该工厂只创建Apple
 * @date 2019/3/14 18:01
 */
public class AppleFactory implements IFuritsFactory{
    public Furits createFurits() {
        return new Apple();
    }
}
