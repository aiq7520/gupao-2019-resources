package org.gege.design.delegation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gege
 * @Description
 * @date 2019/3/20 15:15
 */
public class Leader implements IEmploye {

    static Map<String,IEmploye> targets = new HashMap<String, IEmploye>();
    static{
        targets.put("A",new EmployeA());
        targets.put("B",new EmployeB());
    }

    public void doing(String command) {
        targets.get(command).doing(command);
    }
}
