import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class NumberGuessingGame implements ActionListener {

    JFrame frame;
    JTextField guessField;
    JButton guessButton, resetButton;
    JLabel messageLabel;

    int number;
    int attempts = 0;

    NumberGuessingGame() {
        frame = new JFrame("Number Guessing Game");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel instruction = new JLabel("Guess a number (1-100):");
        instruction.setBounds(80, 20, 200, 25);
        frame.add(instruction);

        guessField = new JTextField();
        guessField.setBounds(100, 50, 120, 30);
        frame.add(guessField);

        guessButton = new JButton("Guess");
        guessButton.setBounds(50, 100, 100, 30);
        guessButton.addActionListener(this);
        frame.add(guessButton);

        resetButton = new JButton("Reset");
        resetButton.setBounds(180, 100, 100, 30);
        resetButton.addActionListener(this);
        frame.add(resetButton);

        messageLabel = new JLabel(" ");
        messageLabel.setBounds(80, 150, 250, 25);
        frame.add(messageLabel);

        generateNumber();

        frame.setVisible(true);
    }

    void generateNumber() {
        Random rand = new Random();
        number = rand.nextInt(100) + 1; // 1 to 100
        attempts = 0;
    }

    public static void main(String[] args) {
        new NumberGuessingGame();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == guessButton) {
            try {
                int guess = Integer.parseInt(guessField.getText());
                attempts++;

                if (guess < number) {
                    messageLabel.setText("Too Low! Attempts: " + attempts);
                } else if (guess > number) {
                    messageLabel.setText("Too High! Attempts: " + attempts);
                } else {
                    messageLabel.setText("Correct 🎉 in " + attempts + " attempts");
                }

            } catch (Exception ex) {
                messageLabel.setText("Enter valid number!");
            }
        }

        if (e.getSource() == resetButton) {
            generateNumber();
            guessField.setText("");
            messageLabel.setText("Game Reset! Try again.");
        }
    }
}