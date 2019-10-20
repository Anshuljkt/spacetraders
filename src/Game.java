public class Game {

    private static String difficulty;
    private static Player player;
    private static final String[] REGION_NAMES = {"John Land", "Mariaopolis", "Fordton"
            , "Anshul Andromeda", "Xandar", "Coruscant", "Knowhere", "The Death Star", "Space 2"
            , "Region McRegionFace", "Star Bar", "Kennedy Space Port", "Whiteclaw Cluster"};
    private static Universe universe;

    public Game(String diff, Player player) {
        Game.difficulty = diff;
        Game.player = player;
        Game.universe = new Universe(REGION_NAMES, player.getMerchant());
        player.setRegion(universe.getRandomRegion());
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        Game.player = player;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        Game.difficulty = difficulty;
    }

    public String[] getRegionNames() {
        return REGION_NAMES;
    }

    public Universe getUniverse() {
        return universe;
    }

}
