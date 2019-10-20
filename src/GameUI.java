import javax.swing.*;
import java.awt.*;

public class GameUI {
    private static Game game;
    private static int regDisplay = 0;


    public GameUI(Game game) {
        GameUI.game = game;
    }

    static void playGame() {

        JFrame frame = new JFrame("Space Trader");
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
        c.weightx = .33;

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
        c.weightx = .33;

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

        JLabel fuelCostText = new JLabel();
        String fuelCostTextDesc = "Fuel Cost: ";
        fuelCostText.setHorizontalAlignment(JLabel.CENTER);
        fuelCostText.setText("<html>" + fuelCostTextDesc + (game.getUniverse().getRegions()[regDisplay]
                .findDistance(game.getPlayer()) / game.getPlayer().getPilot()) + "</html>");
        c.gridx = 1;
        c.gridy = 3;

        travelPanel.add(fuelCostText, c);

        JButton left = new JButton("<");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.CENTER;
        left.addActionListener(e -> {
            if (regDisplay == 0) {
                regDisplay = game.getRegionNames().length - 1;
            } else {
                regDisplay--;
            }
            regFocus.setListData(game.getUniverse().getRegions()[regDisplay].toArray());
            distText.setText("<html>" + distTextDesc + game.getUniverse().getRegions()[regDisplay]
                    .findDistance(game.getPlayer()) + "</html>");
            fuelCostText.setText("<html>" + fuelCostTextDesc + (game.getUniverse().getRegions()[regDisplay]
                    .findDistance(game.getPlayer()) / game.getPlayer().getPilot()) + "</html>");
        });

        travelPanel.add(left, c);

        JButton right = new JButton(">");
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 1;
        c.anchor = GridBagConstraints.CENTER;
        right.addActionListener(e -> {
            if (regDisplay == game.getRegionNames().length - 1) {
                regDisplay = 0;
            } else {
                regDisplay++;
            }
            regFocus.setListData(game.getUniverse().getRegions()[regDisplay].toArray());
            distText.setText("<html>" + distTextDesc + game.getUniverse().getRegions()[regDisplay]
                    .findDistance(game.getPlayer()) + "</html>");
            fuelCostText.setText("<html>" + fuelCostTextDesc + (game.getUniverse().getRegions()[regDisplay]
                    .findDistance(game.getPlayer()) / game.getPlayer().getPilot()) + "</html>");
        });

        travelPanel.add(right, c);

        JButton travelHere = new JButton("Travel Here");
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 4;
        //Travel Actions
        travelHere.addActionListener(e -> {
            if (game.getPlayer().getFuel() >= game.getUniverse().getRegions()[regDisplay].findDistance(game.getPlayer())
                    / game.getPlayer().getPilot()) {
                game.getPlayer().subFuel(game.getUniverse().getRegions()[regDisplay]
                        .findDistance(game.getPlayer()) / game.getPlayer().getPilot());
                game.getPlayer().setRegion(game.getUniverse().getRegions()[regDisplay]);
                currReg.setListData(game.getUniverse().getRegions()[regDisplay].toArray());
                distText.setText("<html>" + distTextDesc + game.getUniverse().getRegions()[regDisplay]
                        .findDistance(game.getPlayer()) + "</html>");
                fuelCostText.setText("<html>" + fuelCostTextDesc + (game.getUniverse().getRegions()[regDisplay]
                        .findDistance(game.getPlayer()) / game.getPlayer().getPilot()) + "</html>");
            }

        });

        travelPanel.add(travelHere, c);

        JButton tradeButton = new JButton("Trade");
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 2;
        tradeButton.addActionListener(e -> {
            //trade actions
            new MarketUI(game, game.getPlayer().getRegion().getMarket());
            MarketUI.openMarket();
        });

        frame.add(tradeButton, c);

        c = new GridBagConstraints();
        c.gridy = 0;
        c.gridx = 2;
        c.weightx = .33;
        c.anchor = GridBagConstraints.NORTH;

        frame.add(travelPanel, c);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
