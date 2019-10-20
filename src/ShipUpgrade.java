public class ShipUpgrade extends Item {

    ShipUpgradeType shipUpgradeType;

    public ShipUpgrade(TechLevel techLevel, int priceAdjust) {
        super();
        shipUpgradeType = ShipUpgradeType.getRandomUpgrade(techLevel);
        this.setTechLevel(techLevel);
        this.setName(shipUpgradeType.getName());
        this.setPrice(shipUpgradeType.getPrice() + priceAdjust);
        this.setCargoSpace(shipUpgradeType.getCargoSpaceUsed());
    }
}
