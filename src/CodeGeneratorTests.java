import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CodeGeneratorTests {
    PegColour pegColours;
    PegColour pegColoursOther;
    int codeLength;
    CodeGenerator codeGenerator;

    @Before
    public final void setUp() {
        pegColours = new PegColourImpl("blue", "green", "orange", "purple", "red", "yellow");
        pegColoursOther = new PegColourImpl("apricot", "cobalt", "denim", "ecru", "flax", "indigo");
        codeLength = 4;
        codeGenerator = new CodeGeneratorImpl();
    }

    @Test
    public void testLength()
    {
        assertEquals(codeGenerator.getCode(pegColours,codeLength ).numberOfPegs(),4);
    }

    @Test
    public void testLegitimateColours(){
        List<String> possibleCodeComponents = pegColours.getAllColours().stream().map(s->{return s.substring(0,1).toUpperCase();}).collect(Collectors.toList());
        List<String> codeList = codeGenerator.getCode(pegColours,codeLength ).getLine().stream().map(peg->{return peg.getPegColour().substring(0,1).toUpperCase();}).collect(Collectors.toList());

        for(String s:codeList){
            assertTrue(possibleCodeComponents.contains(s));
        }
    }
    @Test
    public void testNotLegitimateColours(){
        List<String> possibleCodeComponents = pegColoursOther.getAllColours().stream().map(s->{return s.substring(0,1).toUpperCase();}).collect(Collectors.toList());
        List<String> codeList = codeGenerator.getCode(pegColours,codeLength ).getLine().stream().map(peg->{return peg.getPegColour().substring(0,1).toUpperCase();}).collect(Collectors.toList());

        for(String s:codeList){
            assertTrue(!possibleCodeComponents.contains(s));
        }
    }
}
