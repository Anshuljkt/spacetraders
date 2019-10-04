import java.util.Random;

public enum TechLevel {
    PREAGRICULTURAL, AGRICULTURE, MEDIEVAL, RENAISSANCE, INDUSTRIAL, MODERN,
            FUTURISTIC;

    public static TechLevel getRandomTech() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
