import java.util.ArrayList;
import java.util.List;

public class LineImpl implements Line{
    private List<Peg> line = new ArrayList<>(); //Spring

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
    /**
    @Override
    public Line stringToLine(String s){

        Line line = new LineImpl(); //Spring

        for(int i = 0; i < s.length(); i ++){
            line.addPeg(new PegImpl(s.substring(i,i+1))); //Spring
        }
        return line;
    }
     **/

    @Override
    public String toString(){
            StringBuilder sb = new StringBuilder();
            for (Peg p : line) {
                sb.append(p.getPegColour());
            }
            return sb.toString();
    }

}
