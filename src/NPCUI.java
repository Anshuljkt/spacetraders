import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class NPCUI {
    private static Game game;
    private static String npcType;
    private static int regDisplayMark;
    private static int regDisplayPlayer;
    private static JFrame frame;
    private static int demandAmount;
    private static Item item;
    private static int itemInd;
    private static Region curr;
    private static Region next;


    public NPCUI(Game game, String npcType) {
        NPCUI.game = game;
        NPCUI.npcType = npcType;
    }

    static void startNPCEncounter(Region curr, Region next) {
        NPCUI.curr = curr;
        NPCUI.next = next;
        if(npcType.equals("Bandit")) {
            showBandit();
        } else if (npcType.equals("Police")) {
            showPolice();
        } else if (npcType.equals(("Trader"))) {
            showTrader();
        }
    }

    //TODO
    static void showBandit() {
        Random gen = new Random();
        demandAmount = gen.nextInt(200) + 50;
        frame = new JFrame("Bandit Encounter!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new GridBagLayout());
        frame.setLocationRelativeTo(null);
        GridBagConstraints c = new GridBagConstraints();

        JList playerInfo = new JList(Player.toArray());
        playerPanel(playerInfo);

        JList shipList = new JList(Player.getShip().toArray());
        shipPanel(shipList);

        JPanel encounterPanel = new JPanel();
        encounterPanel.setLayout(new GridBagLayout());

        demandBPanel();

        payBButton();

        fleeBButton();

        fightBButton();

        frame.setVisible(true);
    }

    private static void demandBPanel() {
        JLabel encounterText = new JLabel("As you reach the jump point"
                + " for the next region, you are hailed by a rogue bandit.");
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 1;
        c.gridx = 0;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 1;
        frame.add(encounterText, c);
        JLabel demandsText = new JLabel(String.format("The Bandit says: Give me %d credits!", demandAmount));
        c = new GridBagConstraints();
        c.gridy = 2;
        c.gridx = 1;
        c.weightx = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.CENTER;
        frame.add(demandsText, c);
        JLabel question = new JLabel("What would you like to do?");
        c = new GridBagConstraints();
        c.gridy = 3;
        c.gridx = 1;
        c.gridheight = 2;
        frame.add(question, c);
    }

    private static void payBButton() {
        Random payGen = new Random();
        JButton pay = new JButton("Pay");
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 5;
        c.gridheight = 1;
        pay.addActionListener(e -> {
            if (demandAmount > Player.getCredits() && Player.getInvSize() == 0) {
                Player.getShip().setShipHealth(Player.getShip().getShipHealth()
                        - payGen.nextInt(Player.getShip().getShipHealthMax() / 2) + 1);
                frame.setVisible(false);
                frame.dispose();
                ConfirmationBoxUI.actionBox("The bandit attacked you and fled!", "Ok", ActionListener -> {
                    new GameUI(NPCUI.game);
                    GameUI.playGame();
                    Player.setRegion(next);
                });
            } else if (demandAmount > Player.getCredits()) {
                Player.resetInventory();
                frame.setVisible(false);
                frame.dispose();
                ConfirmationBoxUI.actionBox("The bandit stole your whole inventory!", "Ok", ActionListener -> {
                    new GameUI(NPCUI.game);
                    GameUI.playGame();
                    Player.setRegion(next);
                });
            } else {
                Player.subCredits(demandAmount);
                frame.setVisible(false);
                frame.dispose();
                ConfirmationBoxUI.actionBox("You paid the bandit and he flew away.", "Ok", ActionListener -> {
                    new GameUI(NPCUI.game);
                    GameUI.playGame();
                    Player.setRegion(next);
                });
            }
        });
        frame.add(pay, c);
    }

    private static void fleeBButton() {
        Random fleeGen = new Random();
        JButton flee = new JButton("Flee");
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 5;
        c.gridheight = 1;
        flee.addActionListener(e -> {
            if (fleeGen.nextDouble() < .1 + .1 * Player.getPilot()) {
                frame.setVisible(false);
                frame.dispose();
                ConfirmationBoxUI.actionBox("You escaped the bandit!", "Ok", ActionListener -> {
                    new GameUI(NPCUI.game);
                    GameUI.playGame();
                    Player.setRegion(curr);
                });
            } else {
                Player.setCredits(0);
                Player.getShip().setShipHealth(Player.getShip().getShipHealth()
                        - fleeGen.nextInt(Player.getShip().getShipHealthMax() / 2) + 1);
                frame.setVisible(false);
                frame.dispose();
                ConfirmationBoxUI.actionBox("You couldn't escape. You suffered damage and lost all your credits.", "Ok", ActionListener -> {
                    new GameUI(NPCUI.game);
                    GameUI.playGame();
                    Player.setRegion(curr);
                });
            }
        });
        frame.add(flee, c);
    }

    private static void fightBButton() {
        Random fightGen = new Random();
        JButton fight = new JButton("Fight");
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 5;
        c.gridheight = 1;
        fight.addActionListener(e -> {
            if (fightGen.nextDouble() < .1 + .1 * Player.getFighter()) {
                Player.addCredits(fightGen.nextInt(150) + 50);
                frame.setVisible(false);
                frame.dispose();
                ConfirmationBoxUI.actionBox("You defeated the bandit and looted some credits!", "Ok", ActionListener -> {
                    new GameUI(NPCUI.game);
                    GameUI.playGame();
                   Player.setRegion(next);
                });
            } else {
                Player.setCredits(0);
                Player.getShip().setShipHealth(Player.getShip().getShipHealth()
                        - fightGen.nextInt(Player.getShip().getShipHealthMax() / 2) + 1);
                frame.setVisible(false);
                frame.dispose();
                ConfirmationBoxUI.actionBox("You couldn't defeat the bandit. You lost your credits and took damage.", "Ok", ActionListener -> {
                    new GameUI(NPCUI.game);
                    GameUI.playGame();
                    Player.setRegion(next);
                });
            }
        });
        frame.add(fight, c);
    }

    //TODO
    static void showPolice() {
        frame = new JFrame("Police Encounter!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Random gen = new Random();
        itemInd = gen.nextInt((Player.getInvSize()));
        item = Player.getItem(itemInd);
        frame.setSize(800, 600);
        frame.setLayout(new GridBagLayout());
        frame.setLocationRelativeTo(null);
        GridBagConstraints c = new GridBagConstraints();

        JList playerInfo = new JList(Player.toArray());
        playerPanel(playerInfo);

        JList shipList = new JList(Player.getShip().toArray());
        shipPanel(shipList);

        JPanel encounterPanel = new JPanel();
        encounterPanel.setLayout(new GridBagLayout());

        demandPPanel();

        forfeitPButton();

        fleePButton();

        fightPButton();

        frame.setVisible(true);

    }

    private static void demandPPanel() {
        JLabel encounterText = new JLabel("As you reach the jump point"
                + " for the next region, you are approached by a Space Police Officer.");
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 1;
        c.gridx = 0;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 1;
        frame.add(encounterText, c);
        JLabel demandsText = new JLabel(String.format("The Officer says: You are carrying a stolen item. Hand over the %s.", item.getName()));
        c = new GridBagConstraints();
        c.gridy = 2;
        c.gridx = 1;
        c.weightx = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.CENTER;
        frame.add(demandsText, c);
        JLabel question = new JLabel("What would you like to do?");
        c = new GridBagConstraints();
        c.gridy = 3;
        c.gridx = 1;
        c.gridheight = 2;
        frame.add(question, c);
    }

    private static void forfeitPButton() {
        Random forGen = new Random();
        JButton forfeit = new JButton("Forfeit");
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 5;
        c.gridheight = 1;
        forfeit.addActionListener(e -> {
            Player.addCargoLeft(item.getCargoSpace());
            Player.subInv(itemInd);
            frame.setVisible(false);
            frame.dispose();
            Player.setRegion(next);
            ConfirmationBoxUI.actionBox("You gave up the item and moved on.", "Ok", ActionListener -> {
                new GameUI(NPCUI.game);
                GameUI.playGame();
            });
        });
        frame.add(forfeit, c);
    }

    private static void fleePButton() {
        Random fleeGen = new Random();
        JButton flee = new JButton("Flee");
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 5;
        c.gridheight = 1;
        flee.addActionListener(e -> {
            if (fleeGen.nextDouble() < .1 + .1 * Player.getPilot()) {
                frame.setVisible(false);
                frame.dispose();
                Player.setRegion(curr);
                ConfirmationBoxUI.actionBox("You escaped the officer!", "Ok", ActionListener -> {
                    new GameUI(NPCUI.game);
                    GameUI.playGame();
                });
            } else {
                Player.addCargoLeft(item.getCargoSpace());
                Player.subInv(itemInd);
                Player.setCredits(Player.getCredits() / 2);
                Player.getShip().setShipHealth(Player.getShip().getShipHealth()
                        - fleeGen.nextInt(Player.getShip().getShipHealthMax() / 2) + 1);
                frame.setVisible(false);
                frame.dispose();
                Player.setRegion(curr);
                ConfirmationBoxUI.actionBox(String.format("You couldn't escape. The officer has confiscated the %s and punished you greatly for resisting.", item.getName()), "Ok", ActionListener -> {
                    new GameUI(NPCUI.game);
                    GameUI.playGame();
                });
            }
        });
        frame.add(flee, c);
    }

    private static void fightPButton() {
        Random fightGen = new Random();
        JButton fight = new JButton("Fight");
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 5;
        c.gridheight = 1;
        fight.addActionListener(e -> {
            if (fightGen.nextDouble() < .1 + .1 * Player.getFighter()) {
                frame.setVisible(false);
                frame.dispose();
                ConfirmationBoxUI.actionBox("You defeated the officer!", "Ok", ActionListener -> {
                    new GameUI(NPCUI.game);
                    GameUI.playGame();
                    Player.setRegion(next);
                });
            } else {
                Player.addCargoLeft(item.getCargoSpace());
                Player.subInv(itemInd);
                Player.setCredits(0);
                Player.getShip().setShipHealth(Player.getShip().getShipHealth()
                        - fightGen.nextInt(Player.getShip().getShipHealthMax() / 2) + 1);
                frame.setVisible(false);
                frame.dispose();
                ConfirmationBoxUI.actionBox("You couldn't defeat the officer. You lost your credits and item and took damage.", "Ok", ActionListener -> {
                    new GameUI(NPCUI.game);
                    GameUI.playGame();
                    Player.setRegion(next);
                });
            }
        });
        frame.add(fight, c);
    }

    //TODO
    static void showTrader() {
        frame = new JFrame("Trader Encounter!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Random gen = new Random();
        item = new ShipUpgrade(TechLevel.getRandomTech(), gen.nextDouble() / 4 / Player.getMerchant());
        frame.setSize(800, 600);
        frame.setLayout(new GridBagLayout());
        frame.setLocationRelativeTo(null);
        GridBagConstraints c = new GridBagConstraints();

        JList playerInfo = new JList(Player.toArray());
        playerPanel(playerInfo);

        JList shipList = new JList(Player.getShip().toArray());
        shipPanel(shipList);

        JPanel encounterPanel = new JPanel();
        encounterPanel.setLayout(new GridBagLayout());

        traderPanel();

        ignoreButton();

        buyButton();

        //robButton();

        //negotiateButton();

        frame.setVisible(true);
    }

    private static void traderPanel() {
        JLabel encounterText = new JLabel("As you reach the jump point"
                + " for the next region, you are approached by a Trader.");
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 1;
        c.gridx = 0;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 1;
        frame.add(encounterText, c);
        JLabel demandsText = new JLabel(String.format("The Trader says: Would you like to buy a %s for %.0f credits?", item.getName(), item.getBuyPrice()));
        c = new GridBagConstraints();
        c.gridy = 2;
        c.gridx = 1;
        c.weightx = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.CENTER;
        frame.add(demandsText, c);
        JLabel question = new JLabel("What would you like to do?");
        c = new GridBagConstraints();
        c.gridy = 3;
        c.gridx = 1;
        c.gridheight = 2;
        frame.add(question, c);
    }

    private static void ignoreButton() {
        Random forGen = new Random();
        JButton forfeit = new JButton("Ignore");
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 5;
        c.gridheight = 1;
        forfeit.addActionListener(e -> {
            frame.setVisible(false);
            frame.dispose();
            Player.setRegion(next);
            ConfirmationBoxUI.actionBox("You move on.", "Ok", ActionListener -> {
                new GameUI(NPCUI.game);
                GameUI.playGame();
            });
        });
        frame.add(forfeit, c);
    }

    private static void buyButton() {
        Random forGen = new Random();
        JButton forfeit = new JButton("Buy");
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 5;
        c.gridheight = 1;
        forfeit.addActionListener(e -> {
            if (Player.getCredits() >= (int)item.getBuyPrice()) {
                Player.subCredits((int)item.getBuyPrice());
                Player.addInv(item);
                Player.addCargoLeft(item.getCargoSpace());
                frame.setVisible(false);
                frame.dispose();
                Player.setRegion(next);
                ConfirmationBoxUI.actionBox(String.format("You bought the %s.", item.getName()), "Ok", ActionListener -> {
                    new GameUI(NPCUI.game);
                    GameUI.playGame();
                });
            } else {
                ConfirmationBoxUI.confirmBox("You can't afford the item.", "Ok");
            }

        });
        frame.add(forfeit, c);
    }

    private static void playerPanel(JList playerInfo) {
        JPanel playerPanel = new JPanel();
        GridBagConstraints c = new GridBagConstraints();
        //c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = .5;
        playerPanel.add(playerInfo);
        frame.add(playerInfo, c);
    }

    private static void shipPanel(JList shipList) {
        JPanel shipPanel = new JPanel();
        GridBagConstraints c = new GridBagConstraints();
        //c.anchor = GridBagConstraints.NORTH;
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = .5;
        shipPanel.add(shipList);
        frame.add(shipPanel, c);
    }

}
