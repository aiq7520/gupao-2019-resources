package org.gege.design.delegation.prepare;

/**
 * @Description 委派者角色
 * @auther gege
 * @create 2019-03-13 14:24
 */
public class Assignor  implements AbstractTask{

    private AbstractTask abstractTask;

    public Assignor(AbstractTask abstractTask) {
        this.abstractTask = abstractTask;
    }

    public void task() {
        abstractTask.task();
    }
}
