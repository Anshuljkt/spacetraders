public class Game {

    private String difficulty;
    private Player player;
    private final String[] regionNames = {"John Land", "Mariaopolis", "Fordton", "Anshul Andromeda", "Star Cluster X"
            , "Sun", "Earth", "Region 8", "Region 9", "Region 10"};
    private Universe universe;

    public Game(String diff, Player player) {
        this.difficulty = diff;
        this.player = player;
        this.universe = new Universe(regionNames);
        player.setRegion(universe.getRandomRegion());
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
