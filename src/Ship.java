import java.util.Random;

public enum Ship {
    PRIUS(10, 100, 60, 15),
    CIVIC(10, 50, 100, 15),
    JETTA(12, 60, 100, 25),
    CAYENNE(20, 80, 125, 20),
    M3(17, 70, 150, 20),
    GWAGON(25, 90, 150, 25),
    MODELS(33,80,150, 30),
    HURACAN(25, 100, 175, 45),
    P1(30, 120, 200, 50);

    private int cargoSpace;
    private int fuelCapacity;
    private int shipHealth;
    private int weaponDamage;



    Ship(int cargoSpace, int fuelCapacity, int shipHealth, int weaponDamage) {
        this.cargoSpace = cargoSpace;
        this.fuelCapacity = fuelCapacity;
        this.shipHealth = shipHealth;
        this.weaponDamage = weaponDamage;
    }

    public int getCargoSpace() {
        return cargoSpace;
    }

    public void setCargoSpace(int cargoSpace) {
        this.cargoSpace = cargoSpace;
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

    public static Ship getRandomShip() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

}
