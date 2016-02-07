
public interface Display {
    void displayInstructions(PegColour pegColour, NumberOfPegs numberOfPegs, NumberOfGuesses numberOfGuesses);
    void displayInstructions(String instruction);
    String getGuess(NumberOfGuesses numberOfGuesses);
}
