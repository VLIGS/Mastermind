import java.util.ArrayList;
import java.util.List;

public class PegColourImpl implements PegColour {
    String colours;
    List<String> myColours = new ArrayList<String>();

    /**
    public PegColourImpl(String ... colours){
        for(String c: colours){
            myColours.add(c);
        }
    }
     **/
    public void setColours(String c){
        colours = c;
    }
    @Override
    public int getLength(){
        return myColours.size();
    }

    @Override
    public String getColour(int index){
        return myColours.get(index);
    }

    @Override
    public List<String> getAllColours(){
        return myColours;
    }
    public void setPegColours(){
        String[] coloursAarray = colours.split(" ");
        for(String c: coloursAarray){
            myColours.add(c);
        }
    }
}
