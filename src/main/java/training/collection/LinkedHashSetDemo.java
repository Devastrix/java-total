package training.collection;

import java.util.LinkedHashSet;
import java.util.TreeSet;

public class LinkedHashSetDemo {


    public static void main(String[] args) {

        System.out.println("LinkedHashSet ****");
        LinkedHashSet<User> linkedHashSet = new LinkedHashSet<User>();
        linkedHashSet.add(new User(103, "Admin3", "Mumbai3"));
        linkedHashSet.add(new User(102, "Admin2", "Mumbai2"));
        linkedHashSet.add(new User(101, "Admin1", "Mumbai1"));
        printList(linkedHashSet);

        System.out.println("TreeSet ****");
        TreeSet<User> treeSet = new TreeSet<User>();
        treeSet.add(new User(103, "Admin3", "Mumbai3"));
        treeSet.add(new User(102, "Admin2", "Mumbai2"));
        treeSet.add(new User(101, "Admin1", "Mumbai1"));
        printList(treeSet);
    }

    public static void printList(LinkedHashSet<User> lst) {
        for (Object object : lst) {
            System.out.println(object);
        }
    }
    public static void printList(TreeSet<User> lst) {
        for (Object object : lst) {
            System.out.println(object);
        }
    }
}
