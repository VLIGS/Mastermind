import java.util.HashSet;
import java.util.Set;

public class ScramblerImpl implements  Scrambler{
    @Override
    public Line scramble(Line input) {
        int size = input.numberOfPegs();
        Line output = Factory.getLine();
        Set<Integer> usedNumbers = new HashSet<>();
        int random = (int)(Math.random()*size);
        for(int i = 0; i < size; i ++){
            while (usedNumbers.contains(random)) {
                random = (int)(Math.random()*size);
            }
            output.addPeg(input.getPeg(random));
            usedNumbers.add(random);
        }
        return output;
    }
}
