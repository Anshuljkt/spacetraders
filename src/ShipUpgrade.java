public class ShipUpgrade extends Item {

    ShipUpgradeType shipUpgradeType;

    public ShipUpgrade(TechLevel techLevel, double priceAdjust) {
        super();
        shipUpgradeType = ShipUpgradeType.getRandomUpgrade(techLevel);
        this.setTechLevel(shipUpgradeType.getTechLevel());
        this.setName(shipUpgradeType.getName());
        this.setBuyPrice(shipUpgradeType.getPrice() * (techLevel.priceAdjust + priceAdjust));
        this.setSellPrice(shipUpgradeType.getPrice() * (techLevel.priceAdjust - priceAdjust));
        this.setCargoSpace(shipUpgradeType.getCargoSpaceUsed());
    }
}
