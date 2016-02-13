import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScramblerTests {
    Scrambler scrambler;
    private Feedback feedback;
    @Before
    public final void setUp() {
        scrambler = Factory.getScrambler();
        feedback = Factory.getFeedback();
    }

    /**
    @Test
    public void testScrambled() {
        Line input = new LineImpl(new PegImpl(Feedback.getSymbolMatch()),new PegImpl(Feedback.getExactMatch()), new PegImpl(Feedback.getSymbolMatch()), new PegImpl(Feedback.getSymbolMatch()));
        Line output = scrambler.scramble(input);
        assertNotEquals(input.toString(),output.toString());
    }
     **/
    @Test
    public void testScrambledAllSamePegs() {
        Line input = Factory.getLine();
        input.addPeg(Factory.getPeg(feedback.getSymbolMatch()),Factory.getPeg(feedback.getSymbolMatch()), Factory.getPeg(feedback.getSymbolMatch()), Factory.getPeg(feedback.getSymbolMatch()));
        Line output = scrambler.scramble(input);
        assertEquals(input.toString(),output.toString());
    }
}
