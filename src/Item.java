public class Item {

    private String name;
    private double sellPrice;
    private double buyPrice;
    private int cargoSpace;
    private TechLevel techLevel;

    public Item(String name, double buyPrice, double sellPrice, int cargoSpace, TechLevel techLevel) {
        this.name = name;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.cargoSpace = cargoSpace;
        this.techLevel = techLevel;
    }

    public Item() {
        name = "Invalid";
        buyPrice = 1;
        sellPrice = 1;
        cargoSpace = 0;
        techLevel = TechLevel.getRandomTech();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getCargoSpace() {
        return cargoSpace;
    }

    public void setCargoSpace(int cargoSpace) {
        this.cargoSpace = cargoSpace;
    }

    public TechLevel getTechLevel() {
        return techLevel;
    }

    public void setTechLevel(TechLevel techLevel) {
        this.techLevel = techLevel;
    }
}
