package org.gege.pattern.factory.simple;

import org.gege.pattern.factory.Furits;

/**
 * @author gege
 * @Description 客户端调用是简单了，但如果我们业务继续扩展，要增加前端课程，那么工厂中的
 * create()就要根据产品链的丰富每次都要修改代码逻辑。不符合开闭原则。因此，我们
 * 对简单工厂还可以继续优化，可以采用反射技术：
 * @date 2019/3/14 16:59
 */
public class FuritsSimpleFactoryUpgrade {

    /**
     * 简单工厂模式根据客户传递的参数来创建实例，客户不需要实例对象是如何产生的
     * @param clazz 客户传入的产品的类型
     * @return 工厂创建水果的实例
     */
    public static Furits createFurits(Class clazz){

        try {
            Object obj = clazz.newInstance();
            if(!(obj instanceof Furits))
                throw new RuntimeException("我们只创建水果");
            return (Furits) obj;
        }catch (Exception e){
            throw new RuntimeException("类创建异常");
        }
    }

    public static Furits createFurits2(Class<? extends Furits> clazz){

        try {
            Furits furits = clazz.newInstance();
            return  furits;
        }catch (Exception e){
            throw new RuntimeException("类创建异常");
        }
    }
}
