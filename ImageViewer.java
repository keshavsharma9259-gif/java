import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class ImageViewer implements ActionListener {

    JFrame frame;
    JLabel imageLabel;
    JButton openButton;

    ImageViewer() {
        frame = new JFrame("Image Viewer");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        imageLabel = new JLabel("No Image Selected", JLabel.CENTER);
        frame.add(imageLabel, BorderLayout.CENTER);

        openButton = new JButton("Open Image");
        openButton.addActionListener(this);
        frame.add(openButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ImageViewer();
    }

    public void actionPerformed(ActionEvent e) {

        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(frame);

        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            ImageIcon icon = new ImageIcon(file.getAbsolutePath());

            // Resize image to fit label
            Image img = icon.getImage().getScaledInstance(
                    frame.getWidth(),
                    frame.getHeight() - 50,
                    Image.SCALE_SMOOTH
            );

            imageLabel.setIcon(new ImageIcon(img));
            imageLabel.setText("");
        }
    }
}