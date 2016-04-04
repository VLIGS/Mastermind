import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/beans.xml"})
public class ErrorCheckerTests {
    @Autowired
    private ErrorChecker errorChecker;

    @Before
    public final void setUp() {
    }

    @Test
    public void testForNull()
    {
        String guess = null;
        assertEquals(errorChecker.isValidGuess(guess),false);
    }
    @Test
    public void testLength()
    {
        String guess = "YYY";
        assertEquals(errorChecker.isValidGuess(guess),false);
    }
    @Test
    public void testLegitimateColours()
    {
        String guess = "YYYY";
        assertEquals(errorChecker.isValidGuess(guess),true);
    }
    @Test
    public void testNotLegitimateColours()
    {
        String guess = "YYYX";
        assertEquals(errorChecker.isValidGuess(guess),false);
    }
    @Test
    public void testNotUpperCase()
    {
        String guess = "YYYy";
        assertEquals(errorChecker.isValidGuess(guess),false);
    }
    public void testMixedString()
    {
        String guess = "1Y@y";
        assertEquals(errorChecker.isValidGuess(guess),false);
    }

}
