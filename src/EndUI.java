import javax.swing.*;
import java.awt.*;

public class EndUI {

    public static void endUI(Game game, String message) {
        JFrame frame = new JFrame();
        frame.setSize(500, 150);
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints c = new GridBagConstraints();

        JPanel confirmationPanel = new JPanel();
        confirmationPanel.setLayout(new GridBagLayout());

        JLabel mark = new JLabel(message);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;

        confirmationPanel.add(mark, c);

        JButton confimButton = new JButton("Restart");
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        confimButton.addActionListener(e -> {
            //find way to pass through bool
            frame.setVisible(false);
            frame.dispose();
            GameUI.restartGame();
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
