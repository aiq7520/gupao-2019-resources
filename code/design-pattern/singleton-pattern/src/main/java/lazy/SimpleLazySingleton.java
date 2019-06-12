package lazy;

/**
 * @author gege  懒加载模式来实现基本的单例
 * @Description 经过测试 此单例出现线程安全的问题，在多线程并发情况下会出现多个实例，该如何优化呢？
 * @date 2019/3/15 15:04
 */
public class SimpleLazySingleton {
    private SimpleLazySingleton(){}
    private static SimpleLazySingleton simpleLazySingleton;
    public static SimpleLazySingleton getInstance(){
        if(simpleLazySingleton==null)
            simpleLazySingleton= new SimpleLazySingleton();
        return simpleLazySingleton;
    }
}
