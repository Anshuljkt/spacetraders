import java.util.Random;

public enum ShipUpgradeType {
    DEATOMIZER(5, 0, 0, 70, TechLevel.FUTURISTIC, "De-Atomizer", 5000),
    LASERCANNON(1, 0, 0, 20, TechLevel.AGRICULTURE, "Laser Cannon", 100),
    BASICSHIELD(2, 0, 30, 0, TechLevel.PREAGRICULTURAL, "Basic Shield", 100),
    ADVSHIELD(2, 0, 50, 0, TechLevel.MEDIEVAL, "Advanced Shield", 100),
    TRACKINGMISSILE(3, 0, 0, 40, TechLevel.RENAISSANCE, "Tracking Missile", 400),
    DUELLASER(2, 0, 0, 40, TechLevel.INDUSTRIAL, "Duel Laser", 300),
    PHOTONCANNON(6, 0, 0, 65, TechLevel.MODERN, "Photon Cannon", 1000);

    private int cargoSpaceUsed;
    private int fuelCapacity;
    private int shipHealth;
    private int weaponDamage;
    private TechLevel techLevel;
    private String name;
    private int price;

    ShipUpgradeType(int cargoSpaceUsed, int fuelCapacity, int shipHealth, int weaponDamage, TechLevel techLevel, String name, int price) {
        this.cargoSpaceUsed = cargoSpaceUsed;
        this.fuelCapacity = fuelCapacity;
        this.shipHealth = shipHealth;
        this.weaponDamage = weaponDamage;
        this.techLevel = techLevel;
        this.name = name;
        this.price = price;
    }

    public int getCargoSpaceUsed() {
        return cargoSpaceUsed;
    }

    public void setCargoSpaceUsed(int cargoSpace) {
        this.cargoSpaceUsed = cargoSpace;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getShipHealth() {
        return shipHealth;
    }

    public void setShipHealth(int shipHealth) {
        this.shipHealth = shipHealth;
    }

    public int getWeaponDamage() { return weaponDamage; }

    public void setWeaponDamage(int weaponDamage) { this.weaponDamage = weaponDamage; }

    public TechLevel getTechLevel() { return techLevel; }

    public static ShipUpgradeType getRandomUpgrade(TechLevel techLevel) {
        Random random = new Random();
        ShipUpgradeType temp = values()[random.nextInt(values().length)];
        while (temp.getTechLevel().compareTo(techLevel) > 0) {
            temp = values()[random.nextInt(values().length)];
        }
        return temp;
    }


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
