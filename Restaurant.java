import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
    static ArrayList<Employee> employees = new ArrayList<Employee>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Edit Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    searchEmployee();
                    break;
                case 3:
                    editEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void addEmployee() {
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        System.out.print("Enter position: ");
        String position = scanner.next();
        employees.add(new Employee(name, age, position));
        System.out.println("Employee added successfully!");
    }

    public static void searchEmployee() {
        System.out.print("Enter name to search: ");
        String name = scanner.next();
        for (Employee employee : employees) {
            if (employee.name.equals(name)) {
                System.out.println(employee);
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public static void editEmployee() {
        System.out.print("Enter name to edit: ");
        String name = scanner.next();
        for (Employee employee : employees) {
            if (employee.name.equals(name)) {
                System.out.print("Enter new age: ");
                employee.age = scanner.nextInt();
                System.out.print("Enter new position: ");
                employee.position = scanner.next();
                System.out.println("Employee edited successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public static void deleteEmployee() {
        System.out.print("Enter name to delete: ");
        String name = scanner.next();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).name.equals(name)) {
                employees.remove(i);
                System.out.println("Employee deleted successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }
}