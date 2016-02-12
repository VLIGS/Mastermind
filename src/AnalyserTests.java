import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnalyserTests {
    private Analyser analyser;
    private Line guess;
    private Line code;

    @Before
    public final void setUp() {
        //analyser = new AnalyserImpl();
        analyser = Factory.getAnalyser();
        code = new LineImpl(new PegImpl("R"),new PegImpl("B"), new PegImpl("Y"), new PegImpl("G"));
    }

    @Test
    public void test_analyseGuess_with_AllMatchingPegsAllMatchingPosition() {
        guess = new LineImpl();
        Line expected = new LineImpl();
        for (int i = 0; i<code.numberOfPegs(); i++){
            guess.addPeg(new PegImpl(code.getPeg(i).getPegColour()));
        }
        for (int i = 0; i<code.numberOfPegs(); i++){
            expected.addPeg(new PegImpl(Feedback.getExactMatch()));
        }
        Line actual = analyser.analyseGuess(guess, code);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test_analyseGuess_with_AllMatchingPegsNotMatchingPosition () {
        Line expected = new LineImpl();
        guess = new LineImpl();

        for (int i = code.numberOfPegs()-1; i>=0; i--){
            guess.addPeg(new PegImpl(code.getPeg(i).getPegColour()));
        }
        for (int i = 0; i<code.numberOfPegs(); i++){
            expected.addPeg(new PegImpl(Feedback.getSymbolMatch()));
        }
        Line actual = analyser.analyseGuess(guess,code);
        assertEquals(expected.toString(),actual.toString());
    }

    @Test
    public void test_analyseGuess_with_NoMatchingPegs () {
        guess = new LineImpl(new PegImpl("P"),new PegImpl("P"), new PegImpl("P"), new PegImpl("P"));
        Line expected = new LineImpl(new PegImpl(Feedback.getNoMatch()));
        Line actual = analyser.analyseGuess(guess,code);
        assertEquals(expected.toString(),actual.toString());
    }

    @Test
    public void test_IfWon_with_NoMatchingPegs () {
        guess = new LineImpl(new PegImpl("P"),new PegImpl("P"), new PegImpl("P"), new PegImpl("P"));
        assertEquals(false, analyser.checkIfWon(analyser.analyseGuess(guess,code),code.numberOfPegs()));
    }

    @Test
    public void test_IfWon_with_AllMatchingPegsAllMatchingPosition () {
        guess = new LineImpl();
        for (int i = 0; i<code.numberOfPegs(); i++){
            guess.addPeg(new PegImpl(code.getPeg(i).getPegColour()));
        }
        assertEquals(true, analyser.checkIfWon(analyser.analyseGuess(guess,code),code.numberOfPegs()));
    }

    @Test
    public void test_IfWon_with_OnlyOneMatchingPegOneMatchingPosition () {
        Peg notMatchingPeg = new PegImpl("O");
        guess = new LineImpl();
        for (int i = 0; i<code.numberOfPegs(); i++){
            guess.addPeg(notMatchingPeg);
        }
        guess.setPeg(0,code.getPeg(0).getPegColour());
        assertEquals(false, analyser.checkIfWon(analyser.analyseGuess(guess,code),code.numberOfPegs()));
    }

}
