public enum Ship {
    PRIUS(10, 100, 60),
    CIVIC(10, 50, 100),
    JETTA(12, 60, 100),
    CAYENNE(20, 80, 125),
    M3(17, 70, 150),
    GWAGON(25, 90, 150),
    MODELS(33,80,150),
    HURACAN(25, 100, 175),
    P1(30, 120, 200);

    private int cargoSpace;
    private int fuelCapacity;
    private int shipHealth;



    Ship(int cargoSpace, int fuelCapacity, int shipHealth) {
        this.cargoSpace = cargoSpace;
        this.fuelCapacity = fuelCapacity;
        this.shipHealth = shipHealth;
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


}
