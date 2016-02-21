import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.IntStream;

public class CodeGeneratorImpl implements CodeGenerator{
    @Autowired
    private RandomGenerator generator;
    @Autowired
    PegColour pegColours;
    @Autowired
    NumberOfPegs numberOfPegs;

    @Override
    public Line getCode(){
        Line code = Factory.getLine();
        int numberOfColours = pegColours.getLength();
        int numberPegs = numberOfPegs.getNumberOfPegs();

        IntStream.range(0,numberPegs )
                .forEach(i->code.addPeg(Factory.getPeg(pegColours.getColour(generator.generateRandomNumber(numberOfColours)).substring(0,1).toUpperCase())));
        return code;

    }
}
