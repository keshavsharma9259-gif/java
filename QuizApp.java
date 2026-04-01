import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizApp implements ActionListener {

    JFrame frame;
    JLabel questionLabel;
    JRadioButton option1, option2, option3, option4;
    JButton nextButton, resultButton;
    ButtonGroup group;

    int currentQuestion = 0;
    int score = 0;

    String[][] questions = {
        {"Java is a ?", "Programming Language", "Database", "Operating System", "Browser"},
        {"Which is not OOP concept?", "Encapsulation", "Polymorphism", "Compilation", "Inheritance"},
        {"Java uses ?", "Pointer", "Compiler", "Interpreter", "Both Compiler & Interpreter"}
    };

    int[] answers = {0, 2, 3}; // correct options index

    QuizApp() {
        frame = new JFrame("Quiz App");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        questionLabel = new JLabel();
        questionLabel.setBounds(30, 30, 400, 30);
        frame.add(questionLabel);

        option1 = new JRadioButton();
        option2 = new JRadioButton();
        option3 = new JRadioButton();
        option4 = new JRadioButton();

        option1.setBounds(50, 70, 300, 25);
        option2.setBounds(50, 100, 300, 25);
        option3.setBounds(50, 130, 300, 25);
        option4.setBounds(50, 160, 300, 25);

        group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);
        group.add(option4);

        frame.add(option1);
        frame.add(option2);
        frame.add(option3);
        frame.add(option4);

        nextButton = new JButton("Next");
        nextButton.setBounds(100, 200, 100, 30);
        nextButton.addActionListener(this);
        frame.add(nextButton);

        resultButton = new JButton("Result");
        resultButton.setBounds(250, 200, 100, 30);
        resultButton.addActionListener(this);
        frame.add(resultButton);

        loadQuestion();

        frame.setVisible(true);
    }

    void loadQuestion() {
        group.clearSelection();

        questionLabel.setText("Q" + (currentQuestion + 1) + ": " + questions[currentQuestion][0]);

        option1.setText(questions[currentQuestion][1]);
        option2.setText(questions[currentQuestion][2]);
        option3.setText(questions[currentQuestion][3]);
        option4.setText(questions[currentQuestion][4]);
    }

    public static void main(String[] args) {
        new QuizApp();
    }

    public void actionPerformed(ActionEvent e) {

        int selected = -1;

        if (option1.isSelected()) selected = 0;
        if (option2.isSelected()) selected = 1;
        if (option3.isSelected()) selected = 2;
        if (option4.isSelected()) selected = 3;

        if (selected == answers[currentQuestion]) {
            score++;
        }

        if (e.getSource() == nextButton) {
            currentQuestion++;
            if (currentQuestion < questions.length) {
                loadQuestion();
            } else {
                JOptionPane.showMessageDialog(frame, "Quiz Finished!");
            }
        }

        if (e.getSource() == resultButton) {
            JOptionPane.showMessageDialog(frame, "Your Score: " + score + "/" + questions.length);
        }
    }
}
