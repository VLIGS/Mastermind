import java.util.List;

public interface Line {
    /**
     *
     * @param p
     */
    void addPeg(Peg p);

    /**
     *
     * @param pegIndex
     * @return
     */
    Peg getPeg(int pegIndex);

    /**
     *
     * @return
     */
    List<Peg> getLine();

    /**
     *
     * @return
     */
    int numberOfPegs();
}
