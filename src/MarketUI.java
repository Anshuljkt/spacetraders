import javax.swing.*;
import java.awt.*;

public class MarketUI {

    private static Game game;
    private static Market market;
    private static int regDisplayMark;
    private static int regDisplayPlayer;
    private static JFrame frame;
    private static JList regFocus;
    private static JList regFocusPlayer;
    private static JList playerInfo;
    private static JList shipList;

    public MarketUI(Game game, Market market) {
        this.game = game;
        this.market = market;
        regDisplayMark = 0;
        regDisplayPlayer = 0;
    }

    static void openMarket() {
        frame = new JFrame("" + game.getPlayer().getRegion().getName() + " Market");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 450);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //Market Panel

        playerInfo = new JList(Player.toArray());
        playerPanel(playerInfo);

        shipList = new JList(Player.getShip().toArray());
        shipPanel(shipList);

        JPanel marketPanel = new JPanel();
        marketPanel.setLayout(new GridBagLayout());
        marketPanel(marketPanel);

        //Player Panel

        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new GridBagLayout());
        playerPanel(playerPanel);

        JPanel fuelPanel = new JPanel();
        fuelPanel.setLayout(new GridBagLayout());
        fuelPanel(fuelPanel);

        JPanel healthPanel = new JPanel();
        healthPanel.setLayout(new GridBagLayout());
        healthPanel(healthPanel);


        JButton doneButton = new JButton("Done");
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 3;
        doneButton.addActionListener(e -> {
            new GameUI(MarketUI.game);
            GameUI.playGame();
            MarketUI.frame.setVisible(false);
        });

        frame.add(doneButton, c);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void shipPanel(JList shipList) {
        JPanel shipPanel = new JPanel();
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = .33;
        shipPanel.add(shipList);
        frame.add(shipPanel, c);
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

    private static void marketPanel(JPanel marketPanel) {
        JLabel mark = new JLabel("Market Goods:");
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;

        marketPanel.add(mark, c);

        regFocus = new JList(market.toArray(regDisplayMark));
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;

        marketPanel.add(regFocus, c);

        JButton leftMark = new JButton("<");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.CENTER;
        leftMark.addActionListener(e -> {
            if (regDisplayMark == 0) {
                regDisplayMark = market.getGoodsLength() - 1;
            } else {
                regDisplayMark--;
            }
            regFocus.setListData(market.toArray(regDisplayMark));
        });

        marketPanel.add(leftMark, c);

        JButton rightMark = new JButton(">");
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 1;
        c.anchor = GridBagConstraints.CENTER;
        rightMark.addActionListener(e -> {
            if (regDisplayMark == market.getGoodsLength() - 1) {
                regDisplayMark = 0;
            } else {
                regDisplayMark++;
            }
            regFocus.setListData(market.toArray(regDisplayMark));
        });

        marketPanel.add(rightMark, c);

        //**** Buy Button ****
        JButton buyButton = new JButton("Buy");
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 2;
        buyButton.addActionListener(e -> {
            if (market.getGoodBuyPrice(regDisplayMark) <= game.getPlayer().getCredits()) {
                if (market.getGoodCargo(regDisplayMark) <= game.getPlayer().getCargoLeft()) {
                    game.getPlayer().subCargoLeft(market.getGoodCargo(regDisplayMark));
                    game.getPlayer().subCredits((int) market.getGoodBuyPrice(regDisplayMark));

                    if (market.getGoodName(regDisplayMark)
                            .equals(Player.getName() + "'s Universe")) {
                        //end game
                        frame.setVisible(false);
                        frame.dispose();
                        EndUI.endUI(game, "You Have Won!");
                    }

                    game.getPlayer().addInv(market.removeGood(regDisplayMark));
                    if (regDisplayMark >= market.getGoodsLength() && market.getGoodsLength() != 0) {
                        regDisplayMark = market.getGoodsLength() - 1;
                    } else {
                        regDisplayMark = 0;
                    }
                    regFocus.setListData(market.toArray(regDisplayMark));
                    regFocusPlayer.setListData(game.getPlayer().invToArray(regDisplayPlayer));
                    playerInfo.setListData(Player.toArray());
                    shipList.setListData(Player.getShip().toArray());
                } else {
                    ConfirmationBoxUI notEnoughSpace = new ConfirmationBoxUI();
                    notEnoughSpace.confirmBox("Not enough space to purchase", "Ok");
                }
            } else {
                ConfirmationBoxUI notEnoughMoney = new ConfirmationBoxUI();
                notEnoughMoney.confirmBox("Not enough money to purchase", "Ok");
            }
        });

        marketPanel.add(buyButton, c);

        c = new GridBagConstraints();
        c.gridy = 1;
        c.gridx = 2;
        c.weightx = 1;
        c.anchor = GridBagConstraints.EAST;

        frame.add(marketPanel, c);
    }

    private static void playerPanel(JPanel playerPanel) {
        JLabel pl = new JLabel("Inventory:");
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;

        playerPanel.add(pl, c);

        regFocusPlayer = new JList(game.getPlayer().invToArray(regDisplayPlayer));
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;

        playerPanel.add(regFocusPlayer, c);

        JButton leftPlayer = new JButton("<");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.CENTER;
        leftPlayer.addActionListener(e -> {
            if (regDisplayPlayer == 0) {
                regDisplayPlayer = game.getPlayer().getInvSize() - 1;
            } else {
                regDisplayPlayer--;
            }
            regFocusPlayer.setListData(game.getPlayer().invToArray(regDisplayPlayer));
        });

        playerPanel.add(leftPlayer, c);

        JButton rightPlayer = new JButton(">");
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 1;
        c.anchor = GridBagConstraints.CENTER;
        rightPlayer.addActionListener(e -> {
            if (regDisplayPlayer == game.getPlayer().getInvSize() - 1) {
                regDisplayPlayer = 0;
            } else {
                regDisplayPlayer++;
            }
            regFocusPlayer.setListData(game.getPlayer().invToArray(regDisplayPlayer));
        });

        playerPanel.add(rightPlayer, c);

        //***** Sell Button ****
        JButton sellButton = new JButton("Sell");
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 2;
        sellButton.addActionListener(e -> {
            if (game.getPlayer().getInvSize() > 0) {
                game.getPlayer().addCargoLeft(game
                        .getPlayer().getItem(regDisplayPlayer).getCargoSpace());
                game.getPlayer().addCredits((int) game
                        .getPlayer().getItem(regDisplayPlayer).getSellPrice());
                System.out.println(Player.getCredits());
                market.addGood(game.getPlayer().subInv(regDisplayPlayer));
                if (regDisplayPlayer >= Player.getInvSize() && Player.getInvSize() != 0) {
                    regDisplayPlayer = Player.getInvSize() - 1;
                } else {
                    regDisplayPlayer = 0;
                }
                regFocus.setListData(market.toArray(regDisplayMark));
                regFocusPlayer.setListData(game.getPlayer().invToArray(regDisplayPlayer));
                playerInfo.setListData(Player.toArray());
                shipList.setListData(Player.getShip().toArray());
            }
        });

        playerPanel.add(sellButton, c);

        c = new GridBagConstraints();
        c.gridy = 1;
        c.gridx = 0;
        c.weightx = 1;
        c.anchor = GridBagConstraints.WEST;

        frame.add(playerPanel, c);

    }

    private static void fuelPanel(JPanel fuelPanel) {
        GridBagConstraints c = new GridBagConstraints();
        JLabel fuel = new JLabel("Refuel");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        fuelPanel.add(fuel, c);

        c = new GridBagConstraints();
        JLabel cost = new JLabel("Cost: 5");
        c.gridx = 0;
        c.gridy = 1;
        fuelPanel.add(cost, c);

        c = new GridBagConstraints();
        JLabel quan = new JLabel("Amount: ");
        c.gridx = 0;
        c.gridy = 2;
        fuelPanel.add(quan, c);

        c = new GridBagConstraints();
        JTextField amount = new JTextField();
        amount.setMinimumSize(new Dimension(100, 30));
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;
        fuelPanel.add(amount, c);

        c = new GridBagConstraints();
        JButton buy = new JButton("Refuel");
        buy.addActionListener(e -> {
            int boughtF = 0;
            try {
                boughtF = Integer.parseInt(amount.getText());
            } catch (Exception f) {
                boughtF = 0;
            }
            if (boughtF != 0) {
                if (boughtF * 5 > Player.getCredits()) {
                    ConfirmationBoxUI notEnoughMoney = new ConfirmationBoxUI();
                    notEnoughMoney.confirmBox("Not enough money to purchase.", "Ok");
                } else if (boughtF > Player.getShip().getFuelCapacity() - Player.getFuel()) {
                    ConfirmationBoxUI notEnoughSpace = new ConfirmationBoxUI();
                    notEnoughSpace.confirmBox("That's more fuel than you need!", "Ok");
                } else {
                    Player.addFuel(boughtF);
                    Player.subCredits(boughtF * 5);
                }
                playerInfo.setListData(Player.toArray());
                shipList.setListData(Player.getShip().toArray());
                amount.setText("");
            }
        });
        c.gridy = 4;
        c.gridx = 0;
        c.gridwidth = 2;
        fuelPanel.add(buy, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        frame.add(fuelPanel, c);
    }

    private static void healthPanel(JPanel healthPanel) {
        int price = 25 / (Player.getEngineer() + 1) + 1;
        GridBagConstraints c = new GridBagConstraints();
        JLabel fuel = new JLabel("Repair");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        healthPanel.add(fuel, c);

        c = new GridBagConstraints();
        JLabel cost = new JLabel(String.format("Cost: %d", price));
        c.gridx = 0;
        c.gridy = 1;
        healthPanel.add(cost, c);

        c = new GridBagConstraints();
        JLabel quan = new JLabel("Amount: ");
        c.gridx = 0;
        c.gridy = 2;
        healthPanel.add(quan, c);

        c = new GridBagConstraints();
        JTextField amount = new JTextField();
        amount.setMinimumSize(new Dimension(100, 30));
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;
        healthPanel.add(amount, c);

        c = new GridBagConstraints();
        JButton buy = new JButton("Repair");
        buy.addActionListener(e -> {
            int boughtF = 0;
            try {
                boughtF = Integer.parseInt(amount.getText());
            } catch (Exception f) {
                boughtF = 0;
            }
            if (boughtF != 0) {
                if (boughtF * price > Player.getCredits()) {
                    ConfirmationBoxUI notEnoughMoney = new ConfirmationBoxUI();
                    notEnoughMoney.confirmBox("Not enough money to purchase.", "Ok");
                } else if (boughtF + Player.getShip()
                        .getShipHealth() > Player.getShip().getShipHealthMax()) {
                    ConfirmationBoxUI notEnoughSpace = new ConfirmationBoxUI();
                    notEnoughSpace.confirmBox("That's more repairing than you need!", "Ok");
                } else {
                    Player.getShip().setShipHealth(Player.getShip().getShipHealth() + boughtF);
                    Player.subCredits(boughtF * price);
                }
                playerInfo.setListData(Player.toArray());
                shipList.setListData(Player.getShip().toArray());
                amount.setText("");
            }
        });
        c.gridy = 4;
        c.gridx = 0;
        c.gridwidth = 2;
        healthPanel.add(buy, c);

        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 2;
        frame.add(healthPanel, c);
    }

    public static JFrame getFrame() {
        return frame;
    }
}
