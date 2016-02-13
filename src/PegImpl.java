
public class PegImpl implements Peg{
    private String colour;
    public PegImpl(){}
    public PegImpl(String colour){
        this.colour = colour;
    }
    public void setPeg(String colour){
        this.colour = colour;
    }
    public String getPegColour(){
        return colour;
    }
}
