import java.util.Random;

public enum TechLevel {
    PREAGRICULTURAL(2), AGRICULTURE(1.75), MEDIEVAL(1.6), RENAISSANCE(1.45),
    INDUSTRIAL(1.3), MODERN(1.15), FUTURISTIC(1);

    double priceAdjust;

    TechLevel(double priceAdjust) {
        this.priceAdjust = priceAdjust;
    }

    public static TechLevel getRandomTech() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

}
