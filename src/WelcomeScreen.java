import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class WelcomeScreen {

    private static JFrame frame = new JFrame("Space Trader by Runtime Terror");
    private static int skillPoints = 16;
    private static String difficulty = "Easy";
    private static Player createdPlayer = null;
    private Game game;

    /**
     * Main method to drive initial game setup
     * @param args special inputs
     */
    public static void main(String[] args) {
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
            System.out.println("Config Screen Shown");
        });
        frame.add(startButton, c);
        frame.setVisible(true);
    }

    //TODO: configPage
    private static void showConfigPage(JFrame frame) {
        frame.setVisible(false);
        frame.dispose();
        frame = new JFrame("Character Selection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel info = new JLabel();
        String infoText = "Please select your desired difficulty. \nYou also have some skill points to assign.";
        info.setHorizontalAlignment(JLabel.CENTER);
        info.setText("<html>" + infoText + "</html>");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.8;
        c.weighty = 0.2;
        c.ipadx = 10;
        c.ipady = 10;
        c.anchor = GridBagConstraints.PAGE_START;
        frame.add(info, c);

        JLabel skillPointsText = new JLabel();
        String skillPointsDesc = "Skill Points Available: ";
        skillPointsText.setHorizontalAlignment(JLabel.CENTER);
        skillPointsText.setText("<html>" + skillPointsDesc + skillPoints + "</html>");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 0.1;
        c.ipadx = 10;
        c.ipady = 10;
        c.anchor = GridBagConstraints.CENTER;
        frame.add(skillPointsText, c);


        JLabel diffText = new JLabel("Difficulty: ");
        diffText.setHorizontalAlignment(JLabel.RIGHT);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 0.5;
        c.weighty = 0.1;
        frame.add(diffText, c);

        String[] difficulties = new String[] {"Easy", "Medium", "Hard"};
        JComboBox diffBox = new JComboBox<>(difficulties);
        diffBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                difficulty = (String) diffBox.getItemAt(diffBox.getSelectedIndex());
                if (difficulty.equals("Easy")) {
                    skillPoints = 16;
                } else if (difficulty.equals("Medium")) {
                    skillPoints = 12;
                } else if (difficulty.equals("Hard")) {
                    skillPoints = 8;
                } else {
                    difficulty = "Easy";
                    skillPoints = 12;
                }
                skillPointsText.setText("<html>" + skillPointsDesc + skillPoints + "</html>");
            }
        });
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 2;
        c.weightx = 0.5;
        c.weighty = 0.1;
        frame.add(diffBox, c);

        JLabel pilotText = new JLabel("Pilot: ");
        pilotText.setHorizontalAlignment(JLabel.RIGHT);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.weighty = 0.1;
        frame.add(pilotText, c);

        JTextField pilotBox = new JTextField();
        pilotBox.setMinimumSize(new Dimension(100,30));
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridx = 1;
        c.gridy = 3;
        c.weighty = 0.1;
        frame.add(pilotBox, c);


        JLabel fighterText = new JLabel("Fighter: ");
        fighterText.setHorizontalAlignment(JLabel.RIGHT);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.weighty = 0.1;
        frame.add(fighterText, c);

        JTextField fighterBox = new JTextField();
        fighterBox.setMinimumSize(new Dimension(100,30));
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridx = 1;
        c.gridy = 4;
        c.weighty = 0.1;
        frame.add(fighterBox, c);


        JLabel merchantText = new JLabel("Merchant: ");
        merchantText.setHorizontalAlignment(JLabel.RIGHT);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 5;
        c.weighty = 0.1;
        frame.add(merchantText, c);

        JTextField merchantBox = new JTextField();
        merchantBox.setMinimumSize(new Dimension(100,30));
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridx = 1;
        c.gridy = 5;
        c.weighty = 0.1;
        frame.add(merchantBox, c);


        JLabel engineerText = new JLabel("Engineer: ");
        engineerText.setHorizontalAlignment(JLabel.RIGHT);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 6;
        c.weighty = 0.1;
        frame.add(engineerText, c);

        JTextField engineerBox = new JTextField();
        engineerBox.setMinimumSize(new Dimension(100,30));
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridx = 1;
        c.gridy = 6;
        c.weighty = 0.1;
        frame.add(engineerBox, c);

        JLabel nameText = new JLabel("Player Name: ");
        nameText.setHorizontalAlignment(JLabel.RIGHT);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 8;
        c.weighty = 0.2;
        frame.add(nameText, c);

        JTextField nameBox = new JTextField();
        nameBox.setMinimumSize(new Dimension(100,30));
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridx = 1;
        c.gridy = 8;
        c.weighty = 0.2;
        frame.add(nameBox, c);

        JButton startButton = new JButton("Start!");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.SOUTH;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridx = 0;
        c.gridy = 9;
        c.weighty = 0.4;
        c.anchor = GridBagConstraints.PAGE_END;
        JFrame finalFrame = frame;
        startButton.addActionListener(e -> {
            int pilot = 0;
            int fighter = 0;
            int merchant = 0;
            int engineer = 0;
            String name = "";
            try {
                pilot = Integer.parseInt(pilotBox.getText());
                fighter = Integer.parseInt(fighterBox.getText());
                merchant = Integer.parseInt(merchantBox.getText());
                engineer = Integer.parseInt(engineerBox.getText());
                name = nameBox.getText();
            }
            catch (Exception f) {
                //%TODO: Sanitize Inputs
            }


            createdPlayer = new Player(name, difficulty, pilot, fighter, merchant, engineer, skillPoints);
            if (difficulty.equals("Easy")) {
                createdPlayer.setCredits(1500);
            } else if (difficulty.equals("Medium")) {
                createdPlayer.setCredits(1000);
            } else {
                createdPlayer.setCredits(500);
            }
            System.out.println("pilot = " + createdPlayer.getPilot());
            System.out.println("fighter = " + createdPlayer.getFighter());
            System.out.println("merchant = " + createdPlayer.getMerchant());
            System.out.println("engineer = " + createdPlayer.getEngineer());
            System.out.println("name = " + createdPlayer.getName());
            System.out.println("difficulty = " + difficulty);
            newGame(finalFrame);
            System.out.println("New Game Started");
        });
        frame.add(startButton, c);
        frame.setVisible(true);
    }

    private static void newGame(JFrame frame) {

        frame.setVisible(false);
        frame.dispose();
        frame = new JFrame("New Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JList playerInfo = new JList(createdPlayer.toArray());
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.CENTER;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.ipadx = 30;
        c.ipady = 30;
        frame.add(playerInfo, c);

        frame.setVisible(true);
    }
}
