import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock {

    JFrame frame;
    JLabel timeLabel;

    DigitalClock() {
        frame = new JFrame("Digital Clock");
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        frame.add(timeLabel);

        // Timer (updates every second)
        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();

        frame.setVisible(true);
    }

    void updateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String currentTime = sdf.format(new Date());
        timeLabel.setText(currentTime);
    }

    public static void main(String[] args) {
        new DigitalClock();
    }
}