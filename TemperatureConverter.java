import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConverter implements ActionListener {

    JFrame frame;
    JTextField inputField, resultField;
    JButton cToFButton, fToCButton;

    TemperatureConverter() {
        frame = new JFrame("Temperature Converter");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel inputLabel = new JLabel("Enter Value:");
        inputLabel.setBounds(30, 30, 100, 25);
        frame.add(inputLabel);

        inputField = new JTextField();
        inputField.setBounds(130, 30, 150, 25);
        frame.add(inputField);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(30, 70, 100, 25);
        frame.add(resultLabel);

        resultField = new JTextField();
        resultField.setBounds(130, 70, 150, 25);
        resultField.setEditable(false);
        frame.add(resultField);

        cToFButton = new JButton("C → F");
        cToFButton.setBounds(40, 120, 100, 30);
        cToFButton.addActionListener(this);
        frame.add(cToFButton);

        fToCButton = new JButton("F → C");
        fToCButton.setBounds(180, 120, 100, 30);
        fToCButton.addActionListener(this);
        frame.add(fToCButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new TemperatureConverter();
    }

    public void actionPerformed(ActionEvent e) {

        try {
            double value = Double.parseDouble(inputField.getText());
            double result;

            if (e.getSource() == cToFButton) {
                result = (value * 9 / 5) + 32;
                resultField.setText(result + " °F");
            }

            if (e.getSource() == fToCButton) {
                result = (value - 32) * 5 / 9;
                resultField.setText(result + " °C");
            }

        } catch (Exception ex) {
            resultField.setText("Invalid Input!");
        }
    }
}