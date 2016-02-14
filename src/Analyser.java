public interface Analyser {
    /**
     * called to check user guess versus code
     * @param guess
     */
    Line analyseGuess(Line guess, Line code);

    /**
     *
     * @return
     */
    boolean checkIfWon(Line line, int length);





}
