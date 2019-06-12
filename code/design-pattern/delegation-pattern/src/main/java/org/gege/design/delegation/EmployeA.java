package org.gege.design.delegation;

/**
 * @author gege
 * @Description
 * @date 2019/3/20 15:16
 */
public class EmployeA implements IEmploye {
    public void doing(String command) {
        System.out.println("我是员工 A，我现在开始干" + command + "工作");
    }
}
