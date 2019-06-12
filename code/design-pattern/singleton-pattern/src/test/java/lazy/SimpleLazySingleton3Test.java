package lazy;

import org.junit.Test;
import utils.ConcurrentExecutor;

import static org.junit.Assert.*;

/**
 * @author gege
 * @Description
 * @date 2019/3/15 16:49
 */
public class SimpleLazySingleton3Test {

    @Test
    public void getInstance() {
        try {
            ConcurrentExecutor.execute(new ConcurrentExecutor.RunHandler() {
                public void handler() {
                    System.out.println(System.currentTimeMillis() + ": " + SimpleLazySingleton3.getInstance());
                }
            },10,6);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}