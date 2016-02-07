import java.util.List;
import java.util.stream.Collectors;

public class ErrorCheckerImpl implements ErrorChecker{
    @Override
    public boolean isValidGuess(String guess, List<String> colours, int codeLength ) {
        if(guess == null){
            return false;
        }
        if (guess.length() != codeLength){
            return false;
        }
        if(!guess.equals(guess.toUpperCase())){
            return false;
        }
        List<String> capitalLetterOfColours = colours.stream().map(s->{return s.substring(0,1).toUpperCase();}).collect(Collectors.toList());
        for(int i = 0; i < guess.length(); i++){
            if(!capitalLetterOfColours.contains(guess.substring(i, i+1))){
                return false;
            }
        }
        return true;
    }
}
