package serializable;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * @author gege
 * @Description
 * @date 2019/3/18 13:54
 */
public class SeriablesSingletonTest {

    @Test
    public void getInstance() {
        SeriablesSingleton seriablesSingleton  =SeriablesSingleton.getInstance();
        System.out.println(seriablesSingleton);
        try {
            ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("SeriablesSingleton.obj"));
            objectOutput.writeObject(seriablesSingleton);

            ObjectInput objectInput = new ObjectInputStream(new FileInputStream("SeriablesSingleton.obj"));
            SeriablesSingleton seriablesSingletonF = (SeriablesSingleton)objectInput.readObject();
            System.out.println(seriablesSingletonF);

        }catch (Exception e){

        }
    }
}