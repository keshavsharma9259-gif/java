import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdvancedClock {

    JFrame frame;
    JLabel timeLabel;

    AdvancedClock() {
        frame = new JFrame("Advanced Digital Clock");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 25));
        timeLabel.setForeground(Color.BLUE);
        frame.add(timeLabel);

        // Timer (updates every second)
        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();

        frame.setVisible(true);
    }

    void updateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
        String currentTime = sdf.format(new Date());
        timeLabel.setText(currentTime);
    }

    public static void main(String[] args) {
        new AdvancedClock();
    }
}