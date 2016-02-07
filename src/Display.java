
public interface Display {
    void displayInstructions(PegColour pegColour, int numberOfPegs, int numberOfGuesses);
    void displayInstructions(String instruction);
    String getGuess(int numberOfGuesses);
}
