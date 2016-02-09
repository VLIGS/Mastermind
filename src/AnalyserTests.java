import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnalyserTests {
    private Analyser analyser;
    private Line guess;
    private Line code;

    @Before
    public final void setUp() {
        analyser = new AnalyserImpl();
        code = new LineImpl(new PegImpl("R"),new PegImpl("B"), new PegImpl("Y"), new PegImpl("G"));
    }

    @Test
    public void test_analyseGuess_with_AllMatchingPegsAllMatchingPosition() {
        guess = new LineImpl(new PegImpl(code.getPeg(0).getPegColour()), new PegImpl(code.getPeg(1).getPegColour()), new PegImpl(code.getPeg(2).getPegColour()), new PegImpl(code.getPeg(3).getPegColour()));
        Line expected = new LineImpl(new PegImpl(Feedback.getExactMatch()), new PegImpl(Feedback.getExactMatch()), new PegImpl(Feedback.getExactMatch()), new PegImpl(Feedback.getExactMatch()));
        Line actual = analyser.analyseGuess(guess, code);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test_analyseGuess_with_AllMatchingPegsNotMatchingPosition () {
        guess = new LineImpl(new PegImpl(code.getPeg(3).getPegColour()),new PegImpl(code.getPeg(2).getPegColour()), new PegImpl(code.getPeg(1).getPegColour()), new PegImpl(code.getPeg(0).getPegColour()));
        Line expected = new LineImpl(new PegImpl(Feedback.getSymbolMatch()),new PegImpl(Feedback.getSymbolMatch()), new PegImpl(Feedback.getSymbolMatch()), new PegImpl(Feedback.getSymbolMatch()));
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
        assertEquals(false, analyser.checkIfWon(analyser.analyseGuess(guess,code)));
    }

    @Test
    public void test_IfWon_with_AllMatchingPegsAllMatchingPosition () {
        guess = new LineImpl(new PegImpl(code.getPeg(0).getPegColour()), new PegImpl(code.getPeg(1).getPegColour()), new PegImpl(code.getPeg(2).getPegColour()), new PegImpl(code.getPeg(3).getPegColour()));
        assertEquals(true, analyser.checkIfWon(analyser.analyseGuess(guess,code)));
    }

}
