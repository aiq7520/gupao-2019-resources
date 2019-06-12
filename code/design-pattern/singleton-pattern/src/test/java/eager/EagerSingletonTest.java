package eager;

import org.junit.Test;

import java.lang.reflect.Constructor;

import static org.junit.Assert.*;

/**饿汉式单例模式测试
 * @author gege
 * @Description
 * @date 2019/3/15 14:31
 */
public class EagerSingletonTest {

    @Test
    public void getInstance()  {
        Class<EagerSingleton> clazz = EagerSingleton.class;
        try {
            Constructor<EagerSingleton> constructor= clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);//强制访问  强吻

            //实例化对象
            EagerSingleton eagerSingleton= constructor.newInstance();
            EagerSingleton eagerSingleton2= constructor.newInstance();
            EagerSingleton eagerSingleton3 = EagerSingleton.getInstance();

            //输出
            System.out.println(eagerSingleton);
            System.out.println(eagerSingleton2);
            System.out.println(eagerSingleton3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getInstance1()  {
        System.out.println(EagerSingleton.getInstance());;
    }
}