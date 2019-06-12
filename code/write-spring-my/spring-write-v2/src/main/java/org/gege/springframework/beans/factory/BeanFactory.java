package org.gege.springframework.beans.factory;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/4/22 13:11
 */
public interface BeanFactory {
    Object getBean(String beanName);
    Object getBean(Class<?> beanClass) throws Exception;
}
