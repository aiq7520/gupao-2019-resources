package org.gege.springframework.context;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/4/22 13:47
 */
public abstract class AbstractApplicationContext {
    //受保护，只提供给子类重写
    public void refresh() throws Exception {}
}
