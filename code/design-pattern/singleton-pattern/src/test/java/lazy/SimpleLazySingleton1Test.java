package lazy;

import org.junit.Test;
import utils.ConcurrentExecutor;
import utils.ExectorThread;

import java.lang.reflect.Constructor;

/**
 * @author gege
 * @Description
 * @date 2019/3/15 15:08
 */
public class SimpleLazySingleton1Test {





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