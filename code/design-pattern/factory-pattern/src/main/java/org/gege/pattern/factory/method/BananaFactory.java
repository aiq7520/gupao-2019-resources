package org.gege.pattern.factory.method;

import org.gege.pattern.factory.Banana;
import org.gege.pattern.factory.Furits;

/**
 * @author gege
 * @Description 实现工厂接口规范  专人干专事  该工厂只创建Banana
 * @date 2019/3/14 18:04
 */
public class BananaFactory implements IFuritsFactory{
    public Furits createFurits() {
        return new Banana();
    }
}
