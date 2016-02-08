public class AnalyserImpl implements Analyser{
    @Override
    public Line  analyseGuess(Line guess, Line code){
        int numberOfBlacks = 0;
        int numberOfWhites = 0;

        Line unscrambledResult = new LineImpl(); //Spring
        for(int i = 0; i < guess.numberOfPegs(); i ++){
            String pegColour = code.getPeg(i).getPegColour();
            for(int j = 0; j < guess.numberOfPegs(); j++){
                if(pegColour.equals(guess.getPeg(j).getPegColour())){
                    if (i == j){
                        unscrambledResult.addPeg(new PegImpl(Feedback.getExactMatch())); //Spring
                        //System.out.println(FeedbackColours.getNameFor(FeedbackColours.EXACTMATCH));
                        numberOfBlacks++;
                    } else {
                        unscrambledResult.addPeg(new PegImpl(Feedback.getSymbolMatch())); //Spring
                        //System.out.println(FeedbackColours.getNameFor(FeedbackColours.MATCH));
                        numberOfWhites++;
                    }
                }
            }
        }

        if(numberOfBlacks == 0 && numberOfWhites == 0){
            unscrambledResult.addPeg(new PegImpl(Feedback.getNoMatch()));
        }
        return unscrambledResult;
    }
    @Override
    public Line getScrambledPegResult(){
        return null;
    }
    @Override
    public boolean checkIfWon(Line line){
        Line winningFeedback = new LineImpl(new PegImpl(Feedback.getExactMatch()), new PegImpl(Feedback.getExactMatch()), new PegImpl(Feedback.getExactMatch()), new PegImpl(Feedback.getExactMatch()));
        if(line.toString().equals(winningFeedback.toString())){
            return true;
        }
        return false;
    }
}
