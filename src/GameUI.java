import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameUI {
    private static Game game;
    private static int regDisplay = 0;
    private static JFrame frame;


    public GameUI(Game game) {
        GameUI.game = game;
        frame = new JFrame("Space Trader");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new GridBagLayout());
    }

    static void playGame() {

        GridBagConstraints c = new GridBagConstraints();

        JList playerInfo = new JList(Player.toArray());
        playerPanel(playerInfo);

        JList currReg = new JList(Player.getRegion().toArray());
        curRegPanel(currReg);

        JList shipList = new JList(Player.getShip().toArray());
        shipPanel(shipList);

        JList regFocus = new JList(game.getUniverse().getRegions()[regDisplay].toArray());
        travelPanel(regFocus, currReg, playerInfo, shipList);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void shipPanel(JList shipList) {
        JPanel shipPanel = new JPanel();
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = .33;
        shipPanel.add(shipList);
        frame.add(shipPanel, c);
    }

    public static JFrame getFrame() {
        return frame;
    }

    private static void playerPanel(JList playerInfo) {
        JPanel playerPanel = new JPanel();
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = .33;
        playerPanel.add(playerInfo);
        frame.add(playerInfo, c);
    }

    private static void curRegPanel(JList currReg) {
        JPanel curRegPanel = new JPanel();
        curRegPanel.setLayout(new GridBagLayout());
        JLabel current = new JLabel("Current Region: ");
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        curRegPanel.add(current, c);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        curRegPanel.add(currReg, c);

        JButton tradeButton = new JButton("Trade");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        tradeButton.addActionListener(e -> {
            //trade actions
            new MarketUI(game, Player.getRegion().getMarket());
            MarketUI.openMarket();
            frame.setVisible(false);
        });
        curRegPanel.add(tradeButton, c);

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 1;
        c.ipady = 20;
        c.weightx = .33;

        frame.add(curRegPanel, c);
    }

    private static void travelPanel(JList regFocus, JList currReg,
                                    JList playerInfo, JList shipList) {
        JPanel travelPanel = new JPanel();
        travelPanel.setLayout(new GridBagLayout());

        JLabel travel = new JLabel("Regions:");
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;

        travelPanel.add(travel, c);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;

        travelPanel.add(regFocus, c);

        JLabel distText = new JLabel();
        String distTextDesc = "Distance: ";
        distText.setHorizontalAlignment(JLabel.CENTER);
        distText.setText("<html>" + distTextDesc + game.getUniverse().getRegions()[regDisplay]
                .findDistance() + "</html>");
        c.gridx = 1;
        c.gridy = 2;

        travelPanel.add(distText, c);

        JLabel fuelCostText = new JLabel();
        String fuelCostTextDesc = "Fuel Cost: ";
        fuelCostText.setHorizontalAlignment(JLabel.CENTER);
        fuelCostText.setText("<html>" + fuelCostTextDesc + (game
                .getUniverse().getRegions()[regDisplay]
                .findDistance() / Player.getPilot() / 5) + "</html>");
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
                    .findDistance() + "</html>");
            fuelCostText.setText("<html>" + fuelCostTextDesc + (game
                    .getUniverse().getRegions()[regDisplay]
                    .findDistance() / Player.getPilot() / 5) + "</html>");
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
                    .findDistance() + "</html>");
            fuelCostText.setText("<html>" + fuelCostTextDesc + (game
                    .getUniverse().getRegions()[regDisplay]
                    .findDistance() / Player.getPilot() / 5) + "</html>");
        });

        travelPanel.add(right, c);

        JButton travelHere = new JButton("Travel Here");
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 4;
        //Travel Actions
        travelHere.addActionListener(e -> {
            if (Player.getRegion().getName().equals(game.getUniverse()
                    .getRegions()[regDisplay].getName())) {
                ConfirmationBoxUI
                        .confirmBox("You cannot travel to the region you're already in.", "Ok");
            } else if (Player.getFuel() >= game
                    .getUniverse().getRegions()[regDisplay].findDistance()
                    / Player.getPilot() / 5) {
                ConfirmationBoxUI travelConf = new ConfirmationBoxUI();
                ConfirmationBoxUI.actionConfirmBox("Are you sure you'd like to travel here?"
                        , "Yes", ActionListener -> {
                        Player.subFuel(game
                            .getUniverse().getRegions()[regDisplay]
                            .findDistance() / Player.getPilot() / 5);
                        Random rand = new Random();
                        double encounterChance = rand.nextDouble();
                        double threshold = .5;
                        double tChance = 1;
                        double pChance = .5;
                        double bChance = .25;
                        if (game.getDifficulty().equals("Hard")) {
                            bChance = .4;
                            pChance = .8;
                        } else if (game.getDifficulty().equals("Medium")) {
                            bChance = .3;
                            pChance = .6;
                        } else if (game.getDifficulty().equals("Easy")) {
                            bChance = .2;
                            pChance = .4;
                        }
                        if (encounterChance < .5) {
                            encounterChance = rand.nextDouble();
                            String[] encounterTypes = {"Bandit", "Trader", "Police"};
                            int selectedEncounter;
                            if (encounterChance <= bChance) {
                                selectedEncounter = 0;
                            } else if (encounterChance <= pChance) {
                                if (Player.getInvSize() > 0) {
                                    selectedEncounter = 2;
                                } else {
                                    selectedEncounter = 0;
                                }
                            } else {
                                selectedEncounter = 1;
                            }
                            NpcUI npc = new NpcUI(game, encounterTypes[selectedEncounter]);
                            frame.setVisible(false);
                            frame.dispose();
                            NpcUI.startNPCEncounter(Player.getRegion()
                                , game.getUniverse().getRegions()[regDisplay]);
                        } else {
                            Player.setRegion(game.getUniverse().getRegions()[regDisplay]);
                        }
                        currReg.setListData(Player.getRegion().toArray());
                        distText.setText("<html>" + distTextDesc + game
                            .getUniverse().getRegions()[regDisplay]
                            .findDistance() + "</html>");
                        fuelCostText.setText("<html>" + fuelCostTextDesc + (game
                            .getUniverse().getRegions()[regDisplay]
                            .findDistance() / Player.getPilot()) + "</html>");
                        playerInfo.setListData(Player.toArray());
                        shipList.setListData(Player.getShip().toArray());
                        Player.adjustInvPricing();
                    });
            } else {
                ConfirmationBoxUI notEnoughFuel = new ConfirmationBoxUI();
                ConfirmationBoxUI.confirmBox("You don't have the fuel to travel here.", "Ok");
            }
        });

        travelPanel.add(travelHere, c);
        c.gridy = 1;
        c.gridx = 1;
        c.weightx = .33;
        c.ipady = 10;
        c.anchor = GridBagConstraints.NORTH;

        frame.add(travelPanel, c);
    }

    public void restartGame() {
        frame.setVisible(false);
        frame.dispose();
        WelcomeScreen.main(null);
    }

}
