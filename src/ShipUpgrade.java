public enum ShipUpgrade {
    DEATOMIZER(0,0,0,70, TechLevel.FUTURISTIC);

    private int cargoSpace;
    private int fuelCapacity;
    private int shipHealth;
    private int weaponDamage;

    ShipUpgrade(int cargoSpace, int fuelCapacity, int shipHealth, int weaponDamage, TechLevel techLevel) {
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

}
