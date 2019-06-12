package org.gege.springframework.context;

import org.gege.springframework.beans.factory.BeanFactory;
import org.gege.springframework.beans.factory.config.BeanDefinition;
import org.gege.springframework.beans.factory.support.BeanDefinitionReader;
import org.gege.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.util.List;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/4/22 13:53
 */
public class ApplicationContext extends DefaultListableBeanFactory implements BeanFactory {
    private String configLoaction;
    public ApplicationContext(String configLoaction){
        this.configLoaction = configLoaction;
        try {
            this.refresh();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void refresh() throws Exception {
        //1、定位，定位配置文件
        BeanDefinitionReader beanDefinitionReader =   new BeanDefinitionReader(configLoaction);
        //2、加载配置文件，扫描相关的类，把它们封装成 BeanDefinition
        List<BeanDefinition> beanDefinitions = beanDefinitionReader.loadBeanDefinitions();
        //3、注册，把配置信息放到容器里面(伪 IOC 容器)
        //4、把不是延时加载的类，有提前初始化
    }

    public Object getBean(String beanName) {
        return null;
    }

    public Object getBean(Class<?> beanClass) throws Exception {
        return null;
    }
}
