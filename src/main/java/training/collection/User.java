package training.collection;

public class User implements Comparable<User> {

    private int uId;
    private String uName;
    private String uAddress;

    public User(int uId, String uName, String uAddress) {
        this.uId = uId;
        this.uName = uName;
        this.uAddress = uAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uAddress='" + uAddress + '\'' +
                '}';
    }

    public int getuId() {
        return uId;
    }

    public String getuName() {
        return uName;
    }

    public String getuAddress() {
        return uAddress;
    }

    @Override
    public int compareTo(User o) {
        return this.uId - o.uId;
    }
}
