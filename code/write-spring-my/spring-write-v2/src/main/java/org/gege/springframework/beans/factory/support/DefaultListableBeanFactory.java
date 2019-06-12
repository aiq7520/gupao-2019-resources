package org.gege.springframework.beans.factory.support;

import org.gege.springframework.beans.factory.config.BeanDefinition;
import org.gege.springframework.context.AbstractApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/4/22 13:49
 */
public class DefaultListableBeanFactory extends AbstractApplicationContext {
    //存储注册信息的 BeanDefinition
    protected final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String,BeanDefinition>();

}
