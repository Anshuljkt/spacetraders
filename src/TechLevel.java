import java.util.Random;

public enum TechLevel {
    PREAGRICULTURAL(400), AGRICULTURE(350), MEDIEVAL(300), RENAISSANCE(200),
    INDUSTRIAL(100), MODERN(50), FUTURISTIC(0);

    int priceAdjust;

    TechLevel(int priceAdjust) {
        this.priceAdjust = priceAdjust;
    }

    public static TechLevel getRandomTech() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

}
