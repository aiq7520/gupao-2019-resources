package lazy;

/**
 * @author gege  懒加载模式来实现基本的单例
 * @Description 该如何优化呢？
 * @date 2019/3/15 15:04
 */
public class SimpleLazySingleton2 {
    private SimpleLazySingleton2(){}
    private  static SimpleLazySingleton2 simpleLazySingleton;
    //在此处方法上加上同步锁
    public static  SimpleLazySingleton2 getInstance(){
        if(simpleLazySingleton==null){
            synchronized (SimpleLazySingleton2.class){
            if(simpleLazySingleton==null)simpleLazySingleton= new SimpleLazySingleton2();
            }
        }

        return simpleLazySingleton;
    }
}
