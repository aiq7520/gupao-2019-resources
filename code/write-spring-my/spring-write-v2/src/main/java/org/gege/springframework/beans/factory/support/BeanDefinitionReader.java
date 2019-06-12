package org.gege.springframework.beans.factory.support;

import org.gege.springframework.beans.factory.config.BeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/4/22 13:56
 */
public class BeanDefinitionReader {
    private List<String> registyBeanClasses = new ArrayList<String>();

    private Properties config = new Properties();
    //固定配置文件中的 key，相对于 xml 的规范
    private final String SCAN_PACKAGE = "scanPackage";

    public BeanDefinitionReader(String configLoaction){
        //通过 URL 定位找到其所对应的文件，然后转换为文件流
        InputStream is =this.getClass().getClassLoader().getResourceAsStream(configLoaction.replace("classpath:",""));
        try {
            config.load(is);
            is.close();
            doscanerClass(SCAN_PACKAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void doscanerClass(String scannerPackage) throws Exception {
        URL url = this.getClass().getClassLoader().getResource("/"+scannerPackage.replaceAll("\\.","/"));
        File rootFile = new File(url.getFile());
        File[] files = rootFile.listFiles();
        for(File file :files){
            String filename = file.getName();
            if(file.isDirectory())
                doscanerClass(scannerPackage+"."+filename);
            else{
                if(!filename.endsWith(".class"))continue;
                registyBeanClasses.add((scannerPackage+"."+filename).replace(".class",""));
            }
        }
    }
    public List<BeanDefinition> loadBeanDefinitions(){
        List<BeanDefinition> result = new ArrayList<BeanDefinition>();
        try {
            for (String className : registyBeanClasses) {
                Class<?> beanClass = Class.forName(className);
                if(beanClass.isInterface()) { continue; }
                result.add(doCreateBeanDefinition(toLowerFirstCase(beanClass.getSimpleName()),beanClass.getName(
                )));
                Class<?> [] interfaces = beanClass.getInterfaces();
                for (Class<?> i : interfaces) {
                    result.add(doCreateBeanDefinition(i.getName(),beanClass.getName()));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    private BeanDefinition doCreateBeanDefinition(String factoryBeanName,String beanClassName){
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName(beanClassName);
        beanDefinition.setFactoryBeanName(factoryBeanName);
        return beanDefinition;
    }
    private String toLowerFirstCase(String simpleName) {
        char [] chars = simpleName.toCharArray();
//之所以加，是因为大小写字母的 ASCII 码相差 32，
// 而且大写字母的 ASCII 码要小于小写字母的 ASCII 码
//在 Java 中，对 char 做算学运算，实际上就是对 ASCII 码做算学运算
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
