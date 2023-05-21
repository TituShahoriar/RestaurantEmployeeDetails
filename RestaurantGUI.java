import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RestaurantGUI extends JFrame implements ActionListener {
    private ArrayList<Emp> employees;
    private JTextField nameField;
    private JTextField presentAddressField;
    private JTextField pastAddressField;
    private JTextField nidField;
    private JTextField passportField;
    private JTextField joiningDateField;
    private JTextField educationStatusField;
    private JTextField salaryField;
    private JButton addButton;
    private JButton searchButton;
    private JButton editButton;
    private JButton deleteButton;

    public RestaurantGUI() {
        employees = new ArrayList<>();

        // Set layout and add components
        setLayout(new GridLayout(9, 2));
        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);
        add(new JLabel("Present Address:"));
        presentAddressField = new JTextField();
        add(presentAddressField);
        add(new JLabel("Past Address:"));
        pastAddressField = new JTextField();
        add(pastAddressField);
        add(new JLabel("NID:"));
        nidField = new JTextField();
        add(nidField);
        add(new JLabel("Passport:"));
        passportField = new JTextField();
        add(passportField);
        add(new JLabel("Joining Date:"));
        joiningDateField = new JTextField();
        add(joiningDateField);
        add(new JLabel("Education Status:"));
        educationStatusField = new JTextField();
        add(educationStatusField);
        add(new JLabel("Salary:"));
        salaryField = new JTextField();
        add(salaryField);

        addButton = new JButton("Add");
        addButton.addActionListener(this);
        add(addButton);

        searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        add(searchButton);

        editButton = new JButton("Edit");
        editButton.addActionListener(this);
        add(editButton);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);
        add(deleteButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            // Add button clicked
            String name = nameField.getText();
            String presentAddress = presentAddressField.getText();
            String pastAddress = pastAddressField.getText();
            String nid = nidField.getText();
            String passport = passportField.getText();
            String joiningDate = joiningDateField.getText();
            String educationStatus = educationStatusField.getText();
            double salary = Double.parseDouble(salaryField.getText());

            Emp employee = new Emp(name, presentAddress, pastAddress, nid, passport, joiningDate, educationStatus, salary);
            employees.add(employee);

            // Clear fields
            clearFields();
        } else if (e.getSource() == searchButton) {
            // Search button clicked
            String searchName = JOptionPane.showInputDialog("Enter the name to search:");

            boolean found = false;
            for (Emp employee : employees) {
                if (employee.getName().equals(searchName)) {
                    // Display employee details
                    displayEmployeeDetails(employee);
                    found = true;
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "Employee not found!");
            }
        } else if (e.getSource() == editButton) {
            // Edit button clicked
            String searchName = JOptionPane.showInputDialog("Enter the name to edit:");

            boolean found = false;
            for (Emp employee : employees) {
                if (employee.getName().equals(searchName)) {
                    // Update employee details
                    updateEmployeeDetails(employee);
                    found = true;
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "Employee not found!");
            }
        } else if (e.getSource() == deleteButton) {
            // Delete button clicked
            String searchName = JOptionPane.showInputDialog("Enter the name to delete:");

            boolean found = false;
            for (Emp employee : employees) {
                if (employee.getName().equals(searchName)) {
                    // Remove employee from the list
                    employees.remove(employee);
                    found = true;
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "Employee not found!");
            }
        }
    }

    private void clearFields() {
        nameField.setText("");
        presentAddressField.setText("");
        pastAddressField.setText("");
        nidField.setText("");
        passportField.setText("");
        joiningDateField.setText("");
        educationStatusField.setText("");
        salaryField.setText("");
    }

    private void displayEmployeeDetails(Emp employee) {
        StringBuilder message = new StringBuilder();
        message.append("Name: ").append(employee.getName()).append("\n");
        message.append("Present Address: ").append(employee.getPresentAddress()).append("\n");
        message.append("Past Address: ").append(employee.getPastAddress()).append("\n");
        message.append("NID: ").append(employee.getNid()).append("\n");
        message.append("Passport: ").append(employee.getPassport()).append("\n");
        message.append("Joining Date: ").append(employee.getJoiningDate()).append("\n");
        message.append("Education Status: ").append(employee.getEducationStatus()).append("\n");
        message.append("Salary: ").append(employee.getSalary());

        JOptionPane.showMessageDialog(this, message.toString());
    }

    private void updateEmployeeDetails(Emp employee) {
        // Prompt the user to update the employee details using input dialogs
        String presentAddress = JOptionPane.showInputDialog("Enter the present address:", employee.getPresentAddress());
        employee.setPresentAddress(presentAddress);

        String pastAddress = JOptionPane.showInputDialog("Enter the past address:", employee.getPastAddress());
        employee.setPastAddress(pastAddress);

        String nid = JOptionPane.showInputDialog("Enter the NID:", employee.getNid());
        employee.setNid(nid);

        String passport = JOptionPane.showInputDialog("Enter the passport:", employee.getPassport());
        employee.setPassport(passport);

        String joiningDate = JOptionPane.showInputDialog("Enter the joining date:", employee.getJoiningDate());
        employee.setJoiningDate(joiningDate);

        String educationStatus = JOptionPane.showInputDialog("Enter the education status:", employee.getEducationStatus());
        employee.setEducationStatus(educationStatus);

        String salaryStr = JOptionPane.showInputDialog("Enter the salary:", employee.getSalary());
        double salary = Double.parseDouble(salaryStr);
        employee.setSalary(salary);
    }

    public static void main(String[] args) {
        RestaurantGUI gui = new RestaurantGUI();
        gui.setTitle("Restaurant Management System");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(400, 400);
        gui.setVisible(true);
    }
}
