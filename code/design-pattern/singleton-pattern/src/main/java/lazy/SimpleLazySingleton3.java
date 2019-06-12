package lazy;

/**
 * @author gege  懒加载模式来实现基本的单例
 * @Description 静态内部类实现单例模式巧妙的运用了 静态内部类只有在该类被调用的时候才会加载，这个时候才开始实例化单例对象
 * @date 2019/3/15 15:04
 */
public class SimpleLazySingleton3 {
    //默认使用 SimpleLazySingleton3 的时候，会先初始化内部类
    //如果没使用的话，内部类是不加载的
    private SimpleLazySingleton3(){
        if(InnerClass.SINGLETONINSTANCE!=null)
            throw new RuntimeException("单例已被破坏");
    }

    public static SimpleLazySingleton3 getInstance(){
        ////在返回结果以前，一定会先加载内部类
        return InnerClass.SINGLETONINSTANCE;
    }

    //默认不加载
    private static class InnerClass{
        //每一个关键字都不是多余的
        //static 是为了使单例的空间共享
        //保证这个方法不会被重写，重载
        private final static SimpleLazySingleton3 SINGLETONINSTANCE = new  SimpleLazySingleton3();
    }
}
