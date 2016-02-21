import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CodeGeneratorTests {
    PegColour pegColours;
    PegColour pegColoursOther;
    NumberOfPegs codeLength;
    CodeGenerator codeGenerator;

    @Before
    public final void setUp() {
        pegColours= Factory.getPegColours();
        pegColoursOther = Factory.getPegColours();
        List<String> colours = new ArrayList<>();
        colours.add("apricot");
        colours.add("cobalt");
        colours.add("denim");
        colours.add("ecru");
        colours.add("flax");
        colours.add("indigo");
        pegColoursOther.setColours(colours);
        codeLength = Factory.getNumberOfPegs();
        codeGenerator = Factory.getCodeGenerator();
    }

    @Test
    public void testLength()
    {
        assertEquals(codeGenerator.getCode().numberOfPegs(),4);

    }

    @Test
    public void testLegitimateColours(){
        List<String> possibleCodeComponents = pegColours.getColours().stream().map(s->s.substring(0,1).toUpperCase()).collect(Collectors.toList());
        List<String> codeList = codeGenerator.getCode().getLine().stream().map(peg->peg.getPegColour().substring(0,1).toUpperCase()).collect(Collectors.toList());

        for(String s:codeList){
            assertTrue(possibleCodeComponents.contains(s));
        }
    }

    @Test
    public void testNotLegitimateColours(){
        List<String> possibleCodeComponents = pegColoursOther.getColours().stream().map(s->s.substring(0,1).toUpperCase()).collect(Collectors.toList());
        List<String> codeList = codeGenerator.getCode().getLine().stream().map(peg->peg.getPegColour().substring(0,1).toUpperCase()).collect(Collectors.toList());

        for(String s:codeList){
            assertTrue(!possibleCodeComponents.contains(s));
        }
    }
}
