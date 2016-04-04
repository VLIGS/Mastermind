public class MastermindDriver {
    public static void main(String[] args) {
        Game g = Factory.getInstance(true);
        g.runGames();

        g = Factory.getInstance(false);
        g.runGames();
    }
}