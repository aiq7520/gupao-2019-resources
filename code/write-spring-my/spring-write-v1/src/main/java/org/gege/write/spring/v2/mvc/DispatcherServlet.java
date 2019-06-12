package org.gege.write.spring.v2.mvc;

import org.apache.commons.lang3.StringUtils;
import org.gege.write.spring.annotation.AutoWired;
import org.gege.write.spring.annotation.Controller;
import org.gege.write.spring.annotation.MyService;
import org.gege.write.spring.annotation.RequestMapping;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;
import java.util.*;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/28 17:36
 */
public class DispatcherServlet extends HttpServlet {

    List<String> classnames = new ArrayList<String>();
    Map<String,Object> ioc = new HashMap<String, Object>();
    Map<String,Method> mapping = new HashMap<String, Method>();

    public void init(ServletConfig config) throws ServletException {
        try{
        //读取配置文件，将扫描的类放入一个集合
        scanPackages(config.getInitParameter("contextConfigLocation"));
        //实例化ioc容器，并创建相关bean
        instanceIOC();
        //实现di 依赖注入
        doDI();
        //实现handlermapping
        doHandlerMapping();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void doHandlerMapping() {
        for(Object bean:ioc.values()){
            Class clazz = bean.getClass();
            if(!clazz.isAnnotationPresent(Controller.class))
                continue;
            String url = "/";
            if(clazz.isAnnotationPresent(RequestMapping.class)){
                RequestMapping requestMapping = (RequestMapping)clazz.getAnnotation(RequestMapping.class);
                url+=requestMapping.value();
            }
            Method methods[] =clazz.getMethods();
            for (Method m:methods){
                if(!m.isAnnotationPresent(RequestMapping.class))continue;
                RequestMapping requestMapping =(RequestMapping)m.getAnnotation(RequestMapping.class);
                url=url+"/"+requestMapping.value();
                mapping.put(url.replaceAll("/+","/"),m);
                System.out.println("Mapped " + url + "," + m);
            }
        }
    }

    private void doDI() throws Exception{
        for(Object bean:ioc.values()){
            Class clazz = bean.getClass();
            Field fields[] = clazz.getFields();
            for (Field f :fields){
                if(!f.isAnnotationPresent(AutoWired.class))continue;
                AutoWired autoWired = (AutoWired)f.getAnnotation(AutoWired.class);
                String beanname = autoWired.value();
                if(StringUtils.isEmpty(beanname))
                    beanname = toLowerFirstChar(f.getType().getName());
                f.set(bean,ioc.get(beanname));
            }
        }
    }

    //此处完成对象的实例化   可作为工厂模式
    private void instanceIOC() throws Exception{
        for (String calssname:classnames){
            Class clazz = Class.forName(calssname);
            Object annotationObj = null;
            if(clazz.isAnnotationPresent(MyService.class))
                annotationObj =clazz.getAnnotation(MyService.class);
            else  if(clazz.isAnnotationPresent(Controller.class))
                annotationObj =  clazz.getAnnotation(Controller.class);

            if(annotationObj!=null){
                //默认类名首字母小写
                String beanname = toLowerFirstChar(clazz.getSimpleName());
                Method method = annotationObj.getClass().getMethod("value");
                String value =(String)method.invoke(beanname);
                if(StringUtils.isNotEmpty(value))beanname=value;
                Object bean = clazz.newInstance();
                ioc.put(beanname,bean);
                System.out.println("Ioc 容器实例化 "+beanname+" Bean :"+bean);
                //根据类型注入实现类，投机取巧的方式
                for (Class<?> i : clazz.getInterfaces()) {
                    if(ioc.containsKey(i.getName()))
                        throw new Exception("The beanName is exists!!");
                    ioc.put(i.getName(),bean);
                    System.out.println("Ioc 容器实例化 "+i.getName()+" Bean :"+bean);
                }
            }
        }
    }

    private String toLowerFirstChar(String simpleName) {
        char [] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    private void scanPackages(String contextConfigLocation) throws Exception{
        Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation));
        String scannerPackage = properties.getProperty("scanner.package");
        doscanerClass(scannerPackage);
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
                classnames.add((scannerPackage+"."+filename).replace(".class",""));
            }



        }
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
           String uri = request.getRequestURI();
           String contextPath = request.getContextPath();
           uri = uri.replaceAll(contextPath,"").replaceAll("/+","/");
           Method method = mapping.get(uri);
           if (null == method) {
               response.getOutputStream().print("404 uri");
               return;
           }
           String beanname =toLowerFirstChar(method.getDeclaringClass().getName());
           method.invoke(ioc.get(beanname), new Object[]{request.getParameter("username")});
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
