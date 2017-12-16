package training;


public class Employee extends UserDetails {
    private int empId;
    private String empName;
    private String empAddress;

    public Employee(int empId, String empName, String empAddress) {
        super(empName, empAddress);
        this.empId = empId;
        this.empName = empName;
        this.empAddress = empAddress;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empAddress='" + empAddress + '\'' +
                '}';
    }

    public String getUserName(String name) {
        return name;
    }
}
