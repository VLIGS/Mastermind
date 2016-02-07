import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CodeGeneratorTests {

    @Test
    public void testLength()
    {
        PegColour myPegColours = new PegColourImpl("blue", "green", "orange", "purple", "red", "yellow");
        int codeLength = 4;
        CodeGenerator codeGenerator = new CodeGeneratorImpl();
        assertEquals(codeGenerator.getCode(myPegColours,codeLength ).numberOfPegs(),4);

        List<String> possibleCodeComponents = myPegColours.getAllColours().stream().map(s->{return s.substring(0,1).toUpperCase();}).collect(Collectors.toList());
        List<String> codeList = codeGenerator.getCode(myPegColours,codeLength ).getLine().stream().map(peg->{return peg.getPegColour().substring(0,1).toUpperCase();}).collect(Collectors.toList());

        for(String s:codeList){
            assertTrue(possibleCodeComponents.contains(s));
        }
    }

    @Test
    public void testLegitimateColours(){
        
    }
}
