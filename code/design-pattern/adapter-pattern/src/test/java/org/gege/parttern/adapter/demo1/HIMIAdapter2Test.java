package org.gege.parttern.adapter.demo1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/28 11:17
 */
public class HIMIAdapter2Test {

    @Test
    public void isHIMI() {
        HIMIAdapter2 himiAdapter2 = new HIMIAdapter2(new Usb());
        himiAdapter2.isHIMI();
    }
}