import java.util.Random;

public class Universe {

    private Region[] regions;
    private Random random = new Random();

    public Universe(String[] regionNames) {
        for (int i = 0; i < regionNames.length; i++) {
            regions[i] = new Region(random.nextInt((i * 5) + i * 5), random.nextInt((i * 5) + i * 5)
                    , TechLevel.getRandomTech(), regionNames[i]);
        }
    }
    //create all regions
}
