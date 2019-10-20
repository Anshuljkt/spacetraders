import javax.swing.*;
import java.awt.*;

public class MarketUI {

    private static Game game;
    private static Market market;
    private static int regDisplayMark = 0;
    private static int regDisplayPlayer = 0;

    public MarketUI(Game game, Market market) {
        this.game = game;
        this.market = market;
    }

    static void openMarket() {
        JFrame frame = new JFrame("" + game.getPlayer().getRegion().getName() + " Market");
        frame.setSize(500, 300);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //Market Panel

        JPanel marketPanel = new JPanel();
        marketPanel.setLayout(new GridBagLayout());

        JLabel mark = new JLabel("Market Goods:");
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;

        marketPanel.add(mark, c);

        JList regFocus = new JList(market.toArray(regDisplayMark));
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

        c = new GridBagConstraints();
        c.gridy = 0;
        c.gridx = 2;
        c.weightx = 1;
        c.anchor = GridBagConstraints.EAST;

        frame.add(marketPanel, c);

        //Player Panel

        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new GridBagLayout());


        JLabel pl = new JLabel("Inventory:");
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;

        playerPanel.add(pl, c);

        JList regFocusPlayer = new JList(game.getPlayer().invToArray(regDisplayPlayer));
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

        //**** Buy Button ****
        JButton buyButton = new JButton("Buy");
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 2;
        buyButton.addActionListener(e -> {
            if(market.getGoodPrice(regDisplayMark) <= game.getPlayer().getCredits()) {
                if(market.getGoodCargo(regDisplayMark) <= game.getPlayer().getCargoLeft()) {
                    game.getPlayer().subCargoLeft(market.getGoodCargo(regDisplayMark));
                    game.getPlayer().subCredits(market.getGoodPrice(regDisplayMark));
                    game.getPlayer().addInv(market.removeGood(regDisplayMark));
                    if (regDisplayMark == 0) {
                        regDisplayMark = market.getGoodsLength() - 1;
                    } else {
                        regDisplayMark--;
                    }
                    regFocus.setListData(market.toArray(regDisplayMark));
                    regFocusPlayer.setListData(game.getPlayer().invToArray(regDisplayPlayer));
                } else {
                    ConfirmationBoxUI notEnoughSpace = new ConfirmationBoxUI();
                    notEnoughSpace.ConfirmBox("Not enough space to purchase", "Ok");
                }
            } else {
                ConfirmationBoxUI notEnoughMoney = new ConfirmationBoxUI();
                notEnoughMoney.ConfirmBox("Not enough money to purchase", "Ok");
            }
        });

        marketPanel.add(buyButton, c);

        //***** Sell Button ****
        JButton sellButton = new JButton("Sell");
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 2;
        sellButton.addActionListener(e -> {
            if (game.getPlayer().getInvSize() > 0) {
                game.getPlayer().addCargoLeft(game.getPlayer().getItem(regDisplayPlayer).getCargoSpace());
                game.getPlayer().addCredits(game.getPlayer().getItem(regDisplayPlayer).getPrice());
                market.addGood(game.getPlayer().subInv(regDisplayPlayer));
                if (regDisplayPlayer == game.getPlayer().getInvSize() - 1) {
                    regDisplayPlayer = 0;
                } else {
                    regDisplayPlayer++;
                }
                regFocus.setListData(market.toArray(regDisplayMark));
                regFocusPlayer.setListData(game.getPlayer().invToArray(regDisplayPlayer));
            }
        });

        playerPanel.add(sellButton, c);

        c = new GridBagConstraints();
        c.gridy = 0;
        c.gridx = 2;
        c.weightx = 1;
        c.anchor = GridBagConstraints.WEST;

        frame.add(playerPanel, c);


        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
