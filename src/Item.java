public class Item {

    private String name;
    private int price;
    private int cargoSpace;
    private TechLevel techLevel;

    public Item(String name, int price, int cargoSpace, TechLevel techLevel) {
        this.name = name;
        this.price = price;
        this.cargoSpace = cargoSpace;
        this.techLevel = techLevel;
    }

    public Item() {
        name = "Invalid";
        price = 1;
        cargoSpace = 0;
        techLevel = TechLevel.getRandomTech();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
