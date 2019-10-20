import java.util.Random;

public class Region {

    private int x;
    private int y;
    private TechLevel techLevel;
    private String name;
    private Market market;
    private int priceAdjust;

    public Region(int x, int y, TechLevel techLevel, String name, int merchantSkill) {
        this.x = x;
        this.y = y;
        this.techLevel = techLevel;
        this.name = name;
        calcPriceAdjust(merchantSkill);
        market = new Market(techLevel, priceAdjust);
    }

    public int findDistance(Player player) {
        return (int) Math.sqrt(Math.pow(this.x - player.getRegion().getX(), 2)
                + Math.pow(this.y - player.getRegion().getY(), 2));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
        priceAdjust = techLevel.priceAdjust + random.nextInt(100) - (10 * merchantSkill);
    }
}
