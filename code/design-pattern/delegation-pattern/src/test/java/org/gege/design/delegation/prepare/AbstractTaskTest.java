package org.gege.design.delegation.prepare;

import org.junit.Test;

/**
 * @Description
 * @auther gege
 * @create 2019-03-13 14:49
 */
public class AbstractTaskTest {
    @Test
    public void testTask(){
        Assignor assignor = new Assignor(new TaskRealizeB());
        assignor.task();
    }
}
