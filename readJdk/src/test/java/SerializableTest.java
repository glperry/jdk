import com.glperry.entity.User;
import org.junit.Test;

import java.io.*;

/**
 * @date:2020/5/30 13:47
 */
public class SerializableTest {

    @Test
    public void IOOperation() throws IOException, ClassNotFoundException {

        User user = new User("glperry","cross");
        String fileName = "info.txt";
        //写入数据,指定文件夹
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        objectOutputStream.writeObject(user);
        objectOutputStream.close();
        //读出数据
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
        User user2 = (User) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(user2);


    }

}
