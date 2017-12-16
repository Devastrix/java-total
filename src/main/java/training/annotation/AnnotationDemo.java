package training.annotation;

public class AnnotationDemo {

    public static void main(String[] args) {


        Employee employeeDefault = new Employee();
        Employee employee = new Employee("Anil", "anil@gmail.com", "Mumbai");
        Employee employeeDef = new Employee(true);
        System.out.println(employeeDefault);
        System.out.println(employee);
        System.out.println(employeeDef);
    }
}
