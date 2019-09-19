import javax.swing.*;
import java.awt.*;

public class WelcomeScreen {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Space Trader by Runtime Terror");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel welcome = new JLabel("Welcome to Space Trader!");
        welcome.setHorizontalAlignment(JLabel.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 0.3;
        frame.add(welcome, c);

        JLabel creators = new JLabel("Developed by Team 27 - Runtime Terror");
        creators.setHorizontalAlignment(JLabel.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.weighty = 0.2;
        frame.add(creators, c);

        JButton button = new JButton("New Game");
        c.fill = GridBagConstraints.SOUTH;
        c.gridx = 0;
        c.weighty = 0.3;
        c.gridy = 3;
        c.anchor = GridBagConstraints.PAGE_END;
        frame.add(button, c);
        frame.setVisible(true);
    }
}
