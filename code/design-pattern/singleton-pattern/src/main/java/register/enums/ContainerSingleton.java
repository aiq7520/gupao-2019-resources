package register.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gege
 * @Description  注册式单例另一种写法，容器缓存的写法
 * @date 2019/3/18 15:41
 */
public class ContainerSingleton {
    private ContainerSingleton (){}
    public Map<Class,Object> map = new HashMap<Class,Object>();

    public Object get (Class clazz) {
        synchronized (map) {
            Object obj = map.get(clazz);
            if (obj == null) {
                try {
                    obj = clazz.newInstance();
                } catch (Exception e) {

                }
            }
            return obj;
        }
    }
}
