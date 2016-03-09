import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/beans.xml"})
@Configurable
public class ScramblerTests {
    @Autowired
    Scrambler scrambler;
    @Before
    public final void setUp() {
        //scrambler = Factory.getScrambler();
    }


    @Test
    public void testScrambled() {
        Line input = Factory.getLine();
        input.addPeg(new PegImpl(Feedback.getSymbolMatch()),new PegImpl(Feedback.getExactMatch()), new PegImpl(Feedback.getSymbolMatch()), new PegImpl(Feedback.getSymbolMatch()));
        Line output = scrambler.scramble(input);
        assertNotEquals(input.toString(),output.toString());
    }

    @Test
    public void testScrambledAllSamePegs() {
        Line input = Factory.getLine();
        input.addPeg(Factory.getPeg(Feedback.getSymbolMatch()),Factory.getPeg(Feedback.getSymbolMatch()), Factory.getPeg(Feedback.getSymbolMatch()), Factory.getPeg(Feedback.getSymbolMatch()));
        Line output = scrambler.scramble(input);
        assertEquals(input.toString(),output.toString());
    }
}
