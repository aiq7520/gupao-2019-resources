package register.enums;

import org.junit.Test;
import serializable.SeriablesSingleton;

import java.io.*;

import static org.junit.Assert.*;

/**
 * @author gege
 * @Description
 * @date 2019/3/18 14:47
 */
public class EnumSingletonTest {
    @Test
    public void newInstance(){
        EnumSingleton enumSingleton  =EnumSingleton.INSTANCE;
        enumSingleton.setData(new Object());
        System.out.println(enumSingleton.getData());
        try {
            ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("enumSingleton.obj"));
            objectOutput.writeObject(enumSingleton);

            ObjectInput objectInput = new ObjectInputStream(new FileInputStream("enumSingleton.obj"));
            EnumSingleton enumSingletonF = (EnumSingleton)objectInput.readObject();
            System.out.println(enumSingletonF.getData());
            System.out.println(enumSingleton==enumSingletonF);
        }catch (Exception e){

        }
    }

}