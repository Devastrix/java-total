package training.java8.combined;

import java.time.LocalDate;
import java.util.Optional;

public class Employee {
	private Optional<String> dept;
	private Optional<LocalDate> joiningDate;
	private Optional<String> name;
	private Optional<Integer> empID;
	private Optional<Integer> salary;
	
	public Employee(String name, Integer empID, String dept, LocalDate joiningDate, Integer salary)
	{
		setName(name);
		setEmpID(empID);
		setDept(dept);
		setJoiningDate(joiningDate);
		setSalary(salary);
	}
	
	public Optional<Integer> getEmpID()
	{
		return empID;
	}
	
	public Optional<Integer> getSalary()
	{
		return salary;
	}
	
	public Optional<String> getDept()
	{
		return dept;
	}
	
	public Optional<LocalDate> getJoiningDate()
	{
		return joiningDate;
	}
	
	public Optional<String> getName()
	{
		return name;
	}
	
	public void setEmpID(Integer empID)
	{
		this.empID = Optional.ofNullable(empID);
	}
	
	public void setDept(String dept)
	{
		this.dept = Optional.ofNullable(dept);
	}
	
	public void setSalary(Integer salary)
	{
		this.salary = Optional.ofNullable(salary);
	}
	
	public void setJoiningDate(LocalDate joiningDate)
	{
		this.joiningDate = Optional.ofNullable(joiningDate);
	}
	
	public void setName(String name)
	{
		this.name = Optional.ofNullable(name);
	}
}
