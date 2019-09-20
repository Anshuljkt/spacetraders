public class Player {
    private String name;
    private String difficulty;
    private int pilot;
    private int fighter;
    private int merchant;
    private int engineer;
    private int credits;

    public Player(String name, String difficulty, int pilot, int fighter, int merchant, int engineer) {
        this.name = name;
        this.difficulty = difficulty;
        this.pilot = pilot;
        this.fighter = fighter;
        this.merchant = merchant;
        this.engineer = engineer;

        if (difficulty.equals("Easy")) {
            this.credits = 1000;
        } else if (difficulty.equals("Medium")) {
            this.credits = 750;
        } else if (difficulty.equals("Hard")) {
            this.credits = 500;
        } else {
            this.difficulty = "Easy";
            this.credits = 1000;
        }
    }

    public String[] toArray() {
        String[] response = new String[7];
        response[0] = "Name: " + name;
        response[1] = "Difficulty: " + difficulty;
        response[2] = "Pilot: " + pilot;
        response[3] = "Fighter: " + fighter;
        response[4] = "Merchant: " + merchant;
        response[5] = "Engineer: " + engineer;
        response[6] = "Credits: " + credits;

        return response;
    }
}
