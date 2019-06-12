package org.gege.write.spring.v1.mvc;

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
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/28 17:36
 */
public class DispatcherServlet  extends HttpServlet {

    private Map<String ,Object > ioc = new HashMap<String,Object>();
    private Map<String ,Method > mapping = new HashMap<String,Method>();
    //加载配置文件内容  初始化spring容器
    @Override
    public void init(ServletConfig config) throws ServletException {

        try {
            initConfigfile(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initConfigfile(ServletConfig config) throws Exception {
        //加载配置文件配置内容
        String filename = config.getInitParameter("contextConfigLocation");
        Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream(filename));
        String rootpackage = properties.getProperty("scanner.package");

        //扫描配置文件类下所有的包
        doScanner(rootpackage );
        for(String clazzName :ioc.keySet()){
           Class clazz = Class.forName(clazzName);
           if(clazz.isAnnotationPresent(MyService.class)){
               MyService myService = (MyService)clazz.getAnnotation(MyService.class);
               String annotationValue =  myService.value();
               String beanname = "";
               if(annotationValue==null||annotationValue=="")
                   beanname = clazz.getName();
               else
                   beanname = annotationValue;
               Object instance = clazz.newInstance();
               ioc.put(beanname,instance);
               for (Class<?> i : clazz.getInterfaces()) {
                   ioc.put(i.getName(),instance);
               }
           }
           else if(clazz.isAnnotationPresent(Controller.class)){
               ioc.put(clazzName,clazz.newInstance());
               Controller controller = (Controller)clazz.getAnnotation(Controller.class);
               String baseUrl="";
               if(clazz.isAnnotationPresent(RequestMapping.class)){
                   RequestMapping requestMapping = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
                   baseUrl = requestMapping.value();
               }
               Method methods [] = clazz.getMethods();
               for (Method m: methods) {
                   if(!m.isAnnotationPresent(RequestMapping.class))continue;
                   RequestMapping requestMapping = (RequestMapping) m.getAnnotation(RequestMapping.class);
                   String url  = (baseUrl+"/"+requestMapping.value()).replaceAll("/+","/");
                   mapping.put(url,m);
                   System.out.println("Mapped " + url + "," + m);
               }
           }
        }
        //di 自动装配
        for(Object bean:ioc.values()){
            if(bean==null)continue;
            Class clazz = bean.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for(Field field:fields){
                if(!field.isAnnotationPresent(AutoWired.class))continue;
                AutoWired autoWired =(AutoWired)field.getAnnotation(AutoWired.class);
                String beanName = autoWired.value();
                if("".equals(beanName)){beanName = field.getType().getName();}
                field.setAccessible(true);
                field.set(bean,ioc.get(beanName));
            }
        }
        System.out.println("INIT END");
    }

    private void doScanner(String rootpackage) {
        URL url = this.getClass().getClassLoader().getResource("/"+rootpackage.replaceAll("\\.","/"));
        File file = new File(url.getFile());
        File files[] = file.listFiles();
            for (File f: files) {
                String fileName = f.getName();
               if(f.isDirectory())
                   doScanner(rootpackage+"."+fileName);
               else {
                  if(!fileName.endsWith(".class"))continue;
                   String clazzName = (rootpackage + "." + f.getName().replace(".class",""));
                    ioc.put(clazzName,null);
               }
            }

    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String uri = req.getRequestURI();
            String contextPath = req.getContextPath();
            uri = uri.replace(contextPath, "").replaceAll("/+", "/");
            Method method = mapping.get(uri);
            if (method == null) {
                resp.getOutputStream().print("404");
                return;
            }
            Map<String, String[]> params = req.getParameterMap();

            Object obj = method.invoke(ioc.get(method.getDeclaringClass().getName()), new Object[]{params.get("username")[0]});
            resp.getOutputStream().print(obj.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
