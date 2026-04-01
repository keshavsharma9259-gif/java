import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginScreen implements ActionListener {

    JFrame frame;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;

    LoginScreen() {
        frame = new JFrame("Login Screen");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Username Label
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 30, 100, 25);
        frame.add(userLabel);

        // Username Field
        usernameField = new JTextField();
        usernameField.setBounds(120, 30, 150, 25);
        frame.add(usernameField);

        // Password Label
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 70, 100, 25);
        frame.add(passLabel);

        // Password Field
        passwordField = new JPasswordField();
        passwordField.setBounds(120, 70, 150, 25);
        frame.add(passwordField);

        // Login Button
        loginButton = new JButton("Login");
        loginButton.setBounds(120, 110, 100, 30);
        loginButton.addActionListener(this);
        frame.add(loginButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginScreen();
    }

    public void actionPerformed(ActionEvent e) {

        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Simple check
        if (username.equals("admin") && password.equals("1234")) {
            JOptionPane.showMessageDialog(frame, "Login Successful ✅");
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid Username or Password ❌");
        }
    }
}