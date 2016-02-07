
public class PegImpl implements Peg{
    private String colour;
    public PegImpl(String colour){
        this.colour = colour;
    }
    public String getPegColour(){
        return colour;
    }
}
