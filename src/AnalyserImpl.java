public class AnalyserImpl implements Analyser{
    @Override
    public Line  analyseGuess(Line guess, Line code){
        int numberOfBlacks = 0;
        int numberOfWhites = 0;

        Line unscrambledPegResult = new LineImpl(); //Spring
        /**
        for(int i = 0; i < guess.numberOfPegs(); i ++){
            String pegColourCode = code.getPeg(i).getPegColour();
            for(int j = 0; j < guess.numberOfPegs(); j++){
                if(pegColourCode.equals(guess.getPeg(j).getPegColour())){
                    if (i == j){

                        //unscrambledPegResult.addPeg(new PegFB("BLACK"));
                        unscrambledResult.add(FeedbackColours.EXACTMATCH);
                        System.out.println(FeedbackColours.getNameFor(FeedbackColours.EXACTMATCH));
                        //unscrambledPegResult.addPeg(new Peg("B"));
                        numberOfBlacks++;
                    } else {
                        // unscrambledPegResult.addPeg(new PegFB("WHITE"));
                        // unscrambledPegResult.addPeg(new Peg("W"));
                        unscrambledResult.add(FeedbackColours.MATCH);
                        System.out.println(FeedbackColours.getNameFor(FeedbackColours.MATCH));
                        numberOfWhites++;
                    }
                }
            }
        }
        if(numberOfBlacks == code.numberOfPegs()){
            win = true;
        }
        if(numberOfBlacks == 0 && numberOfWhites == 0){
            unscrambledResult.add(FeedbackColours.NOMATCH);
        }
        return unscrambledResult;
 **/
        return unscrambledPegResult;
    }
    @Override
    public Line getScrambledPegResult(){
        return null;
    }
    @Override
    public boolean checkIfWon(){
        return true;
    }
}
