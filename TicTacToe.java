import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe implements ActionListener {

    JFrame frame;
    JButton[] buttons = new JButton[9];
    boolean playerX = true;

    TicTacToe() {
        frame = new JFrame("Tic-Tac-Toe");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 40));
            buttons[i].addActionListener(this);
            frame.add(buttons[i]);
        }

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new TicTacToe();
    }

    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if (!clicked.getText().equals("")) return;

        if (playerX) {
            clicked.setText("X");
        } else {
            clicked.setText("O");
        }

        playerX = !playerX;

        checkWinner();
    }

    void checkWinner() {

        int[][] winPositions = {
            {0,1,2}, {3,4,5}, {6,7,8}, // rows
            {0,3,6}, {1,4,7}, {2,5,8}, // cols
            {0,4,8}, {2,4,6}           // diagonals
        };

        for (int[] pos : winPositions) {
            if (!buttons[pos[0]].getText().equals("") &&
                buttons[pos[0]].getText().equals(buttons[pos[1]].getText()) &&
                buttons[pos[1]].getText().equals(buttons[pos[2]].getText())) {

                JOptionPane.showMessageDialog(frame,
                        buttons[pos[0]].getText() + " Wins!");

                resetGame();
                return;
            }
        }
    }

    void resetGame() {
        for (JButton btn : buttons) {
            btn.setText("");
        }
        playerX = true;
    }
}