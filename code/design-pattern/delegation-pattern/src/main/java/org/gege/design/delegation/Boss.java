package org.gege.design.delegation;

/**
 * @author gege
 * @Description
 * @date 2019/3/20 15:14
 */
public class Boss {
    public void command(String command,Leader leader){
        leader.doing(command);
    }
}
