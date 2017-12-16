package training.java8.combined;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.Optional;

public class EmployeeTest {

	public static void main(String[] args)
	{
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("A", 1, "X", IsoChronology.INSTANCE.date(2013, 6, 20), 50000));
		employees.add(new Employee("B", 2, "X", IsoChronology.INSTANCE.date(2014, 7, 10), 100000));
		employees.add(new Employee("C", 3, "Y", IsoChronology.INSTANCE.date(2014, 8, 20), 120000));
		employees.add(new Employee("D", 4, "X", IsoChronology.INSTANCE.date(2014, 9, 10), 150000));
		employees.add(new Employee("E", 5, "Y", IsoChronology.INSTANCE.date(2014, 8, 20), 130000));
		employees.add(new Employee("F", 6, "X", IsoChronology.INSTANCE.date(2014, 9, 20), 130000));
		employees.add(new Employee("G", 7, "X", IsoChronology.INSTANCE.date(2014, 4, 20), 120000));
		employees.add(new Employee("H", 8, "X", IsoChronology.INSTANCE.date(2014, 9, 20), 80000));
		
		printWithPredicate2(employees);
		
		try
		{
			Optional<List<Employee>> optionalEmployees = Optional.ofNullable(employees);
			optionalEmployees.ifPresent(EmployeeTest::printWithPredicate2);
			optionalEmployees.orElseThrow(IllegalStateException::new);
		}
		catch (IllegalStateException ex)
		{
			//ex.printStackTrace();
			System.out.println("Unexpected exception");
		}
		
		try
		{
			Optional<List<Employee>> optionalEmployees2 = Optional.empty();
			optionalEmployees2.ifPresent(EmployeeTest::printWithPredicate2);
			optionalEmployees2.orElseThrow(IllegalStateException::new);
		}
		catch (IllegalStateException ex)
		{
			//ex.printStackTrace();
			System.out.println("Expected exception");
		}
		
		try
		{
			List<Employee> employees2 = new ArrayList<>(employees);
			employees2.add(new Employee("I", 9, null, IsoChronology.INSTANCE.date(2014, 9, 20), null));
			employees2.add(new Employee("J", null, "Z", IsoChronology.INSTANCE.date(2014, 6, 18), 100000));
			employees2.add(new Employee(null, 11, "Z", IsoChronology.INSTANCE.date(2014, 6, 18), 100000));

			Optional<List<Employee>> optionalEmployees3 = Optional.of(employees2);
			optionalEmployees3.ifPresent(EmployeeTest::printWithPredicate2);
			optionalEmployees3.orElseThrow(IllegalStateException::new).forEach(p -> p.getName().orElseThrow(IllegalStateException::new));
		}
		catch (IllegalStateException ex)
		{
			//ex.printStackTrace();
			System.out.println("Expected exception");
		}
		
		try
		{
			List<Optional<Employee>> employees3 = new ArrayList<>();
			employees3.add(Optional.of(new Employee("A", 1, "X", IsoChronology.INSTANCE.date(2013, 6, 20), 50000)));
			employees3.add(Optional.of(new Employee("B", 2, "X", IsoChronology.INSTANCE.date(2014, 7, 10), 100000)));
			employees3.add(Optional.of(new Employee("C", 3, "Y", IsoChronology.INSTANCE.date(2014, 8, 20), 120000)));
			employees3.add(Optional.of(new Employee("D", 4, "X", IsoChronology.INSTANCE.date(2014, 9, 10), 150000)));
			employees3.add(Optional.of(new Employee("E", 5, "Y", IsoChronology.INSTANCE.date(2014, 8, 20), 130000)));
			employees3.add(Optional.of(new Employee("F", 6, "X", IsoChronology.INSTANCE.date(2014, 9, 20), 130000)));
			employees3.add(Optional.of(new Employee("G", 7, "X", IsoChronology.INSTANCE.date(2014, 4, 20), 120000)));
			employees3.add(Optional.of(new Employee("H", 8, "X", IsoChronology.INSTANCE.date(2014, 9, 20), 80000)));			
			employees3.add(Optional.of(new Employee("I", 9, null, IsoChronology.INSTANCE.date(2014, 9, 20), null)));
			employees3.add(Optional.of(new Employee("J", null, "Z", IsoChronology.INSTANCE.date(2014, 6, 18), 100000)));
			employees3.add(Optional.of(new Employee("K", 12, null, IsoChronology.INSTANCE.date(2014, 9, 20), null)));
			employees3.add(Optional.of(new Employee("L", null, "Z", IsoChronology.INSTANCE.date(2014, 6, 18), 100000)));
			employees3.add(Optional.of(new Employee(null, 11, "Z", IsoChronology.INSTANCE.date(2014, 6, 18), 100000)));
			employees3.add(Optional.of(new Employee(null, 14, "Z", IsoChronology.INSTANCE.date(2014, 6, 18), 100000)));
			employees3.add(Optional.empty());
			employees3.add(Optional.empty());
			
			employees3.forEach(e -> System.out.println(e.orElseThrow(IllegalStateException::new).getName().orElseThrow(IllegalStateException::new)));
		}
		catch (IllegalStateException ex)
		{
			//ex.printStackTrace();
			System.out.println("Expected exception");
		}
	}
	
	private static void printWithPredicate2(Iterable<Employee> source)
	{
		printWithPredicate(source, 
				p -> p.getDept().isPresent() && p.getDept().get().equals("X") && 
				p.getJoiningDate().isPresent() && p.getJoiningDate().get().isAfter(IsoChronology.INSTANCE.date(2014, 7, 31)) &&
				p.getSalary().isPresent() && p.getSalary().get() > 100000 &&
				p.getName().isPresent(),
				p -> p.getName().get(),
				name -> System.out.println("Found employee: " + name));
	}
	
	private static <X, Y> void printWithPredicate(
		Iterable<X> source,
        Predicate<X> tester,
        Function<X, Y> mapper,
        Consumer<Y> block) {
            for (X p : source) {
                if (tester.test(p)) {
                    Y data = mapper.apply(p);
                    block.accept(data);
                }
            }
	}
}
