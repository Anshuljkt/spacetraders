import javax.swing.*;
import java.awt.*;

public class MarketUI {

    private static Game game;
    private static Market market;

    public MarketUI(Game game, Market market) {
        this.game = game;
        this.market = market;
    }

    static void openMarket() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();



        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
