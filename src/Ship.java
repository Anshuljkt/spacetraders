import java.util.Random;

public enum Ship {
    PRIUS(10, 100, 60, 15),
    CIVIC(10, 50, 100, 15),
    JETTA(12, 60, 100, 25),
    CAYENNE(20, 80, 125, 20),
    M3(17, 70, 150, 20),
    GWAGON(25, 90, 150, 25),
    MODELS(33, 80, 150, 30),
    HURACAN(25, 100, 175, 45),
    P1(30, 120, 200, 50);

    private int cargoSpace;
    private int fuelCapacity;
    private int shipHealthMax;
    private int weaponDamage;
    private int shipHealth;

    Ship(int cargoSpace, int fuelCapacity, int shipHealthMax, int weaponDamage) {
        this.cargoSpace = cargoSpace;
        this.fuelCapacity = fuelCapacity;
        this.shipHealthMax = shipHealthMax;
        this.shipHealth = shipHealthMax;
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

    public int getShipHealthMax() {
        return shipHealthMax;
    }

    public void setShipHealth(int shipHealth) {
        this.shipHealth = shipHealth;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public static Ship getRandomShip() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

    public String[] toArray() {
        String[] response = new String[5];
        response[0] = "Name: " + name();
        response[1] = "Health: " + getShipHealth() + "/" + getShipHealthMax();
        response[2] = "Fuel Tank: " + Player.getFuel() + "/" + getFuelCapacity();
        response[3] = "Cargo Space: " +  (getCargoSpace() - Player.getCargoLeft())
                + "/" + getCargoSpace();
        response[4] = "Weapon Damage: " + getWeaponDamage();
        return response;
    }

}
