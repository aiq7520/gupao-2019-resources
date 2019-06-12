package eager;

/**单例模式之  饿汉式
 * @author gege
 * @Description
 * @date 2019/3/15 14:19
 */
public class EagerSingleton {

    //私有化构造方法
    private EagerSingleton(){
        if(EAGER_SINGLETON_INSTACE!=null)
            throw new RuntimeException("单例被破坏");
    }

    //全局提供一个单例实例
    private static final EagerSingleton EAGER_SINGLETON_INSTACE = new EagerSingleton();

    //对方提供一个访问接口
    public static EagerSingleton getInstance(){
        return EAGER_SINGLETON_INSTACE;
    }
}
