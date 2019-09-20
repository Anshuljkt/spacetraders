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

    public String[] toArray() {
        String[] response = new String[6];
        response[0] = "Name: " + name;
        response[1] = "Difficulty: " + difficulty;
        response[2] = "Pilot: " + pilot;
        response[3] = "Fighter: " + fighter;
        response[4] = "Merchant: " + merchant;
        response[5] = "Engineer: " + engineer;

        return response;
    }
}
