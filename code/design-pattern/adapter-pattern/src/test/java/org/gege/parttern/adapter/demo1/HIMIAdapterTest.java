package org.gege.parttern.adapter.demo1;

import org.gege.parttern.adapter.demo1.HIMIAdapter;
import org.junit.Test;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/28 10:43
 */
public class HIMIAdapterTest {

    @Test
    public void usbAdapter() {
        HIMIAdapter HIMIAdapter =new HIMIAdapter();
        HIMIAdapter.isHIMI();
    }
}