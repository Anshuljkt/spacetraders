import javax.swing.*;
import java.awt.*;

public class ConfirmationBoxUI {

    public void ConfirmBox(String message, String buttonMessage) {
        JFrame frame = new JFrame();
        frame.setSize(400, 100);
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
        c.gridx = 0;
        c.gridy = 1;
        confimButton.addActionListener(e -> {
            //find way to pass through bool
            frame.setVisible(false);
        });

        confirmationPanel.add(confimButton, c);

        JButton cancelButton = new JButton("Cancel");
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 1;
        cancelButton.addActionListener(e -> {
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
}
