package eager;

/**
 * @author gege
 * @Description 静态代码块的机制 实现单例模式
 * @date 2019/3/15 14:54
 */
public class StaticEagerSingleton {
    //私有化构造方法
    private StaticEagerSingleton(){}
    //全局提供一个单例实例
    private static final StaticEagerSingleton EAGER_SINGLETON_INSTACE ;
    static {
        EAGER_SINGLETON_INSTACE = new StaticEagerSingleton();
    }
    //对方提供一个访问接口
    public static StaticEagerSingleton getInstance(){
        return EAGER_SINGLETON_INSTACE;
    }

}
