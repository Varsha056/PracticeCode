// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.util.stream.*;
class Employees{
    public int age;
    public String name;
    public double salary;
    
    Employees(int age, String name, double salary){
        this.age = age;
        this.name = name;
        this.salary = salary;
    }
    public int getAge(){ return age;}
    public String getName(){ return name;}
    public double getSalary(){ return salary;}
    
    @Override
    public String toString() {
        return name + " (" + age + ")" + " Salary: "+ salary;
    }
}
class Main {
    public static void main(String[] args) {
       
       List<Employees> emp = Arrays.asList(
           new Employees(23,"bob",24333),
           new Employees(27,"Alice",346788),
           new Employees(32,"Maria",50000));
           
           Double avg = emp.stream()
           .mapToDouble(e -> e.getSalary())
           .average()
           .orElse(0.0);
           
           Optional<Employees> maxAge = emp.stream()
                .max(Comparator.comparingInt(e -> e.age));
            System.out.println("oldest is - ");    
           maxAge.ifPresent(System.out::println);
           
           
           List<String> nameEmp = emp.stream()
           .map(e->e.name)
           .collect(Collectors.toList());
           nameEmp.forEach(System.out::println);
           
           OptionalDouble avgAge = emp.stream()
           .mapToInt(Employees::getAge)
           .average();
           
            avgAge.ifPresent(System.out::println);
           
           List<Employees> allEmp = emp.stream()
           .filter(e-> e.getSalary()>avg)
           .collect(Collectors.toList());
           
            allEmp.forEach(System.out::println);
             
           List<Employees> ageEmp = emp.stream()
           .filter(e-> e.getAge()>30)
           .collect(Collectors.toList());
           
           ageEmp.forEach(System.out::println);
        --------------------------------------------------------
          Map<String, Optional<Employee>> maxSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
            ));

        // Printing the results
        maxSalaryByDept.forEach((department, employeeOpt) -> {
            employeeOpt.ifPresent(employee -> 
                System.out.println("Department: " + department + ", Max Salary: " + employee));
        });
    }
}
