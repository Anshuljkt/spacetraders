import javax.swing.*;
import java.awt.*;

public class NPCUI {
    private static Game game;
    private static String npcType;
    private static int regDisplayMark;
    private static int regDisplayPlayer;
    private static JFrame frame;

    public NPCUI(Game game, String npcType) {
        NPCUI.game = game;
        NPCUI.npcType = npcType;
    }

    static void startNPCEncounter() {
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
        frame = new JFrame("Bandit Encounter!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JList playerInfo = new JList(Player.toArray());
        playerPanel(playerInfo);

        JList shipList = new JList(Player.getShip().toArray());
        shipPanel(shipList);

        JPanel encounterPanel = new JPanel();
        encounterPanel.setLayout(new GridBagLayout());

    }

    //TODO
    static void showPolice() {
        frame = new JFrame("Police Encounter!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //TODO
    static void showTrader() {
        frame = new JFrame("Trader Encounter!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

}
