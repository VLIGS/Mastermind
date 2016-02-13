import java.util.ArrayList;
import java.util.List;

public class PegColourImpl implements PegColour {
    private List<String> colours = new ArrayList<String>();

    /**
    public PegColourImpl(String ... colours){
        for(String c: colours){
            myColours.add(c);
        }
    }
     **/
    @Override
    public void setColours(List<String> colours){
        this.colours = colours;
    }
    @Override
    public int getLength(){
        return colours.size();
    }

    @Override
    public String getColour(int index){
        return colours.get(index);
    }

    @Override
    public List<String> getColours(){
        return colours;
    }
    /**
    public void setPegColours(){
        String[] coloursAarray = colours.split(" ");
        for(String c: coloursAarray){
            myColours.add(c);
        }
    }
     **/
}
