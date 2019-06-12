package org.gege.springframework.beans.factory.config;

import lombok.Data;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/4/22 13:27
 */
@Data
public class BeanDefinition {
    private String beanClassName;
    private boolean lazyInit = false;
    private String factoryBeanName;
}