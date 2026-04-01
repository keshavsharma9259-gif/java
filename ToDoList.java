import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoList implements ActionListener {

    JFrame frame;
    JTextField taskField;
    JButton addButton, deleteButton;
    JList<String> taskList;
    DefaultListModel<String> listModel;

    ToDoList() {
        frame = new JFrame("To-Do List");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label = new JLabel("Enter Task:");
        label.setBounds(30, 20, 100, 25);
        frame.add(label);

        taskField = new JTextField();
        taskField.setBounds(120, 20, 180, 25);
        frame.add(taskField);

        addButton = new JButton("Add");
        addButton.setBounds(50, 60, 100, 30);
        addButton.addActionListener(this);
        frame.add(addButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(200, 60, 100, 30);
        deleteButton.addActionListener(this);
        frame.add(deleteButton);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBounds(50, 110, 250, 120);
        frame.add(scrollPane);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ToDoList();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {
            String task = taskField.getText();

            if (!task.isEmpty()) {
                listModel.addElement(task);
                taskField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Enter a task!");
            }
        }

        if (e.getSource() == deleteButton) {
            int selectedIndex = taskList.getSelectedIndex();

            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(frame, "Select a task to delete!");
            }
        }
    }
}