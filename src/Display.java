import java.util.List;

public interface Display {
    void displayInstructions(PegColour pegColour, int numberOfPegs, int numberOfGuesses);
    void displayInstructions(String instruction);
    void displayInstructions(String instruction, boolean showCode);
    void displayResults(List guesses, List results, int NumberOfGuessesAllowed);
    void displayWin(List guesses, List results);
    void displayLoss();
    String getUserChoice();
    String getGuess(int numberOfGuesses);
}
