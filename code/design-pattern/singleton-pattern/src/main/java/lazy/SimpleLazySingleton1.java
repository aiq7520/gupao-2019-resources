package lazy;

/**
 * @author gege  懒加载模式来实现基本的单例
 * @Description 该如何优化呢？
 * @date 2019/3/15 15:04
 */
public class SimpleLazySingleton1 {
    private SimpleLazySingleton1(){}
    private  static  SimpleLazySingleton1 simpleLazySingleton;
    //在此处方法上加上同步锁
    public static synchronized SimpleLazySingleton1 getInstance(){
        if(simpleLazySingleton==null)
            simpleLazySingleton= new SimpleLazySingleton1();
        return simpleLazySingleton;
    }
}
