package org.gege.pattern.prototype.entity;

import java.io.*;
import java.util.Date;

/**
 * @author gege
 * @Description
 * @date 2019/3/20 14:19
 */
public class Undolog1 extends UndoLog implements Cloneable, Serializable {
    //车身颜色
    private String bodyColor;
    //品牌

    private String brand;
    private UnOrder unOrder;

    public Undolog1() {
        this.setCreateDate(new Date());
        this.setUnOrder(new UnOrder());
    }

    public String getBodyColor() {
        return bodyColor;
    }

    public void setBodyColor(String bodyColor) {
        this.bodyColor = bodyColor;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public UnOrder getUnOrder() {
        return unOrder;
    }

    public void setUnOrder(UnOrder unOrder) {
        this.unOrder = unOrder;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.deepClone();
    }
    public Object deepClone(){
        try{
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            Undolog1 copy = (Undolog1)ois.readObject();
            return copy;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
