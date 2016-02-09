public class AnalyserImpl implements Analyser{

    @Override
    public Line  analyseGuess(Line guess, Line code){
        int exactMatch = 0;
        int colourMatch = 0;
        boolean[] codeUsed = new boolean[code.numberOfPegs()];
        boolean[] guessUsed = new boolean[guess.numberOfPegs()];

        Line unscrambledResult = new LineImpl(); //Spring

        // Compare correct color and position
        for (int i = 0; i < code.numberOfPegs(); i++) {
            if (code.getPeg(i).getPegColour().equals(guess.getPeg(i).getPegColour())) {
                exactMatch++;
                unscrambledResult.addPeg(new PegImpl(Feedback.getExactMatch()));
                codeUsed[i] = guessUsed[i] = true;
            }
        }

        // Compare matching colors for "pins" that were not used
        for (int i = 0; i < code.numberOfPegs(); i++) {
            for (int j = 0; j < guess.numberOfPegs(); j++) {
                if (!codeUsed[i] && !guessUsed[j] && code.getPeg(i).getPegColour().equals(guess.getPeg(j).getPegColour())) {
                    colourMatch++;
                    unscrambledResult.addPeg(new PegImpl(Feedback.getSymbolMatch()));
                    codeUsed[i] = guessUsed[j] = true;
                    break;
                }
            }
        }


        if(exactMatch == 0 && colourMatch == 0){
            unscrambledResult.addPeg(new PegImpl(Feedback.getNoMatch()));
        }
        return unscrambledResult;
    }

    /**
    @Override
    public Line getScrambledPegResult(){
        return null;
    }
     **/
    @Override
    public boolean checkIfWon(Line line){
        Line winningFeedback = new LineImpl(); //Spring

        for(int i = 0; i<line.numberOfPegs(); i++){
            winningFeedback.addPeg(new PegImpl(Feedback.getExactMatch())); //Spring
        }

        if(line.toString().equals(winningFeedback.toString())){
            return true;
        }
        return false;
    }
}
