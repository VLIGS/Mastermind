import java.util.List;

public interface Display {
    void displayStartingInstructions();
    void displayInstructions(String instruction);
    void displayInstructions(String instruction, boolean showCode);
    void displayResults(List guesses, List results);
    void displayWin(List guesses, List results);
    void displayLoss();
    String getUserChoice();
    String getGuess(int numberOfGuesses);
}
