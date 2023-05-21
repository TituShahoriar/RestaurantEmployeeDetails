import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CafeGUI extends JFrame implements ActionListener {
    static ArrayList<Worker> workers = new ArrayList<Worker>();

    JLabel nameLabel = new JLabel("Name:");
    JTextField nameField = new JTextField(10);
    JLabel presentAddressLabel = new JLabel("Present Address:");
    JTextField presentAddressField = new JTextField(10);
    JLabel pastAddressLabel = new JLabel("Past Address:");
    JTextField pastAddressField = new JTextField(10);
    JLabel NIDLabel = new JLabel("NID:");
    JTextField NIDField = new JTextField(10);
    JLabel passportLabel = new JLabel("Passport:");
    JTextField passportField = new JTextField(10);
    JLabel joiningDateLabel = new JLabel("Joining Date:");
    JTextField joiningDateField = new JTextField(10);
    JLabel educationStatusLabel = new JLabel("Education Status:");
    JTextField educationStatusField = new JTextField(10);
    JLabel salaryLabel = new JLabel("Salary:");
    JTextField salaryField = new JTextField(10);

    JButton addButton = new JButton("Add Worker");
    JButton searchButton = new JButton("Search Worker");
    JButton editButton = new JButton("Edit Worker");
    JButton deleteButton = new JButton("Delete Worker");

    JTextArea textArea = new JTextArea(5, 20);

    public CafeGUI() {
        setLayout(new FlowLayout());

        add(nameLabel);
        add(nameField);
        add(presentAddressLabel);
        add(presentAddressField);
        add(pastAddressLabel);
        add(pastAddressField);
        add(NIDLabel);
        add(NIDField);
        add(passportLabel);
        add(passportField);
        add(joiningDateLabel);
        add(joiningDateField);
        add(educationStatusLabel);
        add(educationStatusField);
        add(salaryLabel);
        add(salaryField);

        addButton.addActionListener(this);
        searchButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);

        add(addButton);
        add(searchButton);
        add(editButton);
        add(deleteButton);

        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane);

        setTitle("Cafe Worker Management");
        setSize(250, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name = nameField.getText();
            String presentAddress = presentAddressField.getText();
            String pastAddress = pastAddressField.getText();
            String NID = NIDField.getText();
            String passport = passportField.getText();
            String joiningDate = joiningDateField.getText();
            String educationStatus = educationStatusField.getText();
            double salary = Double.parseDouble(salaryField.getText());
            workers.add(new Worker(name, presentAddress, pastAddress, NID, passport, joiningDate, educationStatus, salary));
            textArea.append("Worker added successfully!\n");
        } else if (e.getSource() == searchButton) {
            String name = nameField.getText();
            for (Worker worker : workers) {
                if (worker.name.equals(name)) {
                    textArea.append(worker.toString() + "\n");
                    return;
                }
            }
            textArea.append("Worker not found!\n");
        } else if (e.getSource() == editButton) {
            String name = nameField.getText();
            for (Worker worker : workers) {
                if (worker.name.equals(name)) {
                    worker.presentAddress = presentAddressField.getText();
                    worker.pastAddress= pastAddressField.getText();
                    worker.NID= NIDField.getText();
                    worker.passport= passportField.getText();
                    worker.joiningDate= joiningDateField.getText();
                    worker.educationStatus= educationStatusField.getText();
                    worker.salary= Double.parseDouble(salaryField.getText());
                    textArea.append("Worker edited successfully!\n");
                    return;
                }
            }
            textArea.append("Worker not found!\n");
        } else if (e.getSource() == deleteButton) {
            String name = nameField.getText();
            for (int i=0; i<workers.size(); i++) {
                if (workers.get(i).name.equals(name)) {
                    workers.remove(i);
                    textArea.append("Worker deleted successfully!\n");
                    return;
                }
            }
            textArea.append("Worker not found!\n");
        }
    }

    public static void main(String[] args) {
        CafeGUI cafeGUI= new CafeGUI();
    }
}