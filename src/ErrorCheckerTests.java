import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ErrorCheckerTests {
    private ErrorChecker errorChecker;

    @Before
    public final void setUp() {
        errorChecker = Factory.getErrorChecker();
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
