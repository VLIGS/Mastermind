//@Service
public class AnalyserImpl implements Analyser{
    private Feedback feedback = Factory.getFeedback();

    @Override
    public Line  analyseGuess(Line guess, Line code){
        int exactMatch = 0;
        int colourMatch = 0;
        boolean[] codeUsed = new boolean[code.numberOfPegs()];
        boolean[] guessUsed = new boolean[guess.numberOfPegs()];

        Line unscrambledResult = Factory.getLine();

        // Compare correct color and position
        for (int i = 0; i < code.numberOfPegs(); i++) {
            if (code.getPeg(i).getPegColour().equals(guess.getPeg(i).getPegColour())) {
                exactMatch++;
                unscrambledResult.addPeg(Factory.getPeg(feedback.getExactMatch()));
                codeUsed[i] = guessUsed[i] = true;
            }
        }

        // Compare matching colors for "pins" that were not used
        for (int i = 0; i < code.numberOfPegs(); i++) {
            for (int j = 0; j < guess.numberOfPegs(); j++) {
                if (!codeUsed[i] && !guessUsed[j] && code.getPeg(i).getPegColour().equals(guess.getPeg(j).getPegColour())) {
                    colourMatch++;
                    unscrambledResult.addPeg(Factory.getPeg(feedback.getSymbolMatch()));
                    codeUsed[i] = guessUsed[j] = true;
                    break;
                }
            }
        }

        if(exactMatch == 0 && colourMatch == 0){
            unscrambledResult.addPeg(Factory.getPeg(feedback.getNoMatch()));
        }
        return unscrambledResult;
    }

    @Override
    public boolean checkIfWon(Line line, int length){
        Line winningFeedback = Factory.getLine();

        for(int i = 0; i<length; i++){
            winningFeedback.addPeg(Factory.getPeg(feedback.getExactMatch()));
        }

        if(line.toString().equals(winningFeedback.toString())){
            return true;
        }
        return false;
    }
}
