import java.util.Random;

public class Region {

    private int x;
    private int y;
    private TechLevel techLevel;
    private String name;
    private Market market;
    private double priceAdjust;

    public Region(int x, int y, TechLevel techLevel
            , String name, int merchantSkill, boolean isGameWinning) {
        this.x = x;
        this.y = y;
        this.techLevel = techLevel;
        this.name = name;
        calcPriceAdjust(merchantSkill);
        market = new Market(techLevel, priceAdjust, isGameWinning);
    }

    public int findDistance() {
        return (int) Math.sqrt(Math.pow(this.x - Player.getRegion().getX(), 2)
                + Math.pow(this.y - Player.getRegion().getY(), 2));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TechLevel getTechLevel() {
        return this.techLevel;
    }

    public String getName() {
        return name;
    }

    public String[] toArray() {
        String[] response = new String[7];
        response[0] = "Name: " + name;
        response[1] = "Tech Level: " + techLevel;
        response[2] = "X Coordinate: " + x;
        response[3] = "Y Coordinate: " + y;
        return response;
    }

    public Market getMarket() {
        return market;
    }

    private void calcPriceAdjust(int merchantSkill) {
        Random random = new Random();
        priceAdjust = Math.random() / 4 / merchantSkill;
    }

    public double getPriceAdjust() {
        return priceAdjust;
    }
}
