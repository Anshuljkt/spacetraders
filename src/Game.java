public class Game {

    private String difficulty;
    private Player player;
    private final String[] regionNames = {"John Land", "Mariaopolis", "Fordton", "Anshul Andromeda"
            , "Xandar", "Coruscant", "Knowhere", "The Death Star", "Space 2"
            , "Region McRegionFace", "Star Bar", "Kennedy Space Port", "Whiteclaw Cluster"};
    private Universe universe;

    public Game(String diff, Player player) {
        this.difficulty = diff;
        this.player = player;
        this.universe = new Universe(regionNames, player.getMerchant());
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

    public Universe getUniverse() {
        return universe;
    }
}
