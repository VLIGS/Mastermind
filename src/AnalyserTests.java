import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AnalyserTests {
    private Analyser analyser;
    private Line guess;
    private Line code;
    @Before
    public final void setUp() {
        analyser = new AnalyserImpl();
        code = new LineImpl(new PegImpl("red"),new PegImpl("blue"), new PegImpl("yellow"), new PegImpl("green"));
    }
    @Test
    public void testAllMatchingPegsAllMatchingPosition() {
        guess = new LineImpl(new PegImpl("R"),new PegImpl("B"), new PegImpl("Y"), new PegImpl("G"));
        assertEquals(analyser.analyseGuess(guess,code),new LineImpl(new PegImpl("black"),new PegImpl("black"), new PegImpl("black"), new PegImpl("black")));
    }
    @Test
    public void testAllMatchingPegsNotMatchingPosition () {
        guess = new LineImpl(new PegImpl("G"),new PegImpl("Y"), new PegImpl("B"), new PegImpl("R"));
        assertEquals(analyser.analyseGuess(guess,code),new LineImpl(new PegImpl("white"),new PegImpl("white"), new PegImpl("white"), new PegImpl("white")));
    }
    @Test
    public void testAllMatchingPegsSecondMatchingPosition () {
        guess = new LineImpl(new PegImpl("G"),new PegImpl("B"), new PegImpl("R"), new PegImpl("Y"));
        assertEquals(analyser.analyseGuess(guess,code),new LineImpl(new PegImpl("white"),new PegImpl("black"), new PegImpl("white"), new PegImpl("white")));
    }
    @Test
    public void testNoMatchingPegs () {
        guess = new LineImpl(new PegImpl("P"),new PegImpl("P"), new PegImpl("P"), new PegImpl("P"));
        assertNull(analyser.analyseGuess(guess,code));
    }
}
