import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ErrorCheckerImpl implements ErrorChecker{
    @Autowired
    private PegColour pegColour;
    @Autowired
    private NumberOfPegs numberOfPegs;
    @Override
    public boolean isValidGuess(String guess) {
        if(guess == null){
            return false;
        }
        if (guess.length() != numberOfPegs.getNumberOfPegs()){
            return false;
        }
        if(!guess.equals(guess.toUpperCase())){
            return false;
        }
        List<String> capitalLetterOfColours = pegColour.getColours().stream().map(s->s.substring(0,1).toUpperCase()).collect(Collectors.toList());

        return guess.chars().mapToObj(i->(char)i).allMatch(g->capitalLetterOfColours.contains(String.valueOf(g)));

        /**
        for(int i = 0; i < guess.length(); i++){
            if(!capitalLetterOfColours.contains(guess.substring(i, i+1))){
                return false;
            }
        }
         **/
        //return true;
    }
}
