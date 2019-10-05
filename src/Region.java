public class Region {

    private int x;
    private int y;
    private TechLevel techLevel;
    private String name;

    public Region(int x, int y, TechLevel techLevel, String name) {
        this.x = x;
        this.y = y;
        this.techLevel = techLevel;
        this.name = name;
    }

    public double findDistance(Player player) {
        return Math.sqrt(Math.pow(this.x - player.getRegion().getX(), 2) +
                Math.pow(this.y - player.getRegion().getY(), 2));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String[] toArray() {
        String[] response = new String[7];
        response[0] = "Name: " + name;
        response[1] = "Tech Level: " + techLevel;
        response[2] = "X Coordinate: " + x;
        response[3] = "Y Coordinate: " + y;
        return response;
    }
}
