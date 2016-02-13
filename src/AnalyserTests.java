import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnalyserTests {
    private Analyser analyser;
    private Line guess;
    private Line code;


    @Before
    public final void setUp() {
        analyser = Factory.getAnalyser();
        code = Factory.getLine();
        code.addPeg(Factory.getPeg("R"), Factory.getPeg("B"),Factory.getPeg("Y"),Factory.getPeg("G"));
    }

    @Test
    public void test_analyseGuess_with_AllMatchingPegsAllMatchingPosition() {
        guess = Factory.getLine();
        Line expected = Factory.getLine();
        for (int i = 0; i<code.numberOfPegs(); i++){
            guess.addPeg(Factory.getPeg(code.getPeg(i).getPegColour()));
        }
        for (int i = 0; i<code.numberOfPegs(); i++){
            expected.addPeg(Factory.getPeg(Feedback.getExactMatch()));
        }
        Line actual = analyser.analyseGuess(guess, code);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test_analyseGuess_with_AllMatchingPegsNotMatchingPosition () {
        guess = Factory.getLine();
        Line expected = Factory.getLine();

        for (int i = code.numberOfPegs()-1; i>=0; i--){
            guess.addPeg(Factory.getPeg(code.getPeg(i).getPegColour()));
        }
        for (int i = 0; i<code.numberOfPegs(); i++){
            expected.addPeg(Factory.getPeg(Feedback.getSymbolMatch()));
        }
        Line actual = analyser.analyseGuess(guess,code);
        assertEquals(expected.toString(),actual.toString());
    }

    @Test
    public void test_analyseGuess_with_NoMatchingPegs () {
        guess = Factory.getLine();
        guess.addPeg(Factory.getPeg("P"),Factory.getPeg("P"), Factory.getPeg("P"), Factory.getPeg("P"));
        Line expected = Factory.getLine();
        expected.addPeg(Factory.getPeg(Feedback.getNoMatch()));
        Line actual = analyser.analyseGuess(guess,code);
        assertEquals(expected.toString(),actual.toString());
    }

    @Test
    public void test_IfWon_with_NoMatchingPegs () {
        guess = Factory.getLine();
        guess.addPeg(Factory.getPeg("P"),Factory.getPeg("P"), Factory.getPeg("P"), Factory.getPeg("P"));
        assertEquals(false, analyser.checkIfWon(analyser.analyseGuess(guess,code),code.numberOfPegs()));
    }

    @Test
    public void test_IfWon_with_AllMatchingPegsAllMatchingPosition () {
        guess = Factory.getLine();
        for (int i = 0; i<code.numberOfPegs(); i++){
            guess.addPeg(Factory.getPeg(code.getPeg(i).getPegColour()));
        }
        assertEquals(true, analyser.checkIfWon(analyser.analyseGuess(guess,code),code.numberOfPegs()));
    }

    @Test
    public void test_IfWon_with_OnlyOneMatchingPegOneMatchingPosition () {
        Peg notMatchingPeg = Factory.getPeg("O");
        guess = Factory.getLine();
        for (int i = 0; i<code.numberOfPegs(); i++){
            guess.addPeg(notMatchingPeg);
        }
        guess.setPeg(0,code.getPeg(0).getPegColour());
        assertEquals(false, analyser.checkIfWon(analyser.analyseGuess(guess,code),code.numberOfPegs()));
    }
}
