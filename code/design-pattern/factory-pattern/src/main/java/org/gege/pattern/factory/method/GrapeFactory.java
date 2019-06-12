package org.gege.pattern.factory.method;

import jdk.nashorn.internal.ir.IfNode;
import org.gege.pattern.factory.Furits;
import org.gege.pattern.factory.Grape;

/**
 * @author gege
 * @Description 实现工厂接口规范  专人干专事  该工厂只创建Grape
 * @date 2019/3/14 18:05
 */
public class GrapeFactory implements IFuritsFactory {
    public Furits createFurits() {
        return new Grape();
    }
}
