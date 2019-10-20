public class ShipUpgrade extends Item {

    private ShipUpgradeType shipUpgradeType;

    public ShipUpgrade(TechLevel techLevel, double priceAdjust) {
        super();
        shipUpgradeType = ShipUpgradeType.getRandomUpgrade(techLevel);
        this.setBase(shipUpgradeType.getPrice());
        this.setTechLevel(shipUpgradeType.getTechLevel());
        this.setName(shipUpgradeType.getName());
        this.setBuyPrice(this.getBase() * (techLevel.getPriceAdjust() + priceAdjust));
        this.setSellPrice(this.getBase() * (techLevel.getPriceAdjust() - priceAdjust));
        this.setCargoSpace(shipUpgradeType.getCargoSpaceUsed());
    }

    public ShipUpgradeType getShipUpgradeType() {
        return shipUpgradeType;
    }

    public void setShipUpgradeType(ShipUpgradeType shipUpgradeType) {
        this.shipUpgradeType = shipUpgradeType;
    }
}
