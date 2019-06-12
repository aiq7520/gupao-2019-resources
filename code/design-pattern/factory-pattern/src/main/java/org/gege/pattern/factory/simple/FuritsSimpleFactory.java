package org.gege.pattern.factory.simple;

import org.apache.commons.lang3.StringUtils;
import org.gege.pattern.factory.Apple;
import org.gege.pattern.factory.Banana;
import org.gege.pattern.factory.Furits;

/**
 * @Description 工厂角色:负责实现创建所有实例的内部逻辑
 * @author gege
 * @date 2019/3/14 16:20
 */
public class FuritsSimpleFactory {

    private FuritsSimpleFactory(){}

    /**
     * 简单工厂模式根据客户传递的参数来创建实例，客户不需要实例对象是如何产生的
     * @param param 客户传入的参数
     * @return 工厂创建水果的实例
     */
    public static Furits createFurits(String param){
        if(StringUtils.equals(param,"Apple"))
            return new Apple();
        if(StringUtils.equals(param,"Banana"))
            return new Banana();
      throw  new RuntimeException("生产不了此类产品"+param);
    }
}
