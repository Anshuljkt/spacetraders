public class Game {

    private String difficulty;
    private Player player;
    private MainGame game;
    private final String[] regionNames = {"John Land", "Mariaopolis", "Fordton", "Anshul Andromeda", "Star Cluster X"
            , "Sun", "Earth", "Region 8", "Region 9", "Region 10"};

    public Game(String diff, Player player) {
        this.difficulty = diff;
        this.player = player;
        startGame();
        game = new MainGame();
        game.PlayGame();
    }

    public void startGame() {
        Universe universe = new Universe(regionNames);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String[] getRegionNames() {
        return regionNames;
    }
}
