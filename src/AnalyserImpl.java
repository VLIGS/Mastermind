import java.util.stream.IntStream;

public class AnalyserImpl implements Analyser{

    @Override
    public Line  analyseGuess(Line guess, Line code){

        int exactMatch = 0;
        int Match = 0;
        boolean[] codeFlags = new boolean[code.numberOfPegs()];
        boolean[] guessFlags = new boolean[guess.numberOfPegs()];
        Line unscrambledResult = Factory.getLine();
        //Line unscrambledResult = getLine();

        //code.getLine().stream().flatMap(i->guess.getLine().stream().map(j-> new Peg[]{i,j})).forEach(p->{if p()});

        for (int i = 0; i < code.numberOfPegs(); i++) {
            if (code.getPeg(i).getPegColour().equals(guess.getPeg(i).getPegColour())) {
                unscrambledResult.addPeg(Factory.getPeg(Feedback.getExactMatch()));
                exactMatch++;
                codeFlags[i] = true;
                guessFlags[i] = true;
            }
        }

        for (int i = 0; i < code.numberOfPegs(); i++) {
            for (int j = 0; j < guess.numberOfPegs(); j++) {
                if (!codeFlags[i] && !guessFlags[j] && code.getPeg(i).getPegColour().equals(guess.getPeg(j).getPegColour())) {
                    unscrambledResult.addPeg(Factory.getPeg(Feedback.getSymbolMatch()));
                    Match++;
                    codeFlags[i] = true;
                    guessFlags[j] = true;
                    break;
                }
            }
        }

        if(exactMatch == 0 && Match == 0){
            unscrambledResult.addPeg(Factory.getPeg(Feedback.getNoMatch()));
        }
        return unscrambledResult;
    }

    @Override
    public boolean checkIfWon(Line line, int length){

        Line winningFeedback = Factory.getLine();
        IntStream.range(0, length).forEach(i->winningFeedback.addPeg(Factory.getPeg(Feedback.getExactMatch())));
        return line.toString().equals(winningFeedback.toString());

    }

}
