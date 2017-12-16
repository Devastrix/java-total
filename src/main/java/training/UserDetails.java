package training;

public abstract class UserDetails {

    private String name;
    private String address;
    public abstract String getUserName(String name);

    public UserDetails(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
