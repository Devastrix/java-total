package training.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {

        //Generic type list
        List<Object> genericList = new ArrayList();

        genericList.add(22);
        genericList.add("fun is nothing");
        genericList.add(new User(101, "Rohan", "Pune"));

        System.out.println(genericList);
        //Specific type list
        List<User> userList = new ArrayList<User>();

        userList.add(new User(101, "Admin", "Mumbai"));
        userList.add(new User(102, "Admin2", "Mumbai2"));
        //It moves elements after 0th index by 1++;
        userList.add(1, new User(103, "Admin3", "Mumbai3"));
        System.out.println(userList);

        for (Object object : userList) {
            System.out.println(object);
        }


        //Removal
        List<String> strings = new ArrayList<String>();
        String myname = new String("Admin");
        strings.add("Admin");
        strings.add("Manager");
        strings.add(myname);

        strings.remove(myname);
        System.out.println(strings);

        List<User> userList1 = new ArrayList<User>();
        User user = new User(102, "Admin2", "Mumbai2");
        userList1.add(new User(102, "Admin2", "Mumbai2"));
        userList1.add(new User(101, "Admin", "Mumbai"));
        userList1.add(user);
        for (Object object : userList1) {
            System.out.println(object);
        }
        userList1.remove(user);
        for (Object object : userList1) {
            System.out.println(object);
        }

        System.out.println("************* Working set ************");
        // Custom sorting
        // Comparator util pkg
        // Comparable lang pkg

        List<User> userList3 = new ArrayList<User>();
        userList3.add(new User(102, "Admin2", "Mumbai2"));
        userList3.add(new User(101, "Admin", "Mumbai"));
        userList3.add(new User(103, "Admin3", "Mumbai3"));
        for (Object object : userList3) {
            System.out.println(object);
        }
        Collections.sort(userList3);
        Collections.sort(userList3, new IdComparator());
        printList(userList3);
    }

//    public static void printList(List<Object> lst){
    public static void printList(List<User> lst){
        for (Object object : lst) {
            System.out.println(object);
        }
    }
}
