package utils;

import lazy.SimpleLazySingleton;
import lazy.SimpleLazySingleton1;

/**
 * @author gege
 * @Description
 * @date 2019/3/15 15:41
 */
public class ExectorThread implements  Runnable {
    public void run() {
        SimpleLazySingleton1 simpleLazySingleton = SimpleLazySingleton1.getInstance();
        System.out.println(System.currentTimeMillis() + ": " +simpleLazySingleton);
    }
}
