package training;

public class Main {

    public static void main(String[] args) {

        Employee employee1 = new Employee(1, "Anil", "India");
        Employee employee2 = new Employee(2, "Anil Tiwari", "Asia");

        System.out.println(employee1.hashCode());
        System.out.println(employee2.hashCode());

        employee2 = employee1;
        employee1.getName();

        System.out.println(employee1.hashCode());
        System.out.println(employee2.hashCode());


        Manager manager = new ManagerImpl("Rohan");
        System.out.println("Name : " + manager.getName());
    }
}
