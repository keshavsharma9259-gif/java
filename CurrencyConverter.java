import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyConverter implements ActionListener {

    JFrame frame;
    JTextField amountField, resultField;
    JComboBox<String> fromCurrency, toCurrency;
    JButton convertButton;

    String[] currencies = {"INR", "USD", "EUR"};

    CurrencyConverter() {
        frame = new JFrame("Currency Converter");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(30, 30, 100, 25);
        frame.add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(120, 30, 150, 25);
        frame.add(amountField);

        fromCurrency = new JComboBox<>(currencies);
        fromCurrency.setBounds(30, 70, 100, 25);
        frame.add(fromCurrency);

        toCurrency = new JComboBox<>(currencies);
        toCurrency.setBounds(170, 70, 100, 25);
        frame.add(toCurrency);

        convertButton = new JButton("Convert");
        convertButton.setBounds(120, 110, 100, 30);
        convertButton.addActionListener(this);
        frame.add(convertButton);

        resultField = new JTextField();
        resultField.setBounds(120, 160, 150, 25);
        resultField.setEditable(false);
        frame.add(resultField);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }

    public void actionPerformed(ActionEvent e) {

        try {
            double amount = Double.parseDouble(amountField.getText());
            String from = (String) fromCurrency.getSelectedItem();
            String to = (String) toCurrency.getSelectedItem();

            double result = convert(amount, from, to);
            resultField.setText(String.format("%.2f", result));

        } catch (Exception ex) {
            resultField.setText("Invalid Input!");
        }
    }

    double convert(double amount, String from, String to) {

        // Convert everything to INR first
        double inr = 0;

        if (from.equals("INR")) inr = amount;
        if (from.equals("USD")) inr = amount * 83;
        if (from.equals("EUR")) inr = amount * 90;

        // Convert INR to target
        if (to.equals("INR")) return inr;
        if (to.equals("USD")) return inr / 83;
        if (to.equals("EUR")) return inr / 90;

        return 0;
    }
}