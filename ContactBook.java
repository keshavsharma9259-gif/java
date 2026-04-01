import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ContactBook implements ActionListener {

    JFrame frame;
    JTextField nameField, phoneField;
    JButton addButton, updateButton, deleteButton;
    JList<String> contactList;
    DefaultListModel<String> listModel;

    ContactBook() {
        frame = new JFrame("Contact Book");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 20, 100, 25);
        frame.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(120, 20, 150, 25);
        frame.add(nameField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(30, 60, 100, 25);
        frame.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(120, 60, 150, 25);
        frame.add(phoneField);

        addButton = new JButton("Add");
        addButton.setBounds(30, 100, 80, 30);
        addButton.addActionListener(this);
        frame.add(addButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(140, 100, 80, 30);
        updateButton.addActionListener(this);
        frame.add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(250, 100, 80, 30);
        deleteButton.addActionListener(this);
        frame.add(deleteButton);

        listModel = new DefaultListModel<>();
        contactList = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(contactList);
        scrollPane.setBounds(50, 150, 250, 130);
        frame.add(scrollPane);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ContactBook();
    }

    public void actionPerformed(ActionEvent e) {

        String name = nameField.getText();
        String phone = phoneField.getText();

        if (e.getSource() == addButton) {
            if (!name.isEmpty() && !phone.isEmpty()) {
                listModel.addElement(name + " - " + phone);
                nameField.setText("");
                phoneField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Enter name and phone!");
            }
        }

        if (e.getSource() == updateButton) {
            int index = contactList.getSelectedIndex();
            if (index != -1) {
                listModel.set(index, name + " - " + phone);
            } else {
                JOptionPane.showMessageDialog(frame, "Select a contact to update!");
            }
        }

        if (e.getSource() == deleteButton) {
            int index = contactList.getSelectedIndex();
            if (index != -1) {
                listModel.remove(index);
            } else {
                JOptionPane.showMessageDialog(frame, "Select a contact to delete!");
            }
        }
    }
}