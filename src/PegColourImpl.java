import java.util.ArrayList;
import java.util.List;

public class PegColourImpl implements PegColour {
    private List<String> colours = new ArrayList<String>();

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

}
