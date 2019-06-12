package org.gege.pattern.factory.method;

import org.gege.pattern.factory.Apple;
import org.gege.pattern.factory.Furits;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * @author gege
 * @Description 工厂方法的测试
 * @date 2019/3/14 18:08
 */
public class IFuritsFactoryTest {

    @Test
    public void createFuritsTest(){
        AppleFactory appleFactory = new AppleFactory();
        Furits furits = appleFactory.createFurits();
        furits.descInfo();
    }
}