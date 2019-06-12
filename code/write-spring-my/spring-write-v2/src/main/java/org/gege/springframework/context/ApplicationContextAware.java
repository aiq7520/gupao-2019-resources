package org.gege.springframework.context;

/**
 * @Description: 一个通过解耦的方式获得ioc容器的顶层设计
 * 实现该类的方法或通过起监听器模式 调用 setApplicationContext
 * @Author: gege
 * @CreateDate: 2019/4/22 13:57
 */
public interface ApplicationContextAware {
    void setApplicationContext(ApplicationContext applicationContext) throws Exception;
}
