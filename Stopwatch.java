import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Stopwatch implements ActionListener {

    JFrame frame;
    JLabel timeLabel;
    JButton startButton, stopButton, resetButton;

    int seconds = 0;
    boolean running = false;

    Timer timer;

    Stopwatch() {
        frame = new JFrame("Stopwatch");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        timeLabel = new JLabel("00:00:00");
        timeLabel.setBounds(80, 20, 150, 40);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 25));
        frame.add(timeLabel);

        startButton = new JButton("Start");
        startButton.setBounds(20, 80, 80, 30);
        startButton.addActionListener(this);
        frame.add(startButton);

        stopButton = new JButton("Stop");
        stopButton.setBounds(110, 80, 80, 30);
        stopButton.addActionListener(this);
        frame.add(stopButton);

        resetButton = new JButton("Reset");
        resetButton.setBounds(200, 80, 80, 30);
        resetButton.addActionListener(this);
        frame.add(resetButton);

        // Timer runs every 1 second
        timer = new Timer(1000, e -> updateTime());

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Stopwatch();
    }

    void updateTime() {
        if (running) {
            seconds++;

            int hrs = seconds / 3600;
            int mins = (seconds % 3600) / 60;
            int secs = seconds % 60;

            timeLabel.setText(String.format("%02d:%02d:%02d", hrs, mins, secs));
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startButton) {
            running = true;
            timer.start();
        }

        if (e.getSource() == stopButton) {
            running = false;
        }

        if (e.getSource() == resetButton) {
            running = false;
            seconds = 0;
            timeLabel.setText("00:00:00");
        }
    }
}