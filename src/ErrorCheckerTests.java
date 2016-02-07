import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ErrorCheckerTests {
    PegColour pegColours;
    PegColour pegColoursOther;
    NumberOfPegs codeLength;
    ErrorChecker errorChecker;

    @Before
    public final void setUp() {
        pegColours = new PegColourImpl("blue", "green", "orange", "purple", "red", "yellow");
        pegColoursOther = new PegColourImpl("apricot", "cobalt", "denim", "ecru", "flax", "indigo");
        codeLength = new NumberOfPegs(4);
        errorChecker = new ErrorCheckerImpl();
    }

    @Test
    public void testForNull()
    {
        String guess = null;
        assertEquals(errorChecker.isValidGuess(guess, pegColours.getAllColours(), codeLength.getNumberOfPegs()),false);
    }
    @Test
    public void testLength()
    {
        String guess = "YYY";
        assertEquals(errorChecker.isValidGuess(guess, pegColours.getAllColours(), codeLength.getNumberOfPegs()),false);
    }
    @Test
    public void testLegitimateColours()
    {
        String guess = "YYYY";
        assertEquals(errorChecker.isValidGuess(guess, pegColours.getAllColours(), codeLength.getNumberOfPegs()),true);
    }
    @Test
    public void testNotLegitimateColours()
    {
        String guess = "YYYX";
        assertEquals(errorChecker.isValidGuess(guess, pegColours.getAllColours(), codeLength.getNumberOfPegs()),false);
    }
    @Test
    public void testNotUpperCase()
    {
        String guess = "YYYy";
        assertEquals(errorChecker.isValidGuess(guess, pegColours.getAllColours(), codeLength.getNumberOfPegs()),false);
    }

}
