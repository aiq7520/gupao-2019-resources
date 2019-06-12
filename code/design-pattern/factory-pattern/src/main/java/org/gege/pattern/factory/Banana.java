package org.gege.pattern.factory;

/**
 * @author gege
 * @Description 具体产品角色是创建目标，所有创建的对象都充当这个角色的某个具体类的实例
 * @date 2019/3/14 16:25
 */
public class Banana implements Furits  {
    public void descInfo() {
        System.out.println("I am Banana!");
    }
}
