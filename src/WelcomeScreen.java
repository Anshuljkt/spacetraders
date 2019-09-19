import javax.swing.*;
import java.awt.*;

class WelcomeScreen {
    /**
     * Main method to drive initial game setup
     * @param args special inputs
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Space Trader by Runtime Terror");
        javax.swing.SwingUtilities.invokeLater(() -> showStartPage(frame));
    }

    private static void showStartPage(JFrame frame) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel welcome = new JLabel("Welcome to Space Trader!");
        welcome.setHorizontalAlignment(JLabel.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 0.5;
        frame.add(welcome, c);

        JLabel creators = new JLabel("Developed by Team 27 - Runtime Terror");
        creators.setHorizontalAlignment(JLabel.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.weighty = 0.1;
        frame.add(creators, c);

        JButton startButton = new JButton("New Game");
        c.fill = GridBagConstraints.SOUTH;
        c.gridx = 0;
        c.gridy = 2;
        c.weighty = 0.4;
        c.anchor = GridBagConstraints.PAGE_END;
        startButton.addActionListener(e -> {
            showConfigPage(frame);
            System.out.println("New Game Started.");
        });
        frame.add(startButton, c);
        frame.setVisible(true);
    }

    //TODO: configPage
    private static void showConfigPage(JFrame frame) {
        frame.setVisible(false);
        frame.dispose();
        frame = new JFrame("Character Selection");
        frame.setVisible(true);
    }
}
