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
    private int fuel;
    private Ship ship;


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

    public int getFuel() { return fuel; }

    public void setFuel(int fuel) { this.fuel = fuel; }

    public Ship getShip() { return ship; }

    public void setShip(Ship ship) { this.ship = ship; }

    public int getPilot() {
        return pilot;
    }

    public void setPilot(int pilot) {
        this.pilot = pilot;
    }

    public int getFighter() {
        return fighter;
    }

    public void setFighter(int fighter) {
        this.fighter = fighter;
    }

    public int getMerchant() {
        return merchant;
    }

    public void setMerchant(int merchant) {
        this.merchant = merchant;
    }

    public int getEngineer() {
        return engineer;
    }

    public void setEngineer(int engineer) {
        this.engineer = engineer;
    }

    public Player(String name, int pilot, int fighter, int merchant
            , int engineer, int skillPoints) {
        if (name.isEmpty()) {
            name = "Trader Joe";
        }
        int allocations = pilot + fighter + merchant + engineer;
        if (allocations <= 0 || allocations > skillPoints) {
            pilot = skillPoints / 4;
            fighter = skillPoints / 4;
            merchant = skillPoints / 4;
            engineer = skillPoints / 4;
        }

        ship = Ship.CIVIC;
        fuel = ship.getFuelCapacity();

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

    public void addFuel(int amount) {
        int temp = fuel + amount;
        int max = ship.getFuelCapacity();
        if (temp > max) {
            fuel = max;
        } else {
            fuel = temp;
        }
    }

    public void subFuel(int amount) {
        fuel -= amount;
    }

}
