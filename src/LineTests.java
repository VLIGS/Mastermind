import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LineTests {

    @Test
    public void testToString() {
        Line line = Factory.getLine();
        line.addPeg(Factory.getPeg("R"), Factory.getPeg("B"),Factory.getPeg("Y"),Factory.getPeg("G"));
        String expected="RBYG";
        String actual = line.toString();
        assertEquals(expected,actual);
    }
    @Test
    public void testAddPeg() {
        Line line = Factory.getLine();
        line.addPeg(Factory.getPeg("G"), Factory.getPeg("G"),Factory.getPeg("G"),Factory.getPeg("G"));
        String expected="GGGG";
        String actual = line.toString();
        assertEquals(expected,actual);
    }
}
