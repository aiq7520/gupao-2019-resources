package org.gege.pattern.factory.simple;

import org.gege.pattern.factory.Apple;
import org.gege.pattern.factory.Banana;
import org.gege.pattern.factory.Furits;
import org.gege.pattern.factory.Grape;
import org.junit.Test;

/**
 * @author gege
 * @Description
 * @date 2019/3/14 16:34
 */
public class FuritsSimpleFactoryTest {

    @Test
    public void createFuritsTest() {
        //此处客户端不需要自己动手创建实例  创建的过程交给工厂完成
        Furits furits = FuritsSimpleFactory.createFurits("Apple");
        furits.descInfo();
        furits = FuritsSimpleFactory.createFurits("Banana");
        furits.descInfo();

        //加入客户传入的参数有误  则工厂创建不出我们需要的产品
      //  furits = FuritsSimpleFactory.createFurits("aaa");
        //furits.descInfo();
    }

    @Test
    public void createFuritsTestUpgrade() {
        //此处客户端不需要自己动手创建实例  创建的过程交给工厂完成
        Furits furits = FuritsSimpleFactoryUpgrade.createFurits(Apple.class);
        furits.descInfo();
        furits = FuritsSimpleFactoryUpgrade.createFurits(Banana.class);
        furits.descInfo();

      //  furits = FuritsSimpleFactoryUpgrade.createFurits(String.class);
        //改进后此处只能传入 Furits 的子类
        furits = FuritsSimpleFactoryUpgrade.createFurits2(Apple.class);
        furits.descInfo();
    }

    //假如需求变动  添加一个新的水果
    @Test
    public void update() {
        //此处客户端不需要自己动手创建实例  创建的过程交给工厂完成
        Furits furits = FuritsSimpleFactoryUpgrade.createFurits(Grape.class);
        furits.descInfo();

    }
}