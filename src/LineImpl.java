import java.util.ArrayList;
import java.util.List;

public class LineImpl implements Line{
    private List<Peg> line = new ArrayList<>();

    @Override
    public void  addPeg(Peg ... pegs){
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
    public void setLine(List<Peg> line){
        this.line = line;
    }
    @Override
    public List<Peg> getLine(){
        return line;
    }
    @Override
    public int numberOfPegs(){
        return line.size();
    }
    public void setPeg(int index, String s){
        line.set(index, Factory.getPeg(s));
    }

    @Override
    public String toString(){
            StringBuilder sb = new StringBuilder();
            for (Peg p : line) {
                sb.append(p.getPegColour());
            }
            return sb.toString();
    }

}
