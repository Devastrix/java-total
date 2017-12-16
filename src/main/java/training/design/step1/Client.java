package training.design.step1;

public class Client {

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImpl();
        try {
            userDAO.addUser(new User());
        } catch (PersistentException e) {
            System.out.println(e.getMessage());
        }
    }
}
