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

    /**
     *
     * @param s
     * @return
     */
    static Line stringToLine(String s){
        Line line = new LineImpl(); //Spring

        for(int i = 0; i < s.length(); i ++){
            line.addPeg(new PegImpl(s.substring(i,i+1))); //Spring
        }
        return line;
    }
}
