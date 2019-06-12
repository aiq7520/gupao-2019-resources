package org.gege.design.delegation;

/**
 * @author gege
 * @Description
 * @date 2019/3/20 15:16
 */
public class EmployeB implements IEmploye {
    public void doing(String command) {
        System.out.println("我是员工 B，我现在开始干" + command + "工作");
    }
}
