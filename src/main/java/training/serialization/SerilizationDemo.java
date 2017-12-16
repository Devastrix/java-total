package training.serialization;

import java.io.*;

public class SerilizationDemo {

    public static void main(String[] args) throws IOException {

        SerilizationDemo serilizationDemo = new SerilizationDemo();
        serilizationDemo.doSerialize();
        serilizationDemo.doDeSerialize();
    }

    private void doSerialize() throws IOException {

        System.out.println("Serializing ******");
        FileOutputStream fileOutputStream = new FileOutputStream("mydata.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        Employee inputEmp = new Employee(101, "Admin", "Mumbai");

        objectOutputStream.writeObject(inputEmp);
        System.out.println("Object added [" + inputEmp + "]");

    }

    private void doDeSerialize() throws IOException {
        System.out.println("De-Serializing ******");
        FileInputStream fileInputStream = new FileInputStream("mydata.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        try {
            Employee employee = (Employee) objectInputStream.readObject();
            System.out.println("Object retrieved ["+employee + "]");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
