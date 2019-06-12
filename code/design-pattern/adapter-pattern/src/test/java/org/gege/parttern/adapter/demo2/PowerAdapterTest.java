package org.gege.parttern.adapter.demo2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/28 13:53
 */
public class PowerAdapterTest {

    @Test
    public void outputDC5V() {
        PowerAdapter powerAdapter = new PowerAdapter(new AC220());
        powerAdapter.outputDC5V();
    }
}