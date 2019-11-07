import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ConfirmationBoxUI {

    public static void confirmBox(String message, String buttonMessage) {
        JFrame frame = new JFrame();
        frame.setSize(500, 150);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JPanel confirmationPanel = new JPanel();
        confirmationPanel.setLayout(new GridBagLayout());

        JLabel mark = new JLabel(message);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;

        confirmationPanel.add(mark, c);

        JButton confimButton = new JButton(buttonMessage);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        confimButton.addActionListener(e -> {
            //find way to pass through bool
            frame.setVisible(false);
        });

        confirmationPanel.add(confimButton, c);

        c = new GridBagConstraints();
        c.gridy = 0;
        c.gridx = 2;
        c.weightx = 1;
        c.anchor = GridBagConstraints.CENTER;

        frame.add(confirmationPanel, c);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void actionConfirmBox(String message, String buttonMessage, ActionListener e) {
        JFrame frame = new JFrame();
        frame.setSize(500, 150);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JPanel confirmationPanel = new JPanel();
        confirmationPanel.setLayout(new GridBagLayout());

        JLabel mark = new JLabel(message);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;

        confirmationPanel.add(mark, c);

        JButton confirmButton = new JButton(buttonMessage);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        confirmButton.addActionListener(e);
        confirmButton.addActionListener(a -> {
            frame.setVisible(false);
        });

        confirmationPanel.add(confirmButton, c);

        JButton cancelButton = new JButton("Cancel");
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 1;
        cancelButton.addActionListener(a -> {
            frame.setVisible(false);
        });

        confirmationPanel.add(cancelButton, c);

        c = new GridBagConstraints();
        c.gridy = 0;
        c.gridx = 2;
        c.weightx = 1;
        c.anchor = GridBagConstraints.CENTER;

        frame.add(confirmationPanel, c);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void actionBox(String message, String buttonMessage, ActionListener e) {
        JFrame frame = new JFrame();
        frame.setSize(500, 150);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JPanel confirmationPanel = new JPanel();
        confirmationPanel.setLayout(new GridBagLayout());

        JLabel mark = new JLabel(message);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;

        confirmationPanel.add(mark, c);

        JButton confimButton = new JButton(buttonMessage);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        confimButton.addActionListener(e);
        confimButton.addActionListener(a -> {
            frame.setVisible(false);
        });

        confirmationPanel.add(confimButton, c);

        c = new GridBagConstraints();
        c.gridy = 0;
        c.gridx = 2;
        c.weightx = 1;
        c.anchor = GridBagConstraints.CENTER;

        frame.add(confirmationPanel, c);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
