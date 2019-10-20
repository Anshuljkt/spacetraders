import java.util.ArrayList;

@SuppressWarnings("CanBeFinal")
public class Player {
    private static String name;
    private static int pilot;
    private static int fighter;
    private static int merchant;
    private static int engineer;
    private static int credits;
    private static int skillPoints;
    private static Region region;
    private static int fuel;
    private static Ship ship;
    private static ArrayList<Item> inventory;
    private static int cargoLeft;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        Player.name = name;
    }

    public static int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        Player.credits = credits;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(int skillPoints) {
        Player.skillPoints = skillPoints;
    }

    public static Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        Player.region = region;
    }

    public static int getFuel() {
        return fuel; }

    public void setFuel(int fuel) {
        Player.fuel = fuel; }

    public static Ship getShip() {
        return ship; }

    public void setShip(Ship ship) {
        Player.ship = ship; }

    public int getPilot() {
        return pilot;
    }

    public void setPilot(int pilot) {
        Player.pilot = pilot;
    }

    public int getFighter() {
        return fighter;
    }

    public void setFighter(int fighter) {
        Player.fighter = fighter;
    }

    public static int getMerchant() {
        return merchant;
    }

    public void setMerchant(int merchant) {
        Player.merchant = merchant;
    }

    public int getEngineer() {
        return engineer;
    }

    public void setEngineer(int engineer) {
        Player.engineer = engineer;
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
        cargoLeft = ship.getCargoSpace();

        inventory = new ArrayList<Item>();

        Player.name = name;
        Player.pilot = pilot;
        Player.fighter = fighter;
        Player.merchant = merchant;
        Player.engineer = engineer;
        Player.skillPoints = skillPoints;

    }

    public static String[] toArray() {
        String[] response = new String[6];
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

    public String[] invToArray(int invNum) {
        String[] response = new String[7];
        if ((inventory.size() - 1 < invNum) || invNum < 0) {
            response[0] = "Empty";
        } else {
            response[0] = inventory.get(invNum).getName();
            response[1] = (int) inventory.get(invNum).getSellPrice() + " credits";
            response[2] = inventory.get(invNum).getCargoSpace() + " space used";
        }
        return response;
    }

    public static int getInvSize() {
        return inventory.size();
    }

    public static int getCargoLeft() {
        return cargoLeft;
    }

    public void resetCargoLeft() {
        cargoLeft = ship.getCargoSpace();
    }

    public void subCargoLeft(int val) {
        cargoLeft -= val;
    }

    public void addCargoLeft(int val) {
        cargoLeft += val;
    }

    public void addInv(Item item) {
        inventory.add(item);
    }

    public Item subInv(int num) {
        return inventory.remove(num);
    }

    public void subCredits(int amount) {
        credits -= amount;
    }

    public void addCredits(int amount) {
        credits += amount;
    }

    public Item getItem(int num) {
        return inventory.get(num);
    }

    public static void adjustInvPricing() {
        for (Item i: inventory) {
            i.setBuyPrice(i.getBase() * (region.getTechLevel()
                    .getPriceAdjust() + region.getPriceAdjust()));
            i.setSellPrice(i.getBase() * (region.getTechLevel()
                    .getPriceAdjust() - region.getPriceAdjust()));
        }
    }


}
