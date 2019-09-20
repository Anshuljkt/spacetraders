public class Player {
    private String name;
    private String difficulty;
    private int pilot;
    private int fighter;
    private int merchant;
    private int engineer;

    public Player(String name, String difficulty, int pilot, int fighter, int merchant, int engineer) {
        this.name = name;
        this.difficulty = difficulty;
        this.pilot = pilot;
        this.fighter = fighter;
        this.merchant = merchant;
        this.engineer = engineer;
    }

    @Override
    public String toString() {
        return "Player Details:" +
                "\nname=" + name +
                "\ndifficulty=" + difficulty +
                "\npilot=" + pilot +
                "\nfighter=" + fighter +
                "\nmerchant=" + merchant +
                "\nengineer=" + engineer;
    }
}
