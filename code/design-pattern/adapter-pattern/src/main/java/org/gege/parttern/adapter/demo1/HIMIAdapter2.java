package org.gege.parttern.adapter.demo1;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/28 10:36
 */
public class HIMIAdapter2 implements IHIMI {

    private Usb usb;

    public HIMIAdapter2(Usb usb) {
        this.usb = usb;
    }

    public void isHIMI() {
        this.usb.isUsb();
    }
}
