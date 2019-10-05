import java.util.Random;

public class Universe {

    private Region[] regions;
    private Random random = new Random();
    private int[] xCoords = new int[10];
    private int[] yCoords = new int[10];

    public Universe(String[] regionNames) {
        int newX;
        boolean validX;
        int newY;
        boolean validY;
        regions = new Region[regionNames.length];
        for (int i = 0; i < regionNames.length; i++) {
            newX = 0;
            newY = 0;
            validX = false;
            validY = false;
            while (!validX) {
                validX = true;
                newX = random.nextInt(401) - 200;
                System.out.println("Newx: " + newX);
                for (int j = 0; j < i; j++) {
                    if (Math.abs(newX - xCoords[j]) < 5) {
                        validX = false;
                    }
                }
            }
            xCoords[i] = newX;

            while (!validY) {
                validY = true;
                newY = random.nextInt(401) - 200;
                for (int j = 0; j < i; j++) {
                    if (Math.abs(newY - yCoords[j]) < 5) {
                        validY = false;
                    }
                }
            }
            yCoords[i] = newY;

            System.out.println(newX + " " + newY);

            regions[i] = new Region(xCoords[i], yCoords[i]
                    , TechLevel.getRandomTech(), regionNames[i]);
        }
    }

    public Region getRandomRegion() {
        int regionNum = random.nextInt(regions.length);
        return regions[regionNum];
    }

    public Region[] getRegions() {
        return regions;
    }

    //create all regions
}
