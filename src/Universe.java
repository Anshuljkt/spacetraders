import java.util.Random;

public class Universe {

    private Region[] regions;
    private Random random = new Random();

    public Universe(String[] regionNames) {
        regions = new Region[regionNames.length];
        for (int i = 0; i < regionNames.length; i++) {
            regions[i] = new Region(random.nextInt(((i * 5)) + i * 5 + 1), random.nextInt((i * 5) + i * 5 + 1)
                    , TechLevel.getRandomTech(), regionNames[i]);
        }
    }

    public Region getRandomRegion() {
        int regionNum = random.nextInt(regions.length);
        return regions[regionNum];
    }
    //create all regions
}
