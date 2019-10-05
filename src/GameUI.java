import javax.swing.*;
import java.awt.*;

public class GameUI {
    static private Game game;
    static private int regDisplay = 0;


    public GameUI(Game game) {
        this.game = game;
    }

    static void playGame() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JPanel playerPanel = new JPanel();
        JList playerInfo = new JList(game.getPlayer().toArray());
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 0;

        playerPanel.add(playerInfo);
        frame.add(playerInfo, c);

        JPanel curRegPanel = new JPanel();
        curRegPanel.setLayout(new GridBagLayout());

        JLabel current = new JLabel("Current Region: ");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;

        curRegPanel.add(current, c);

        JList currReg = new JList(game.getPlayer().getRegion().toArray());

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;

        curRegPanel.add(currReg, c);

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 1;
        c.gridy = 0;

        frame.add(curRegPanel, c);

        JPanel travelPanel = new JPanel();
        travelPanel.setLayout(new GridBagLayout());

        JLabel travel = new JLabel("Regions:");
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;

        travelPanel.add(travel, c);

        JList regFocus = new JList(game.getUniverse().getRegions()[regDisplay].toArray());
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;

        travelPanel.add(regFocus, c);

        JLabel distText = new JLabel();
        String distTextDesc = "Distance: ";
        distText.setHorizontalAlignment(JLabel.CENTER);
        distText.setText("<html>" + distTextDesc + game.getUniverse().getRegions()[regDisplay]
                .findDistance(game.getPlayer()) + "</html>");
        c.gridx = 1;
        c.gridy = 2;

        travelPanel.add(distText, c);

        JButton left = new JButton("<");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.CENTER;
        left.addActionListener(e -> {
            if (regDisplay == 0) {
                regDisplay = 9;
            } else {
                regDisplay--;
            }
            regFocus.setListData(game.getUniverse().getRegions()[regDisplay].toArray());
            distText.setText("<html>" + distTextDesc + game.getUniverse().getRegions()[regDisplay]
                    .findDistance(game.getPlayer()) + "</html>");
        });

        travelPanel.add(left, c);

        JButton right = new JButton(">");
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 1;
        c.anchor = GridBagConstraints.CENTER;
        right.addActionListener(e -> {
            if (regDisplay == 9) {
                regDisplay = 0;
            } else {
                regDisplay++;
            }
            regFocus.setListData(game.getUniverse().getRegions()[regDisplay].toArray());
            distText.setText("<html>" + distTextDesc + game.getUniverse().getRegions()[regDisplay]
                    .findDistance(game.getPlayer()) + "</html>");
        });

        travelPanel.add(right, c);

        JButton travelHere = new JButton("Travel Here");
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 3;
        travelHere.addActionListener(e -> {
            game.getPlayer().setRegion(game.getUniverse().getRegions()[regDisplay]);
            currReg.setListData(game.getUniverse().getRegions()[regDisplay].toArray());
            distText.setText("<html>" + distTextDesc + game.getUniverse().getRegions()[regDisplay]
                    .findDistance(game.getPlayer()) + "</html>");
        });

        travelPanel.add(travelHere, c);

        c = new GridBagConstraints();
        c.gridy = 0;
        c.gridx = 2;
        c.anchor = GridBagConstraints.NORTH;

        frame.add(travelPanel, c);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
