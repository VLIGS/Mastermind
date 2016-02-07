import java.util.ArrayList;
import java.util.List;

public class LineImpl implements Line{
    /**
     * Spring
     */
    //List<Peg> line = new ArrayList<>(); //does not work without specifying type inside <>
    private List<Peg> line = new ArrayList<Peg>(); //Spring

    public LineImpl (Peg ... pegs){
        for (Peg p: pegs){
            line.add(p);
        }
    }
    @Override
    public void  addPeg(Peg p){
        line.add(p);
    }
    @Override
    public Peg getPeg(int pegIndex){
        return line.get(pegIndex);
    }
    @Override
    public List<Peg> getLine(){
        return line;
    }
    @Override
    public int numberOfPegs(){
        return line.size();
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Peg p: line){
            sb.append(p.getPegColour());
        }
        return sb.toString();
    }
}
