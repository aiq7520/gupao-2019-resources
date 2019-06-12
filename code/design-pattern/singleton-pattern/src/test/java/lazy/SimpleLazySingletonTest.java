package lazy;

import org.junit.Test;
import utils.ConcurrentExecutor;
import utils.ExectorThread;

import java.lang.reflect.Constructor;

import static org.junit.Assert.*;

/**
 * @author gege
 * @Description
 * @date 2019/3/15 15:08
 */
public class SimpleLazySingletonTest {


    @Test
    public void getInstance() {
        SimpleLazySingleton simpleLazySingleton = SimpleLazySingleton.getInstance();
        SimpleLazySingleton simpleLazySingleton1 = SimpleLazySingleton.getInstance();
        SimpleLazySingleton simpleLazySingleton2 = SimpleLazySingleton.getInstance();
        System.out.println(simpleLazySingleton);
        System.out.println(simpleLazySingleton1);
        System.out.println(simpleLazySingleton2);
    }

    //通过反射创建
    @Test
    public void getInstanceProxy()  {
        Class<SimpleLazySingleton> clazz = SimpleLazySingleton.class;
        try {
            Constructor<SimpleLazySingleton> constructor= clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);//强制访问  强吻

            //实例化对象
            SimpleLazySingleton simpleLazySingleton= constructor.newInstance();
            SimpleLazySingleton simpleLazySingleton2= constructor.newInstance();
            SimpleLazySingleton simpleLazySingleton3 = SimpleLazySingleton.getInstance();

            //输出
            System.out.println(simpleLazySingleton);
            System.out.println(simpleLazySingleton2);
            System.out.println(simpleLazySingleton3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test//并发情况下
    public void concurrentInstance1(){
        Thread t1 = new Thread(new ExectorThread());
        Thread t2 = new Thread(new ExectorThread());
        t1.start();
        t2.start();
        System.out.println("end");
    }

    @Test//并发情况下
    public void concurrentInstance2(){
        try {
            ConcurrentExecutor.execute(new ConcurrentExecutor.RunHandler() {
                public void handler() {
                    System.out.println(System.currentTimeMillis() + ": " + SimpleLazySingleton.getInstance());
                }
            },10,6);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}