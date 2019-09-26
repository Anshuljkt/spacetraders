@SuppressWarnings("CanBeFinal")
public class Player {
    private String name;
    public String difficulty;
    private int pilot;
    private int fighter;
    private int merchant;
    private int engineer;
    private int credits;
    private int skillPoints;
    private Region region;
    private double money;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public int getPilot() {
        return pilot;
    }

    public int getFighter() {
        return fighter;
    }

    public int getMerchant() {
        return merchant;
    }

    public int getEngineer() {
        return engineer;
    }

    public Player(String name, String difficulty, int pilot, int fighter, int merchant, int engineer, int skillPoints) {
        if (name.isEmpty()) {
            name = "Trader Joe";
        }
        if (pilot + fighter + merchant + engineer > skillPoints) {
            pilot = fighter = merchant = engineer = skillPoints / 4;
        }
        this.name = name;
        this.difficulty = difficulty;
        this.pilot = pilot;
        this.fighter = fighter;
        this.merchant = merchant;
        this.engineer = engineer;
        this.skillPoints = skillPoints;

        if (difficulty.equals("Easy")) {
            this.credits = 1000;
            this.money = 300.00;
        } else if (difficulty.equals("Medium")) {
            this.credits = 750;
            this.money = 200.00;
        } else if (difficulty.equals("Hard")) {
            this.credits = 500;
            this.money = 100.00;
        } else {
            this.difficulty = "Easy";
            this.credits = 1000;
        }
    }

    public String[] toArray() {
        String[] response = new String[7];
        response[0] = "Name: " + name;
        response[1] = "Difficulty: " + difficulty;
        response[2] = "Pilot: " + pilot;
        response[3] = "Fighter: " + fighter;
        response[4] = "Merchant: " + merchant;
        response[5] = "Engineer: " + engineer;
        response[6] = "Credits: " + credits;

        return response;
    }
}
