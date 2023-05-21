import java.util.ArrayList;
import java.util.Scanner;
public class Cafe {
    static ArrayList<Worker> workers = new ArrayList<Worker>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Worker");
            System.out.println("2. Search Worker");
            System.out.println("3. Edit Worker");
            System.out.println("4. Delete Worker");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addWorker();
                    break;
                case 2:
                    searchWorker();
                    break;
                case 3:
                    editWorker();
                    break;
                case 4:
                    deleteWorker();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void addWorker() {
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter present address: ");
        String presentAddress = scanner.next();
        System.out.print("Enter past address: ");
        String pastAddress = scanner.next();
        System.out.print("Enter NID: ");
        String NID = scanner.next();
        System.out.print("Enter passport: ");
        String passport = scanner.next();
        System.out.print("Enter joining date: ");
        String joiningDate = scanner.next();
        System.out.print("Enter education status: ");
        String educationStatus = scanner.next();
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        workers.add(new Worker(name, presentAddress, pastAddress, NID, passport, joiningDate, educationStatus, salary));
        System.out.println("Worker added successfully!");
    }

    public static void searchWorker() {
        System.out.print("Enter name to search: ");
        String name = scanner.next();
        for (Worker worker : workers) {
            if (worker.name.equals(name)) {
                System.out.println(worker);
                return;
            }
        }
        System.out.println("Worker not found!");
    }

    public static void editWorker() {
        System.out.print("Enter name to edit: ");
        String name = scanner.next();
        for (Worker worker : workers) {
            if (worker.name.equals(name)) {
                System.out.print("Enter new present address: ");
                worker.presentAddress = scanner.next();
                System.out.print("Enter new past address: ");
                worker.pastAddress = scanner.next();
                System.out.print("Enter new NID: ");
                worker.NID = scanner.next();
                System.out.print("Enter new passport: ");
                worker.passport = scanner.next();
                System.out.print("Enter new joining date: ");
                worker.joiningDate = scanner.next();
                System.out.print("Enter new education status: ");
                worker.educationStatus = scanner.next();
                System.out.print("Enter new salary: ");
                worker.salary = scanner.nextDouble();
                System.out.println("Worker edited successfully!");
                return;
            }
        }
        System.out.println("Worker not found!");
    }

    public static void deleteWorker() {
        System.out.print("Enter name to delete: ");
        String name = scanner.next();
        for (int i = 0; i < workers.size(); i++) {
            if (workers.get(i).name.equals(name)) {
                workers.remove(i);
                System.out.println("Worker deleted successfully!");
                return;
            }
        }
        System.out.println("Worker not found!");
    }
}