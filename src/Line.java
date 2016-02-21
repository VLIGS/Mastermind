import java.util.List;
import java.util.stream.IntStream;

public interface Line {

    void  addPeg(Peg ... pegs);
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
     */
    void setPeg(int n, String s);
    void setLine(List<Peg> line);

    /**
     *
     * @param s
     * @return
     */
    static Line stringToLine(String s){
        Line line = Factory.getLine();

        IntStream.range(0,s.length() )
                .forEach(i->line.addPeg(Factory.getPeg(s.substring(i,i+1))));
        return line;
    }
}
