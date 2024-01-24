
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Employee {
    String employeeId;
    String name;
    int age;
    int salary;

    public Employee(String employeeId, String name, int age, int salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}

class EmployeeTable {
    ArrayList<Employee> employees;

    public EmployeeTable(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void displayTable() {
        for (Employee employee : employees) {
            System.out.println(employee.employeeId + "\t" + employee.name + "\t" + employee.age + "\t" + employee.salary);
        }
    }

    public void sortTable(int sortKey) {
        switch (sortKey) {
            case 1:
                Collections.sort(employees, Comparator.comparingInt(employee -> employee.age));
                break;
            case 2:
                Collections.sort(employees, Comparator.comparing(employee -> employee.name));
                break;
            case 3:
                Collections.sort(employees, Comparator.comparingInt(employee -> employee.salary));
                break;
            default:
                System.out.println("Invalid sorting parameter. Please choose 1, 2, or 3.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employeesData = new ArrayList<>();
        employeesData.add(new Employee("161E90", "Ramu", 35, 59000));
        employeesData.add(new Employee("171E22", "Tejas", 30, 82100));
        employeesData.add(new Employee("171G55", "Abhi", 25, 100000));
        employeesData.add(new Employee("152K46", "Jaya", 32, 85000));

        EmployeeTable employeeTable = new EmployeeTable(employeesData);

        System.out.println("Employee Table (Unsorted):");
        employeeTable.displayTable();

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter sorting parameter (1. Age, 2. Name, 3. Salary): ");
            int sortingParameter = scanner.nextInt();
            employeeTable.sortTable(sortingParameter);

            System.out.println("\nEmployee Table (Sorted):");
            employeeTable.displayTable();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid sorting parameter.");
        }
    }
}

    
