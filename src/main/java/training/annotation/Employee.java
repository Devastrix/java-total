package training.annotation;

import java.lang.annotation.Annotation;

@UserDetail(name = "Admin",
email = "admin@gmail.com",
address = "Mumbai")
public class Employee {

    private String empName;
    private String empEmail;
    private String empAddress;

    public Employee(String empName, String empEmail, String empAddress) {
        this.empName = empName;
        this.empEmail = empEmail;
        this.empAddress = empAddress;
    }

    public Employee(){
        setDefaultValue();
    }

    @UserDetail()
    public Employee(boolean def){
        Class<Employee> obj = Employee.class;
        if (obj.isAnnotationPresent(UserDetail.class) && def) {

            Annotation annotation = obj.getAnnotation(UserDetail.class);
            UserDetail userDetail = (UserDetail) annotation;
            empName = userDetail.name();
            empAddress = userDetail.address();
            empEmail = userDetail.email();
        }
    }

    private void setDefaultValue(){

        Class<Employee> obj = Employee.class;
        if (obj.isAnnotationPresent(UserDetail.class)) {

            Annotation annotation = obj.getAnnotation(UserDetail.class);
            UserDetail userDetail = (UserDetail) annotation;
            empName = userDetail.name();
            empAddress = userDetail.address();
            empEmail = userDetail.email();
        }
    }
    public String getEmpName() {
        return empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empAddress='" + empAddress + '\'' +
                '}';
    }
}
