public interface Analyser {
    /**
     *
     * @param code
     */
    //void setCode(Line code);

    /**
     * called to check user guess versus code
     * @param guess
     */
    Line analyseGuess(Line guess);

    /**
     *
     * @return
     */
    Line getScrambledPegResult();

    /**
     *
     * @param s
     * @return
     */
    Line stringToLine(String s);

    /**
     *
     * @return
     */
    boolean checkIfWon();



}
