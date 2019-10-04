public class Game {

    private String difficulty;
    private Player player;
    private final String[] regionNames = {"John Land", "Mariaopolis", "Fordton", "Anshul Andromeda", "Star Cluster X"
            , "Sun", "Earth", "Region 8", "Region 9", "Region 10"};

    public Game(String diff, Player player) {
        this.difficulty = diff;
        this.player = player;
        startGame();
    }

    public void startGame() {
        Universe universe = new Universe(regionNames);
    }

}
