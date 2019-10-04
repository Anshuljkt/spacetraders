@SuppressWarnings("CanBeFinal")
public class Player {
    private String name;
    private int pilot;
    private int fighter;
    private int merchant;
    private int engineer;
    private int credits;
    private int skillPoints;
    private Region region;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Player(String name, int pilot, int fighter, int merchant, int engineer, int skillPoints) {
        if (name.isEmpty()) {
            name = "Trader Joe";
        }
        int allocations = pilot + fighter + merchant + engineer;
        if (allocations <= 0 || allocations > skillPoints) {
            pilot = fighter = merchant = engineer = skillPoints / 4;
        }
        this.name = name;
        this.pilot = pilot;
        this.fighter = fighter;
        this.merchant = merchant;
        this.engineer = engineer;
        this.skillPoints = skillPoints;

    }

    public String[] toArray() {
        String[] response = new String[7];
        response[0] = "Name: " + name;
        response[1] = "Pilot: " + pilot;
        response[2] = "Fighter: " + fighter;
        response[3] = "Merchant: " + merchant;
        response[4] = "Engineer: " + engineer;
        response[5] = "Credits: " + credits;

        return response;
    }
}
