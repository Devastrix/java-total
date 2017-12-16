package training.design.step1;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class UserDAOImpl implements UserDAO {

    public void addUser(User user) throws PersistentException {

        try {
            FileOutputStream fos = new FileOutputStream("C:\\users\\John\\Desktop\\pingpong");
            FileInputStream fileInputStream = new FileInputStream("C:\\users\\John\\Desktop");
            System.out.println(fos.getFD());
        } catch (Exception e) {
            throw new PersistentException("Opps.. something went wrong", e);
        }
    }
}
