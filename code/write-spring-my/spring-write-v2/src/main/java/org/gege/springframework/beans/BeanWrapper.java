package org.gege.springframework.beans;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/4/22 13:34
 */
public class BeanWrapper {
    private Object wrappedInstance;
    private Class<?> wrappedClass;
    public BeanWrapper(Object wrappedInstance){
        this.wrappedInstance = wrappedInstance;
    }
    public Object getWrappedInstance(){
        return this.wrappedInstance;
    }
    // 返回代理以后的 Class
// 可能会是这个 $Proxy0
    public Class<?> getWrappedClass(){
        return this.wrappedInstance.getClass();
    }

}
